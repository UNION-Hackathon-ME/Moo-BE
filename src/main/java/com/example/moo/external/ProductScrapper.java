package com.example.moo.external;

import com.example.moo.domain.Vegetable;
import org.springframework.stereotype.Component;

@Component
public class ProductScrapper {
  public ProductScrapper() {
  }

  public Vegetable scrape() {
    return new Vegetable();
  }
}
