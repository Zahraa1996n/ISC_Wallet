package ir.wallet.springboot.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ir.wallet.springboot.persistence.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
