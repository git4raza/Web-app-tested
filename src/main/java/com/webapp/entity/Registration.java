
package com.webapp.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "registrations")
public class Registration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long id;
	@NotEmpty
	@Size(min = 2, message = "First Name should be at least two characters")
	@Column(name = "first_name", length = 45)
	private String firstName;
	@Size(min = 1, message = "Last Name Should be at least 1 character")
	@Column(name = "last_name", length = 45)
	private String lastName;

	@Email(message = "Please check your email format, it seems incorrect")
	@Column(name = "email", unique = true, length = 128)
	private String email;
	@Min(value = 10, message = "Mobile number must be at least 10 digits")
	@Min(value = 11, message = "Mobile number must be at least 10 digits")

	@Column(name = "mobile")
	private long mobile;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

}
