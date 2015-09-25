package com.example.sbci.domain;

import java.io.Serializable;

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
@Table(name = "product_Line")
public class ProductLine implements Serializable {

  private static final long serialVersionUID = 6508982287447536177L;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
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
