package com.example.moo.controller;

import com.example.moo.domain.Review;
import com.example.moo.dto.ProductDetailResponse;
import com.example.moo.dto.ProductReviewRequest;
import com.example.moo.service.ProductDetailService;
import com.example.moo.service.ProductReviewService;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product-review")
public class ProductReviewController {
  private final ProductReviewService productReviewService;
  private final ProductDetailService productDetailService;

  public ProductReviewController(final ProductReviewService productReviewService, final ProductDetailService productDetailService) {
    this.productReviewService = productReviewService;
    this.productDetailService = productDetailService;
  }

  @PostMapping("")
  public ResponseEntity<ProductDetailResponse> getProductInfo(@RequestBody ProductReviewRequest productReviewRequest)
      throws IOException, ParseException {
    productReviewService.saveReview(new Review(productReviewRequest.getProductId(), productReviewRequest.getScore(), productReviewRequest.getComment()));
    final ProductDetailResponse productDetailResponse = productDetailService.getProductInfo(productReviewRequest.getProductId());
    return ResponseEntity.ok(productDetailResponse);
  }
}
