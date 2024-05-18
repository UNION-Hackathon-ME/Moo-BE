package com.example.moo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Product {
  private String productId;
  private String productName;
  private String productImage;
  private String mallName;
  private String mallImage;
  private String link;
  private int price;
  private double reviewNum;

  public Product(String productId, String productName, String productImage, String mallName,
      String link, int price) {
    this.productId = productId;
    this.productName = productName;
    this.productImage = productImage;
    this.mallName = mallName;
    this.link = link;
    this.price = price;
  }
}
