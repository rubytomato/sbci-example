package com.example.sbci.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "payment")
public class Payment implements Serializable {

  private static final long serialVersionUID = 2761800112299753537L;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  @Column(name="customer_number", nullable=false)
  private Long customerNumber;
  @Column(name="check_number", nullable=false)
  private String checkNumber;
  @Temporal(TemporalType.DATE)
  @Column(name="payment_date", nullable=false)
  private Date paymentDate;
  @Column(name="amount", nullable=false)
  private BigDecimal amount;

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
  public String getCheckNumber() {
    return checkNumber;
  }
  public void setCheckNumber(String checkNumber) {
    this.checkNumber = checkNumber;
  }
  public Date getPaymentDate() {
    return paymentDate;
  }
  public void setPaymentDate(Date paymentDate) {
    this.paymentDate = paymentDate;
  }
  public BigDecimal getAmount() {
    return amount;
  }
  public void setAmount(BigDecimal amount) {
    this.amount = amount;
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
