package ir.wallet.springboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ir.wallet.springboot.persistence.model.Account;
import ir.wallet.springboot.service.AccountService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/create")
	public ResponseEntity<Account> createAccount(@RequestBody Account account, @RequestParam Long personId) {
		Account createdAccount = accountService.createAccount(account, personId);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
		
	}
	
	@GetMapping()
	public List<Account> getAllAccounts(){
		return accountService.getAllAccounts();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Account> getAccountById(@PathVariable Long id){
		Account account = accountService.getAccountById(id);
		if (account != null) {
			return new ResponseEntity<>(account, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Account> updateAccount(@PathVariable Long id, @RequestBody Account updatedAccount){
		Account account = accountService.updateAccount(id, updatedAccount);
		if (id != null) {
			return new ResponseEntity<>(account, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAccount(@PathVariable Long id){
		accountService.deleteAccount(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);	
	}
	
}
