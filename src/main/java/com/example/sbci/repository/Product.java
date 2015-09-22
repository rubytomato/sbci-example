package com.example.sbci.repository;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  @Column(name="product_code", nullable=false)
  private String productCode;
  @Column(name="product_name", nullable=false)
  private String productName;
  @Column(name="product_line", nullable=false)
  private String productLine;
  @Column(name="product_scale", nullable=false)
  private String productScale;
  @Column(name="product_vendor", nullable=false)
  private String productVendor;
  @Column(name="product_description")
  private String productDescription;
  @Column(name="quantity_in_stock")
  private Integer quantityInStock;
  @Column(name="buy_price")
  private BigDecimal buyPrice;
  @Column(name="msrp")
  private BigDecimal MSRP;

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getProductCode() {
    return productCode;
  }
  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }
  public String getProductName() {
    return productName;
  }
  public void setProductName(String productName) {
    this.productName = productName;
  }
  public String getProductLine() {
    return productLine;
  }
  public void setProductLine(String productLine) {
    this.productLine = productLine;
  }
  public String getProductScale() {
    return productScale;
  }
  public void setProductScale(String productScale) {
    this.productScale = productScale;
  }
  public String getProductVendor() {
    return productVendor;
  }
  public void setProductVendor(String productVendor) {
    this.productVendor = productVendor;
  }
  public String getProductDescription() {
    return productDescription;
  }
  public void setProductDescription(String productDescription) {
    this.productDescription = productDescription;
  }
  public Integer getQuantityInStock() {
    return quantityInStock;
  }
  public void setQuantityInStock(Integer quantityInStock) {
    this.quantityInStock = quantityInStock;
  }
  public BigDecimal getBuyPrice() {
    return buyPrice;
  }
  public void setBuyPrice(BigDecimal buyPrice) {
    this.buyPrice = buyPrice;
  }
  public BigDecimal getMSRP() {
    return MSRP;
  }
  public void setMSRP(BigDecimal mSRP) {
    MSRP = mSRP;
  }

}
