package com.example.moo.controller;

import com.example.moo.service.ProductService;
import com.example.moo.dto.VegetableResponse;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {
  private final ProductService productService;

  public ProductController(final ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/vegetable")
  public ResponseEntity<List<VegetableResponse>> getVegetables() {
    final List<VegetableResponse> vegetableResponses = productService.findVegetables();
    return ResponseEntity.ok(vegetableResponses);
  }
}
