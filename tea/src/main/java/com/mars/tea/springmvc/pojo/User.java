package com.mars.tea.springmvc.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="user_tbl", uniqueConstraints= {@UniqueConstraint(columnNames={"phone", "mail"})})
public class User implements Serializable {

	private static final long serialVersionUID = -7062448338052992392L;
	
	@Id  
    @Basic(optional = false)   
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
    @Column(name = "id", nullable = false) 
	private Integer id;
    @Column(name = "realName")
	private String realName;
    @Column(name = "gender")
	private String gender;
    @Column(name = "mail")
	private String mail;
    @Column(name = "phone")
	private String phone;
    @Column(name = "address")
	private String address;
    @Column(name = "birthday")
	private Date birthday;
    
    @OneToOne(mappedBy = "user")
    private Credential credential;
    
	public User() {
		super();
	}

	public User(String realName, String gender, String mail, String phone, String address,
			Date birthday) {
		super();
		this.realName = realName;
		this.gender = gender;
		this.mail = mail;
		this.phone = phone;
		this.address = address;
		this.birthday = birthday;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Credential getCredential() {
		return credential;
	}

	public void setCredential(Credential credential) {
		this.credential = credential;
	}

	@Override
	public String toString() {
		return "User [id=" + id  + ", realName=" + realName + ", gender=" + gender + ", mail="
				+ mail + ", phone=" + phone + ", address=" + address + ", birthday=" + birthday + "]";
	}

}
