package ir.wallet.springboot.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ir.wallet.springboot.persistence.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
