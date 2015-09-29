package com.example.sbci.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "orders")
public class Orders implements Serializable {

  private static final long serialVersionUID = 3744346731479843943L;

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  @NotNull
  @Column(name="order_number", nullable=false)
  private Long orderNumber;
  @NotNull
  @Temporal(TemporalType.DATE)
  @Column(name="order_date", nullable=false)
  private Date orderDate;
  @NotNull
  @Temporal(TemporalType.DATE)
  @Column(name="required_date", nullable=false)
  private Date requiredDate;
  @Temporal(TemporalType.DATE)
  @Column(name="shipped_date")
  private Date shippedDate;
  @Column(name="status")
  private String status;
  @Column(name="comments")
  private String comments;
  @Column(name="customer_number")
  private Long customerNumber;


  public Orders(){}


/*  public Orders(Long id, Long orderNumber, Date orderDate, Date requiredDate,
      Date shippedDate, String status, String comments, Long customerNumber) {
    super();
    this.id = id;
    this.orderNumber = orderNumber;
    this.orderDate = orderDate;
    this.requiredDate = requiredDate;
    this.shippedDate = shippedDate;
    this.status = status;
    this.comments = comments;
    this.customerNumber = customerNumber;
  }
*/

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(Long orderNumber) {
    this.orderNumber = orderNumber;
  }

  public Date getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
  }

  public Date getRequiredDate() {
    return requiredDate;
  }

  public void setRequiredDate(Date requiredDate) {
    this.requiredDate = requiredDate;
  }

  public Date getShippedDate() {
    return shippedDate;
  }

  public void setShippedDate(Date shippedDate) {
    this.shippedDate = shippedDate;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public Long getCustomerNumber() {
    return customerNumber;
  }

  public void setCustomerNumber(Long customerNumber) {
    this.customerNumber = customerNumber;
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
