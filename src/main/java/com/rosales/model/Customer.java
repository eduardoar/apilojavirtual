package com.rosales.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Customer Information")
@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCustomer;
	
	@ApiModelProperty(notes = "The first name must be a minimum of 2 characters")
	@Column(name = "first_name", nullable = false, length = 100)
	private String firstName;
	
	@ApiModelProperty(notes = "The last name must be a minimum of 2 characters")
	@Column(name = "last_name", nullable = false, length = 100)
	private String lastName;
	
	@ApiModelProperty(notes = "The cpf must be of 11 characters")
	@Column(name = "cpf", nullable = false, length = 20)
	private String cpf;
	
	@Email
	@Column(name = "email", nullable = false, length = 50)
	private String email;
	
	@ApiModelProperty(notes = "The telephone must be of 11 characters")
	@Column(name = "telephone", nullable = false, length = 50)
	private String telephone;
	
	@ApiModelProperty(notes = "The address must be a minimum of 3 characters")
	@Column(name = "address", nullable = false, length = 250)
	private String address;

	public Integer getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Integer idCustomer) {
		this.idCustomer = idCustomer;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
