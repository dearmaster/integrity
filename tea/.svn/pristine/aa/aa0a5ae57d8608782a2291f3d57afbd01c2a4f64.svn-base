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
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "element_tbl", uniqueConstraints = { @UniqueConstraint(columnNames = "name") })
public class Element implements Serializable {

	private static final long serialVersionUID = -8759705031589906185L;

	@Id
	@Basic(optional = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	@Column(name = "name")
	private String name;

	@ManyToMany(mappedBy="elements",cascade={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
	private Set<Credential> credentials;
	
	@ManyToMany(mappedBy="elements",cascade={CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
	private Set<Group> groups;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Credential> getCredentials() {
		return credentials;
	}

	public void setCredentials(Set<Credential> credentials) {
		this.credentials = credentials;
	}

	public Set<Group> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}

}
