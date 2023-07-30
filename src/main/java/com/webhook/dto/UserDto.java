package com.webhook.dto;
import java.io.Serializable;
import java.util.Date;

import com.webhook.enums.UserStatus;

public class UserDto implements Serializable {

	private static final long serialVersionUID = -5963600872601785816L;
	
	private Integer id;
    private Long mobileNumber;
    private Long parentId;
    private String firstName;
    private String lastName;
    private String emailId;
    private String referralCode;
    private String referredBy;
    private Date dob;
    private String gender;
    private Date mobileVerified;
    private Date emailVerified;
    private Integer country;
    private String city;
    private String credential;
    private String pin;
    private Date createdOn;
    private Date updatedOn;
    private UserStatus status;
    private String countryName;
    private String companyName;
    private String employeeId;
    private Integer emailRequestCount;
    private String designation;
    private String fcmToken;
    private Date tncAcceptedOn;

    // Getters and setters

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public void setParentId(Long parentId) {
		this.parentId = parentId;
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
}

