package com.example.moo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductReviewRequest {
  private String productId;
  private double score;
  private String comment;
}
