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

import com.webhook.enums.ProfileType;

@Entity
@Table(name = "mst_coach")
@Immutable
public class CoachEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_mst_coach")
	private Long id;

	@Column(name = "coach_name", nullable = false, length = 75)
	private String coachName;

	@Column(name = "image", length = 450)
	private String image;

	@Column(name = "country_code")
	private Integer countryCode = 91;

	@Column(name = "phone_number", length = 20)
	private String phoneNumber;

	@Column(name = "email_id", length = 150, columnDefinition = "varchar(150) DEFAULT 'name@mail.com'")
	private String emailId;

	@Column(name = "specialization", length = 150, columnDefinition = "varchar(150) DEFAULT 'Not Available'")
	private String specialization;

	@Column(name = "languages_know", length = 150, columnDefinition = "varchar(150) DEFAULT 'Not Available'")
	private String languagesKnow;

	@Column(name = "total_experience", length = 50, columnDefinition = "varchar(50) DEFAULT 'Not Available'")
	private String totalExperience;

	@Column(name = "short_bio", length = 500, columnDefinition = "varchar(500) DEFAULT 'Not Available'")
	private String shortBio;

	@Column(name = "is_active", columnDefinition = "tinyint DEFAULT '1'")
	private Boolean isActive = true;

	@Column(name = "twitter", length = 100, columnDefinition = "varchar(100) DEFAULT '@twitter'")
	private String twitter;

	@Column(name = "linkedin", length = 100, columnDefinition = "varchar(100) DEFAULT '@linkedIn'")
	private String linkedin;

	@Column(name = "facebook", length = 100, columnDefinition = "varchar(100) DEFAULT '@facebook'")
	private String facebook;

	@Column(name = "instagram", length = 100, columnDefinition = "varchar(100) DEFAULT '@instagram'")
	private String instagram;

	@Column(name = "active_status")
	private Boolean activeStatus;

	@Enumerated(EnumType.STRING)
	@Column(name = "profile_type", columnDefinition = "enum('GENERAL','MHEALTH','EMOTIONALCAFE','NUTRIEXPERT')")
	private ProfileType profileType;

	@Column(name = "upi", length = 100)
	private String upi;

	@Column(name = "bank_name", length = 75)
	private String bankName;

	@Column(name = "ifsc_code", length = 50)
	private String ifscCode;

	@Column(name = "account_number", length = 50)
	private String accountNumber;

	@Column(name = "active_status_change")
	@Temporal(TemporalType.TIMESTAMP)
	private Date activeStatusChange;

	@Column(name = "profile_approved")
	private Boolean profileApproved;

	@Column(name = "approved_by")
	private Long approvedBy;

	@Column(name = "approved_on")
	@Temporal(TemporalType.TIMESTAMP)
	private Date approvedOn;

	@Column(name = "call_pm_rate")
	private Integer callPmRate;

	@Column(name = "chat_pm_rate")
	private Integer chatPmRate;

	@Column(name = "video_pm_rate")
	private Integer videoPmRate;

	@Column(name = "id_mst_challengerzone", columnDefinition = "json")
	private String challengerZone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCoachName() {
		return coachName;
	}

	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(Integer countryCode) {
		this.countryCode = countryCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getLanguagesKnow() {
		return languagesKnow;
	}

	public void setLanguagesKnow(String languagesKnow) {
		this.languagesKnow = languagesKnow;
	}

	public String getTotalExperience() {
		return totalExperience;
	}

	public void setTotalExperience(String totalExperience) {
		this.totalExperience = totalExperience;
	}

	public String getShortBio() {
		return shortBio;
	}

	public void setShortBio(String shortBio) {
		this.shortBio = shortBio;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public Boolean getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(Boolean activeStatus) {
		this.activeStatus = activeStatus;
	}

	public ProfileType getProfileType() {
		return profileType;
	}

	public void setProfileType(ProfileType profileType) {
		this.profileType = profileType;
	}

	public String getUpi() {
		return upi;
	}

	public void setUpi(String upi) {
		this.upi = upi;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Date getActiveStatusChange() {
		return activeStatusChange;
	}

	public void setActiveStatusChange(Date activeStatusChange) {
		this.activeStatusChange = activeStatusChange;
	}

	public Boolean getProfileApproved() {
		return profileApproved;
	}

	public void setProfileApproved(Boolean profileApproved) {
		this.profileApproved = profileApproved;
	}

	public Long getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(Long approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Date getApprovedOn() {
		return approvedOn;
	}

	public void setApprovedOn(Date approvedOn) {
		this.approvedOn = approvedOn;
	}

	public Integer getCallPmRate() {
		return callPmRate;
	}

	public void setCallPmRate(Integer callPmRate) {
		this.callPmRate = callPmRate;
	}

	public Integer getChatPmRate() {
		return chatPmRate;
	}

	public void setChatPmRate(Integer chatPmRate) {
		this.chatPmRate = chatPmRate;
	}

	public Integer getVideoPmRate() {
		return videoPmRate;
	}

	public void setVideoPmRate(Integer videoPmRate) {
		this.videoPmRate = videoPmRate;
	}

	public String getChallengerZone() {
		return challengerZone;
	}

	public void setChallengerZone(String challengerZone) {
		this.challengerZone = challengerZone;
	}

}
