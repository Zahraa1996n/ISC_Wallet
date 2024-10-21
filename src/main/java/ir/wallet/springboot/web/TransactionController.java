package ir.wallet.springboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ir.wallet.springboot.persistence.model.Transaction;
import ir.wallet.springboot.service.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/create")
	public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction){
		return new ResponseEntity<>(transactionService.createTransaction(transaction), HttpStatus.CREATED);
	}
	
	//Receive all transaction
	@GetMapping("/account/{accountId}")
	public ResponseEntity<List<Transaction>> getTransactionByAccount(@PathVariable Long accountId) {
		List<Transaction> transactions = transactionService.getTransactionByAccount(accountId);
		return new ResponseEntity<>(transactions, HttpStatus.OK);
	}
	
	
	@PostMapping("/deposit/{accountId}")
	public ResponseEntity<Transaction> deposit(@PathVariable Long accountId, @RequestParam Double amount, @RequestParam String description){
		Transaction transaction = transactionService.deposit(accountId, amount, description);
		return new ResponseEntity<>(transaction, HttpStatus.OK);
		
	}

	
	//withdrawal 
	@PostMapping("/withdrawal/{accountId}")
	public ResponseEntity<Transaction> withdrawal(@PathVariable Long accountId, @RequestParam double amount, @RequestParam String description){
		try {
			Transaction transaction = transactionService.withdraw(accountId, amount, description);
			return new ResponseEntity<>(transaction, HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} 
	}
	
}


