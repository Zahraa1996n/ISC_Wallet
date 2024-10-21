package ir.wallet.springboot.persistence.model;

import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="Transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "Amount",  nullable = false)
	private Double amount;
	
	@Enumerated(EnumType.STRING)
	private Type type;
	
	@Column
	private LocalDateTime dateTime;
	
	@Column(name = "DESCRIPTION")
	private String transactionDescription;
	
	@Column(name = "AccountNumber", length = 50)
	private String accountnumber;
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Column(name = "BALANCE_AFTER_TRANSACTION")
	private Double balanceafterTransaction;
	
	@ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Type getType() {
		return type;
	}
	
	public void setType(Type type) {
		System.out.println(type);
		this.type = type;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getDescriptionTransaction() {
		return transactionDescription;
	}

	public void setDescriptionTransaction(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public Double getBalanceafterTransaction() {
		return balanceafterTransaction;
	}

	public void setBalanceafterTransaction(Double balanceafterTransaction) {
		this.balanceafterTransaction = balanceafterTransaction;
	}

	@Override
	public String toString() {
		return "Students [id=" + id + ", amount=" + amount + ", type=" + type
				+ ", DateTime=" + dateTime + ", DescriptionTransaction=" + transactionDescription + ", accountnumber=" + accountnumber + ", BalanceafterTransaction=" + balanceafterTransaction + "]";
	}
}
