package com.example.sbci.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_Line")
public class ProductLine {

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  @Column(name="product_line", nullable=false)
  private String productLine;
  @Column(name="text_description")
  private String textDescription;
  @Column(name="html_description")
  private String htmlDescription;
  @Column(name="image")
  private String image;

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getProductLine() {
    return productLine;
  }
  public void setProductLine(String productLine) {
    this.productLine = productLine;
  }
  public String getTextDescription() {
    return textDescription;
  }
  public void setTextDescription(String textDescription) {
    this.textDescription = textDescription;
  }
  public String getHtmlDescription() {
    return htmlDescription;
  }
  public void setHtmlDescription(String htmlDescription) {
    this.htmlDescription = htmlDescription;
  }
  public String getImage() {
    return image;
  }
  public void setImage(String image) {
    this.image = image;
  }

}