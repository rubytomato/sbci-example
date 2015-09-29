package com.example.sbci.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

  private static final long serialVersionUID = -5891156135120747724L;

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  @NotNull
  @Column(name="customer_number", nullable=false)
  private Long customerNumber;
  @NotNull
  @Column(name="customer_name", nullable=false)
  private String customerName;
  @NotNull
  @Column(name="contact_last_name", nullable=false)
  private String contactLastName;
  @NotNull
  @Column(name="contact_first_name", nullable=false)
  private String contactFirstName;
  @Column(name="phone")
  private String phone;
  @Column(name="address_line1")
  private String addressLine1;
  @Column(name="address_line2")
  private String addressLine2;
  @Column(name="city")
  private String city;
  @Column(name="state")
  private String state;
  @Column(name="postal_code")
  private String postalCode;
  @Column(name="country")
  private String country;
  @Column(name="sales_rep_employee_number")
  private Long salesRepEmployeeNumber;
  @Column(name="credit_limit")
  private BigDecimal creditLimit;

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public Long getCustomerNumber() {
    return customerNumber;
  }
  public void setCustomerNumber(Long customerNumber) {
    this.customerNumber = customerNumber;
  }
  public String getCustomerName() {
    return customerName;
  }
  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }
  public String getContactLastName() {
    return contactLastName;
  }
  public void setContactLastName(String contactLastName) {
    this.contactLastName = contactLastName;
  }
  public String getContactFirstName() {
    return contactFirstName;
  }
  public void setContactFirstName(String contactFirstName) {
    this.contactFirstName = contactFirstName;
  }
  public String getPhone() {
    return phone;
  }
  public void setPhone(String phone) {
    this.phone = phone;
  }
  public String getAddressLine1() {
    return addressLine1;
  }
  public void setAddressLine1(String addressLine1) {
    this.addressLine1 = addressLine1;
  }
  public String getAddressLine2() {
    return addressLine2;
  }
  public void setAddressLine2(String addressLine2) {
    this.addressLine2 = addressLine2;
  }
  public String getCity() {
    return city;
  }
  public void setCity(String city) {
    this.city = city;
  }
  public String getState() {
    return state;
  }
  public void setState(String state) {
    this.state = state;
  }
  public String getPostalCode() {
    return postalCode;
  }
  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }
  public String getCountry() {
    return country;
  }
  public void setCountry(String country) {
    this.country = country;
  }
  public Long getSalesRepEmployeeNumber() {
    return salesRepEmployeeNumber;
  }
  public void setSalesRepEmployeeNumber(Long salesRepEmployeeNumber) {
    this.salesRepEmployeeNumber = salesRepEmployeeNumber;
  }
  public BigDecimal getCreditLimit() {
    return creditLimit;
  }
  public void setCreditLimit(BigDecimal creditLimit) {
    this.creditLimit = creditLimit;
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }
  @Override
  public boolean equals(Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj);
  }
  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
  }

}
