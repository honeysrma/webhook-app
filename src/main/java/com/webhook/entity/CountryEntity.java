package com.webhook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "lkp_country")
@Immutable
public class CountryEntity {

	@Id
	@Column(name = "id_lkp_country")
	private Integer id;

	@Column(name = "country_name", length = 75, nullable = false)
	private String countryName;

	@Column(name = "short_name", length = 5)
	private String shortName;

	@Column(name = "is_active", nullable = false)
	private Boolean isActive;

	@Column(name = "mobile_number_length")
	private Integer mobileNumberLength;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Integer getMobileNumberLength() {
		return mobileNumberLength;
	}

	public void setMobileNumberLength(Integer mobileNumberLength) {
		this.mobileNumberLength = mobileNumberLength;
	}

}
