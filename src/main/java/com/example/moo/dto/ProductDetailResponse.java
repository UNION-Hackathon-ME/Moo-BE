package com.example.moo.dto;

import com.example.moo.domain.Review;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductDetailResponse {
    private String productId;
    private String productImage;
    private String mallImage;
    private String productName;
    private int price;
    private List<String> productDetail;
    private double reviewScoreAvg;
    private List<Review> reviewList;
}