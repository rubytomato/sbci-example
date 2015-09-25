package com.example.sbci.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "order_detail")
public class OrderDetail implements Serializable {

  private static final long serialVersionUID = 1890789792110128467L;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
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
