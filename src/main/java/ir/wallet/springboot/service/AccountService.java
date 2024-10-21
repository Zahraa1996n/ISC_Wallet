package ir.wallet.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ir.wallet.springboot.persistence.model.Account;
import ir.wallet.springboot.persistence.model.Person;
import ir.wallet.springboot.persistence.repo.AccountRepository;
import ir.wallet.springboot.persistence.repo.PersonRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
    private PersonRepository personRepository;
	

	//Create account
    public Account createAccount(Account account, Long personId) {
        
    	Person person = personRepository.findById(personId).orElseThrow(() -> new RuntimeException("Person not found"));

       
        account.setPerson(person);
        System.out.println(person);
        return accountRepository.save(account);
        
    }
    
    //Receive all accounts
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
    
    //Get account based on ID
    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }
    
    //Update account information
    public Account updateAccount(Long id, Account updatedAccount) {
        Account account = accountRepository.findById(id).orElse(null);
        if (account != null) {
            account.setBalance(updatedAccount.getBalance());
            return accountRepository.save(account);
        }
        return null;
    }
    
    //Delete account
   
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
       

}
