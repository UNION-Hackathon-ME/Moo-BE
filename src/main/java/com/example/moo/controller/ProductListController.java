package com.example.moo.controller;

import com.example.moo.dto.ProductListResponse;
import com.example.moo.service.ProductListService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product-list")
public class ProductListController {

  private final ProductListService productListService;

  public ProductListController(final ProductListService productListService) {
    this.productListService = productListService;
  }

  @GetMapping("/insect")
  public ResponseEntity<List<ProductListResponse>> getInsect() {
    final List<ProductListResponse> insectResponses = productListService.findProduct("식용 곤충");
    return ResponseEntity.ok(insectResponses);
  }

  @GetMapping("/chicken")
  public ResponseEntity<List<ProductListResponse>> getChicken() {
    final List<ProductListResponse> chickenResponses = productListService.findProduct("비건 닭고기");
    return ResponseEntity.ok(chickenResponses);
  }

  @GetMapping("/beef")
  public ResponseEntity<List<ProductListResponse>> getBeef() {
    final List<ProductListResponse> beefResponses = productListService.findProduct("비건 소고기");
    return ResponseEntity.ok(beefResponses);
  }

  @GetMapping("/pork")
  public ResponseEntity<List<ProductListResponse>> getPork() {
    final List<ProductListResponse> porkResponses = productListService.findProduct("비건 돼지고기");
    return ResponseEntity.ok(porkResponses);
  }

  @GetMapping("/seafood")
  public ResponseEntity<List<ProductListResponse>> getSeafood() {
    final List<ProductListResponse> seafoodResponses = productListService.findProduct("비건 수산물");
    return ResponseEntity.ok(seafoodResponses);
  }

  @GetMapping("/cheese")
  public ResponseEntity<List<ProductListResponse>> getCheese() {
    final List<ProductListResponse> cheeseResponses = productListService.findProduct("비건 치즈");
    return ResponseEntity.ok(cheeseResponses);
  }

  @GetMapping("/milk")
  public ResponseEntity<List<ProductListResponse>> getMilk() {
    final List<ProductListResponse> milkResponses = productListService.findProduct("비건 우유");
    return ResponseEntity.ok(milkResponses);
  }

  @GetMapping("/protein")
  public ResponseEntity<List<ProductListResponse>> getProtein() {
    final List<ProductListResponse> proteinResponses = productListService.findProduct("비건 프로틴");
    return ResponseEntity.ok(proteinResponses);
  }

}
