package ir.wallet.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import ir.wallet.springboot.persistence.model.Person;
import ir.wallet.springboot.persistence.repo.PersonRepository;
import java.util.List;

@Validated
@Service
public class PersonService {

	@Autowired
    private PersonRepository personRepository;
	
	//Create person
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }
    
    //Receive all persons
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
    
    //Get person based on ID
    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElse(null);
    }
    
    //Update person information
    public Person updatePerson(Long id, Person updatedPerson) {
        Person person = personRepository.findById(id).orElse(null);
        if (person != null) {
            person.setName(updatedPerson.getName());
            person.setFamily(updatedPerson.getFamily());
            person.setAddress(updatedPerson.getAddress());
            person.setAge(updatedPerson.getAge());
            person.setEmail(updatedPerson.getEmail());
            person.setTrooper(updatedPerson.getTrooper());
            return personRepository.save(person);
        }
        return null;
    }
    
    //Delete person
   
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
       
}


