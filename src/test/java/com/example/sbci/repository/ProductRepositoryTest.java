package com.example.sbci.repository;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.sbci.App;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class ProductRepositoryTest {

  @Autowired
  ProductRepository productRepository;

  @Test
  public void executeQueryCount() {
    Long count = productRepository.count();
    assertThat(count, is(110L));
  }

  @Test
  public void executeQueryFindOne() {
    Long id = 110L;
    Product product = productRepository.findOne(id);
    assertThat(product, notNullValue());
    assertThat(product.getId(), is(id));
  }

  @Test
  public void executeQueryFindByDescOrderByProductName() {
    String desc = "%Chrome%";
    List<Product> list = productRepository.findByDescOrderByProductName(desc);
    assertThat(list, notNullValue());
    assertThat(list.size(), is(16));
  }

}
