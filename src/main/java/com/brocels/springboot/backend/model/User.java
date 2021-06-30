package com.brocels.springboot.backend.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "first_name")
    @Size(max=20)
    private String firstName;

    @Column(name = "last_name")
    @Size(max=20)
    private String lastName;
    
    @Column(name = "user_name")
    @Size(max=20)
    @NotBlank
    private String userName;
    
    @Column(name = "email")
    @NotBlank
    @Size(max = 50)
    @Email(message = "Email should be valid")
    private String email;
    
    @Column(name = "age")
    @Min(value = 10, message = "Age shouldn't be under 10")
    private int age;
    
    @Column(name = "country")
    private String country;
    
    @Column(name = "state")
    private String state;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "password")
    @NotBlank
    @Size(max = 120)
    private String password;
    
    @Column
    @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
    

	
}
