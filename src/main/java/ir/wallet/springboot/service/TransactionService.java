package ir.wallet.springboot.service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ir.wallet.springboot.persistence.model.Account;
import ir.wallet.springboot.persistence.model.Transaction;
import ir.wallet.springboot.persistence.model.Type;
import ir.wallet.springboot.persistence.repo.AccountRepository;
import ir.wallet.springboot.persistence.repo.TransactionRepository;
import jakarta.transaction.Transactional;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	//create transaction
	@Transactional
	public Transaction createTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}
	
	//Receive all transaction
	public List<Transaction> getTransactionByAccount(Long accountId){
		return transactionRepository.findByAccountId(accountId);
		
	}
	
	//deposit
	@Transactional
	public Transaction deposit(Long accountId, Double amount, String description) {
		Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found"));

	    Transaction transaction = new Transaction();
	    
	    transaction.setAccount(account);
	    System.out.println("account is" + account);
	    transaction.setAmount(amount);
	    transaction.setDescriptionTransaction(description);
	    transaction.setAccountnumber(account.getAccountnumber());
	    transaction.setType(Type.DEPOSIT);
	    transaction.setDateTime(LocalDateTime.now());

	
	    double newBalance = account.getBalance() + amount;
	    transaction.setBalanceafterTransaction(newBalance);
	    
	    transactionRepository.save(transaction);
	 
	    account.setBalance(newBalance);
	    accountRepository.save(account);
	    
	    return transaction;

}
	
	//withdraw
	@Transactional
	public Transaction withdraw(Long accountId, double amount, String description) {
		Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found"));
		
        if (amount < 100000.0) {
            throw new RuntimeException("Minimum withdrawal amount is 100,000 Rials.");
        }
		
		List<Transaction> transactions = transactionRepository.findByAccountAndType(account, Type.WITHDRAW);
		
	    double totalWithdrawalsToday = transactions.stream()
	            .filter(t -> t.getDateTime().toLocalDate().isEqual(LocalDate.now()))
	            .mapToDouble(Transaction::getAmount)
	            .sum();
	    

	    
	    double maxWithdrawalAmount = 10_000_000.0; 
	    if (totalWithdrawalsToday + amount > maxWithdrawalAmount) {
	        throw new RuntimeException("Withdrawal limit exceeded for today");
	    }
		
		if (account.getBalance() < amount) {
			throw new RuntimeException("Insufficient balance");
		}
		
		account.setBalance(account.getBalance() - amount);
		accountRepository.save(account);
		
		Transaction transaction = new Transaction();
		transaction.setAccount(account);
		transaction.setAmount(amount);
		 transaction.setDateTime(LocalDateTime.now());
		transaction.setBalanceafterTransaction(account.getBalance());
		transaction.setDescriptionTransaction(description);
		transaction.setAccountnumber(account.getAccountnumber());
		transaction.setType(Type.WITHDRAW);
		
		return transactionRepository.save(transaction);	
	}

}


