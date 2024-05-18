package com.example.moo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductListResponse {
  private String productImage;
  private String productName;
  private int price;
  private double reviewNum;
}
