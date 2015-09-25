package com.example.sbci.service;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.sbci.App;
import com.example.sbci.domain.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class ProductServiceTest {

  @Autowired
  ProductService productService;

  Product product1;
  Product product2;
  Product product3;
  Product product4;
  Product product5;

  @Before
  public void setup() {
    product1 = new Product();
    //product1.setId(999991L);
    product1.setProductCode("S72_3212_X");
    product1.setProductName("Pont Yacht");
    product1.setProductLine("Ships");
    product1.setProductScale("1:72");
    product1.setProductVendor("Unimax Art Galleries");
    product1.setProductDescription("Measures 38 inches Long x 33 3/4 inches High. Includes a stand. Many extras including rigging, long boats, pilot house, anchors, etc. Comes with 2 masts, all square-rigged");
    product1.setQuantityInStock(414);
    product1.setBuyPrice(new BigDecimal("33.30"));
    product1.setMSRP(new BigDecimal("54.60"));

    product2 = new Product();
    product2.setProductCode("S700_4002_X");
    product2.setProductName("American Airlines: MD-11S");
    product2.setProductLine("Planes");
    product2.setProductScale("1:700");
    product2.setProductVendor("Second Gear Diecast");
    product2.setProductDescription("Polished finish. Exact replia with official logos and insignias and retractable wheels");
    product2.setQuantityInStock(8820);
    product2.setBuyPrice(new BigDecimal("36.27"));
    product2.setMSRP(new BigDecimal("74.03"));

    product3 = new Product();
    product3.setProductCode("S72_1253_X");
    product3.setProductName("Boeing X-32A JSF");
    product3.setProductLine("Planes");
    product3.setProductScale("1:72");
    product3.setProductVendor("Motor City Art Classics");
    product3.setProductDescription("10\" Wingspan with retractable landing gears.Comes with pilot");
    product3.setQuantityInStock(4857);
    product3.setBuyPrice(new BigDecimal("32.77"));
    product3.setMSRP(new BigDecimal("49.66"));

    product4 = new Product();
    product4.setId(null);
    product4.setProductCode(null);
    product4.setProductName(null);

    product5 = new Product();
    product5.setProductCode("S700_3962");
    product5.setProductName("The Queen Mary");
    product5.setProductLine("1234567890123456789012345678901234567890");
    product5.setProductScale("1:700");
    product5.setProductVendor("Welly Diecast Productions");

  }

  @After
  public void tearDown() {
    clear();
  }

  private void clear() {
    productService.removeAll(Arrays.asList(product1, product2, product3));
  }

  @Test
  public void save_ok() {
    Product result = productService.save(product1);
    assertThat(result, notNullValue());
    Product actual = productService.findById(result.getId());
    assertThat(actual, is(result));

    product1.setId(actual.getId());
  }

  @Test
  public void saveAll_ok() {
    List<Product> products = productService.saveAll(Arrays.asList(product2, product3));
    assertThat(products, notNullValue());

    Product actual2 = productService.findById(products.get(0).getId());
    Product actual3 = productService.findById(products.get(1).getId());
    assertThat(actual2, is(products.get(0)));
    assertThat(actual3, is(products.get(1)));

    product2.setId(actual2.getId());
    product3.setId(actual3.getId());
  }

  @Test(expected = DataIntegrityViolationException.class)
  public void save_null_ng() {
    try {
      productService.save(product4);
    } catch (DataIntegrityViolationException e) {
      System.out.println("DataIntegrityViolationException!!");
      System.out.println("message:" + e.getMessage());
      throw e;
    }
    org.junit.Assert.fail();
  }

  @Test(expected = DataIntegrityViolationException.class)
  public void save_too_long_ng() {
    try {
      productService.save(product5);
    } catch (DataIntegrityViolationException e) {
      System.out.println("DataIntegrityViolationException!!");
      System.out.println("message:" + e.getMessage());
      throw e;
    }
    org.junit.Assert.fail();
  }

}
