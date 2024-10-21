package ir.wallet.springboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ir.wallet.springboot.persistence.model.Person;
import ir.wallet.springboot.service.PersonService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/persons")
public class PersonController {
	
	@Autowired
    private PersonService personService;
	
    @PostMapping("/create")
    public ResponseEntity<Person> createPerson(@Valid @RequestBody Person person) {
    	System.out.println("person:" + person);
        return new ResponseEntity<>(personService.createPerson(person), HttpStatus.CREATED);
    }
    
    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        Person person = personService.getPersonById(id);
        if (person != null) {
            return new ResponseEntity<>(person, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @Valid @RequestBody Person updatedPerson) {
        Person person = personService.updatePerson(id, updatedPerson);
        if (person != null) {
            return new ResponseEntity<>(person, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
