package com.example.moo.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Product {
  private String productId;
  private String productName;
  private String productImage;
  private String mallName;
  private String mallImage;
  private String link;
  private int price;
  private List<String> productDetail;
  private double reviewScoreAvg;
  private List<Review> reviewList;

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
