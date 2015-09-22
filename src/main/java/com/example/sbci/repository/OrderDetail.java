package com.example.sbci.repository;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_detail")
public class OrderDetail implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1890789792110128467L;

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  @Column(name="order_number", nullable=false)
  private Long orderNumber;
  @Column(name="product_code", nullable=false)
  private String productCode;
  @Column(name="quantity_ordered", nullable=false)
  private Long quantityOrdered;
  @Column(name="price_each", nullable=false)
  private BigDecimal priceEach;
  @Column(name="order_line_number", nullable=false)
  private Integer orderLineNumber;

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
  public String getProductCode() {
    return productCode;
  }
  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }
  public Long getQuantityOrdered() {
    return quantityOrdered;
  }
  public void setQuantityOrdered(Long quantityOrdered) {
    this.quantityOrdered = quantityOrdered;
  }
  public BigDecimal getPriceEach() {
    return priceEach;
  }
  public void setPriceEach(BigDecimal priceEach) {
    this.priceEach = priceEach;
  }
  public Integer getOrderLineNumber() {
    return orderLineNumber;
  }
  public void setOrderLineNumber(Integer orderLineNumber) {
    this.orderLineNumber = orderLineNumber;
  }

}
