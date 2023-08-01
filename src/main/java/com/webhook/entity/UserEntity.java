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

import org.hibernate.annotations.Immutable;

import com.webhook.enums.UserStatus;

@Entity
@Table(name = "mst_users")
@Immutable
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_mst_users")
	private Long id;

	@Column(name = "mobile_number", nullable = false)
	private Long mobileNumber;

	@Column(name = "parent_id", nullable = false)
	private Long parentId;

	@Column(name = "first_name", length = 50)
	private String firstName;

	@Column(name = "last_name", length = 50)
	private String lastName;

	@Column(name = "email_id", length = 75)
	private String emailId;

	@Column(name = "referral_code", length = 10, unique = true)
	private String referralCode;

	@Column(name = "referred_by", length = 10)
	private String referredBy;

	@Column(name = "dob")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dob;

	@Column(name = "gender", length = 10)
	private String gender;

	@Column(name = "mobile_verified")
	@Temporal(TemporalType.TIMESTAMP)
	private Date mobileVerified;

	@Column(name = "email_verified")
	@Temporal(TemporalType.TIMESTAMP)
	private Date emailVerified;

	@Column(name = "country")
	private Integer country;

	@Column(name = "city", length = 75)
	private String city;

	@Column(name = "credential", length = 200)
	private String credential;

	@Column(name = "pin", length = 200)
	private String pin;

	@Column(name = "created_on", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	@Column(name = "updated_on", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", length = 15, nullable = false, columnDefinition = "ENUM('ACTIVE','INACTIVE','TERMINATED','PARTIALLY_VERIFIED','NOT_FOUND') DEFAULT 'NOT_FOUND'")
	private UserStatus status;

	@Column(name = "country_name", length = 50)
	private String countryName;

	@Column(name = "company_name", length = 100)
	private String companyName;

	@Column(name = "employee_id", length = 15)
	private String employeeId;

	@Column(name = "email_request_count")
	private Integer emailRequestCount;

	@Column(name = "designation", length = 100)
	private String designation;

	@Column(name = "fcm_token", length = 500)
	private String fcmToken;

	@Column(name = "tnc_accepted_on")
	@Temporal(TemporalType.TIMESTAMP)
	private Date tncAcceptedOn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getReferralCode() {
		return referralCode;
	}

	public void setReferralCode(String referralCode) {
		this.referralCode = referralCode;
	}

	public String getReferredBy() {
		return referredBy;
	}

	public void setReferredBy(String referredBy) {
		this.referredBy = referredBy;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getMobileVerified() {
		return mobileVerified;
	}

	public void setMobileVerified(Date mobileVerified) {
		this.mobileVerified = mobileVerified;
	}

	public Date getEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(Date emailVerified) {
		this.emailVerified = emailVerified;
	}

	public Integer getCountry() {
		return country;
	}

	public void setCountry(Integer country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCredential() {
		return credential;
	}

	public void setCredential(String credential) {
		this.credential = credential;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
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

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getEmailRequestCount() {
		return emailRequestCount;
	}

	public void setEmailRequestCount(Integer emailRequestCount) {
		this.emailRequestCount = emailRequestCount;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getFcmToken() {
		return fcmToken;
	}

	public void setFcmToken(String fcmToken) {
		this.fcmToken = fcmToken;
	}

	public Date getTncAcceptedOn() {
		return tncAcceptedOn;
	}

	public void setTncAcceptedOn(Date tncAcceptedOn) {
		this.tncAcceptedOn = tncAcceptedOn;
	}

}
