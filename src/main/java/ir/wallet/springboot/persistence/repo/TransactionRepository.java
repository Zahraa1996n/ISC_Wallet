package ir.wallet.springboot.persistence.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ir.wallet.springboot.persistence.model.Account;
import ir.wallet.springboot.persistence.model.Transaction;
import ir.wallet.springboot.persistence.model.Type;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	List<Transaction> findByAccountId(Long accountId);
	List<Transaction> findByAccountAndType( Account account, Type type);
}
