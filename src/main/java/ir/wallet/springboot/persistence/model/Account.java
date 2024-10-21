package ir.wallet.springboot.persistence.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;


@Entity
@Table(name="Account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Pattern(regexp = "\\d{13}", message = "Account number must be 13 digits")
	@Column(name = "ACCOUNT_NUMBER",  nullable = false, unique = true)
	private String accountNumber;
	
	@Min(value = 10000, message = "Balance must be at least 10,000 Rial")
	@Column(name = "BALANCE",  nullable = false)
	private Double balance;
	
	@Column(name = "accountCreationDate")
	private LocalDateTime accountCreationDate;
	
	@Pattern(regexp = "^IR\\d{24}$", message = "Shaba number must be a valid starting with 'IR' and then 24 digits")
	@Column(name = "SHABA_NUMBER",  nullable = false)
	private String shabaNumber;
	
	@ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountnumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
	    this.accountNumber = accountNumber;
	}
	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public LocalDateTime getAccountCreationDate() {
		return accountCreationDate;
	}

	public void setAccountCreationDate(LocalDateTime accountCreationDate) {
		this.accountCreationDate = accountCreationDate;
	}

	public String getShabaNumber() {
		return shabaNumber;
	}

	public void setShabaNumber(String shabaNumber) {
		this.shabaNumber = shabaNumber;
	}

	@Override
	public String toString() {
	    return "Account [id=" + id + ", accountNumber=" + accountNumber + ", balance=" + balance
	            + ", shabaNumber=" + shabaNumber + ", accountCreationDate=" + accountCreationDate + "]";
	}
}
