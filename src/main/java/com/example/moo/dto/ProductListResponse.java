package com.example.moo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductListResponse {
  private String productId;
  private String productImage;
  private String productName;
  private int price;
  private double reviewScoreAvg;
}