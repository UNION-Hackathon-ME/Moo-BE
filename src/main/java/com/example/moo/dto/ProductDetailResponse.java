package com.example.moo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDetailResponse {
    private String productImage;
    private String brandImage;
    private String productName;
    private int price;
}