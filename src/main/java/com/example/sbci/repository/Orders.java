package com.example.sbci.repository;

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

@Entity
@Table(name = "orders")
public class Orders implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 3744346731479843943L;

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  @Column(name="order_number", nullable=false)
  private Long orderNumber;
  @Temporal(TemporalType.DATE)
  @Column(name="order_date", nullable=false)
  private Date orderDate;
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

}
