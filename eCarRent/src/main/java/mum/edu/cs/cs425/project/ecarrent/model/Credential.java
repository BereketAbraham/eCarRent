package mum.edu.cs.cs425.project.ecarrent.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "credentials")
public class Credential {
	
	@Id
	@Column(name = "credential_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long credentialId;
	
	@Column(name = "user_name")
	@NotNull(message = "*Please provide user name") 
    private String userName;
	
	@Column(name = "password")
	@NotNull(message = "*Please provide password") 
    private String password;
	
	@OneToOne(mappedBy = "credential", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private User user;

    public Credential() {}

	public Credential(Long credentialId, String userName, String password, User user) {
		this.credentialId = credentialId;
		this.userName = userName;
		this.password = password;
		this.user = user;
	}

	public Long getCredentialId() {
		return credentialId;
	}

	public void setCredentialId(Long credentialId) {
		this.credentialId = credentialId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
    
