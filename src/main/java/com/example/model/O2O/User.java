package com.example.model.O2O;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.model.audit.DateAudit;

@Entity
@Table(name = "users")
public class User extends DateAudit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 65)
    @Column(name = "first_name")
    private String firstName;

    @Size(max = 65)
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Email
    @Size(max = 100)
    @Column(unique = true)
    private String email;

    @NotNull
    @Size(max = 128)
    private String password;

    //In a bi-directional relationship, we specify @OneToOne annotation on both the entities but only one entity is the owner of the relationship. Most often, the child entity is the owner of the relationship and the parent entity is the inverse side of the relationship.
    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,  //Apply all cascading effects to the related entity. That is, whenever we update/delete a User entity, update/delete the corresponding UserProfile as well.
            mappedBy = "user") //We use mappedBy attribute in the User entity to tell hibernate that the User entity is not responsible for this relationship and It should look for a field named user in the UserProfile entity to find the configuration for the JoinColumn/ForeignKey column.
    private UserProfile userProfile;

    // Hibernate requires a no-arg constructor
    public User() {

    }

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
    
    
}