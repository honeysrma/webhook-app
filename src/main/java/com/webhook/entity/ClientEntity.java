package com.webhook.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.webhook.enums.ClientStatus;

@Entity
@Table(name = "mst_clients")
public class ClientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "client_name", length = 20)
	private String clientName;

	@Column(name = "client_secret", length = 70)
	private String clientSecret;

	@Column(name = "mobile_number", nullable = false, precision = 10, scale = 0)
	private Long mobileNumber;

	@Column(name = "token_genereation_allowed", nullable = false)
	private Boolean tokenGenerationAllowed = true;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false, columnDefinition = "ENUM('ACTIVE','INACTIVE','TERMINATED') DEFAULT 'ACTIVE'")
	private ClientStatus status = ClientStatus.ACTIVE;

	@Column(name = "created_on", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	@Column(name = "updated_on", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;

	@Column(name = "account_non_expired", nullable = false)
	private Boolean accountNonExpired = true;

	@Column(name = "account_non_locked", nullable = false)
	private Boolean accountNonLocked = true;

	@Column(name = "credentials_non_expired", nullable = false)
	private Boolean credentialsNonExpired = true;

	@Column(name = "enabled", nullable = false)
	private Boolean enabled = true;

	@Column(name = "mapped_mst_challengerzone_id")
	private Long mappedMstChallengerZoneId;

	@Column(name = "public_key", length = 747)
	private String publicKey;

	@Column(name = "private_key", length = 3217)
	private String privateKey;

	@Column(name = "client_key", length = 747)
	private String clientKey;

	@Column(name = "white_list_ip", columnDefinition = "json")
	private String whiteListIp;

	@Column(name = "target_url", length = 200)
	private String targetUrl;

	@Column(name = "auth_url", length = 100)
	private String authUrl;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Boolean getTokenGenerationAllowed() {
		return tokenGenerationAllowed;
	}

	public void setTokenGenerationAllowed(Boolean tokenGenerationAllowed) {
		this.tokenGenerationAllowed = tokenGenerationAllowed;
	}

	public ClientStatus getStatus() {
		return status;
	}

	public void setStatus(ClientStatus status) {
		this.status = status;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Boolean getAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(Boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public Boolean getAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(Boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public Boolean getCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Long getMappedMstChallengerZoneId() {
		return mappedMstChallengerZoneId;
	}

	public void setMappedMstChallengerZoneId(Long mappedMstChallengerZoneId) {
		this.mappedMstChallengerZoneId = mappedMstChallengerZoneId;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public String getClientKey() {
		return clientKey;
	}

	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}

	public String getWhiteListIp() {
		return whiteListIp;
	}

	public void setWhiteListIp(String whiteListIp) {
		this.whiteListIp = whiteListIp;
	}

	public String getTargetUrl() {
		return targetUrl;
	}

	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}

	public String getAuthUrl() {
		return authUrl;
	}

	public void setAuthUrl(String authUrl) {
		this.authUrl = authUrl;
	}

}
