package in.manepata.security.usermanager.entities;

import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

import in.manepata.security.usermanager.enums.Gender;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique=true)
    private String username;

    @Column(nullable = false, unique=true)
    private String password;

    private String email;

    private String firstName;

    private String lastName;

    @Column(nullable = false, unique=true)
    private String fullName; // Derived field (firstName + lastName)

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = true)
    private Gender gender;

    @Column(nullable = true)

    private String country;

    @Column(nullable = true)
    private String state; // Optional depending on application requirements

    @Column(nullable = true)
    private String city;

    @Column(nullable = true)
    private String address;

    @Column(nullable = true)
    private String postalCode;

    @Column(nullable = true)
    private String phoneNumber;

    @Column(nullable = true)
    private String secondaryPhoneNumber;

    @Column(nullable = true)
    
    private Boolean isActive;

    @Temporal(TemporalType.TIMESTAMP)
    private Instant createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Instant updatedAt;
    
    private boolean enabled;
    
    @ManyToMany 
    @JoinTable( 
        name = "users_roles", 
        joinColumns = @JoinColumn(
          name = "user_id", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(
          name = "role_id", referencedColumnName = "id")) 
    private Set<Role> roles = new HashSet<>();

    public Set<Role> getRoles() {
		return roles;
	}

	public List<UserType> getUserTypes() {
		return userTypes;
	}

	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_user_types",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "user_type_id")
    )
    private List<UserType> userTypes = new ArrayList<>();

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSecondaryPhoneNumber() {
		return secondaryPhoneNumber;
	}

	public void setSecondaryPhoneNumber(String secondaryPhoneNumber) {
		this.secondaryPhoneNumber = secondaryPhoneNumber;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setRoles(Set<Role> roles2) {
		
	}

	public void setUserTypes(List<UserType> userTypes2) {
		// TODO Auto-generated method stub
		
	}

}
