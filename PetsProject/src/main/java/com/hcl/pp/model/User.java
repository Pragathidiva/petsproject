package com.hcl.pp.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.stereotype.Component;

import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries({ @NamedQuery(name = "listUsers", query = "from User"),
		@NamedQuery(name = "findByUserName", query = "from User user where user.username= :name"),

})

@Component("user")
@Entity
@Table(name = "pet_user")

public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private long Id;

	@Column(name = "USER_NAME")
	@NotNull(message = "Enter User Name")
	@Size(min = 5, message = "Min length:5 , Max length:10")
	private String username;

	@Column(name = "USER_PASSWD")
	@NotNull(message = "Enter Password")
	@Size(min = 5, max = 10, message = "Min length:5 , Max length:10")
	private String userPassword;

	@Transient
	private String confirmPassword;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Pet> pets;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Set<Pet> getPets() {
		return pets;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}

}
