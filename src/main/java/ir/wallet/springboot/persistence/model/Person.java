package ir.wallet.springboot.persistence.model;

import java.util.Date;

import org.springframework.validation.annotation.Validated;

import ir.wallet.springboot.web.validation.AgeFatherConstraint;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Validated
@Entity
@Table(name="Person")
@AgeFatherConstraint
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "PERSON_NAME", length = 50, nullable = false)
	private String name;
	
	@Column(name = "PERSON_Family", length = 50, nullable = false)
	private String family;
	
	@Transient
	private Integer age;
	
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Pattern(regexp = "^(\\+98|0)?9\\d{9}$", message = "Mobile number should be valid")
	@Column(nullable = false)
    private String personNumber; //mobile
	
    @Column(length = 100)
    private String address;
    
    @Email(message = "Email should be valid")
    @Column(nullable = false, length = 100)
    private String email;
    
    @Size(min = 10, max = 10, message = "It must be exactly 10 digits and only numeric")
    @Pattern(regexp = "\\d{10}")
    @Column(unique = true, nullable = false)
    private String personCode ; //code meli
    
    @Size(min = 10, max = 10, message = "It must be exactly 10 digits and only numeric")
    @Pattern(regexp = "\\d{10}")
    @Column
    private String fatherCode ; //code meli pedar
    
    @Enumerated(EnumType.STRING)
	private Trooper trooper; 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}



	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getPersonNumber() {
		return personNumber;
	}

	public void setPersonNumber(String personNumber) {
		this.personNumber = personNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}

	public String getFatherCode() {
		return fatherCode;
	}

	public void setFatherCode(String fatherCode) {
		this.fatherCode = fatherCode;
	}

	public Trooper getTrooper() {
		return trooper;
	}

	public void setTrooper(Trooper trooper) {
		this.trooper = trooper;
	}
	
	@Override
	public String toString() {
	    return "Person [id=" + id + ", name=" + name +  ", family=" + family +", age=" + age
	            + ", birthDate=" + birthDate + ", email=" + email + ", trooper=" + trooper + ", gender=" + gender + "]";
	}
}
