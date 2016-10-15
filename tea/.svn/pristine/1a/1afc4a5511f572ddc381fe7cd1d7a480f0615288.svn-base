package com.mars.tea.springmvc.pojo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="credential_tbl", uniqueConstraints= {@UniqueConstraint(columnNames="userName")})
public class Credential implements Serializable {

	private static final long serialVersionUID = -619128296888832398L;
	
	@Id  
    @Basic(optional = false)   
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false) 
	private Integer id;
	@Column(name = "userName")
	private String userName;
	@Column(name = "passWord")
	private String passWord;
	
    @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
	private User user;
    
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(
            name="user_group_mapping_tbl",
            joinColumns=@JoinColumn(name="credential_id"),
            inverseJoinColumns=@JoinColumn(name="group_id")
    )
    private Set<Group> groups;
    
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(
            name="user_group_mapping_tbl",
            joinColumns=@JoinColumn(name="credential_id"),
            inverseJoinColumns=@JoinColumn(name="group_id")
    )
    private Set<Element> elements;

	public Credential() {
		super();
	}
	
	public Credential(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Credential [id=" + id + ", userName=" + userName + ", passWord=" + passWord + "]";
	}

}
