package com.example.moo.controller;

import com.example.moo.dto.ProductListResponse;
import com.example.moo.service.ProductListService;
import java.io.IOException;
import java.util.List;
import org.json.simple.parser.ParseException;
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
  public ResponseEntity<List<ProductListResponse>> getInsect() throws IOException, ParseException {
    final List<ProductListResponse> insectResponses = productListService.findProduct("식용 곤충");
    return ResponseEntity.ok(insectResponses);
  }

  @GetMapping("/chicken")
  public ResponseEntity<List<ProductListResponse>> getChicken() throws IOException, ParseException {
    final List<ProductListResponse> chickenResponses = productListService.findProduct("비건 닭고기");
    return ResponseEntity.ok(chickenResponses);
  }

  @GetMapping("/beef")
  public ResponseEntity<List<ProductListResponse>> getBeef() throws IOException, ParseException {
    final List<ProductListResponse> beefResponses = productListService.findProduct("비건 소고기");
    return ResponseEntity.ok(beefResponses);
  }

  @GetMapping("/pork")
  public ResponseEntity<List<ProductListResponse>> getPork() throws IOException, ParseException {
    final List<ProductListResponse> porkResponses = productListService.findProduct("비건 돼지고기");
    return ResponseEntity.ok(porkResponses);
  }

  @GetMapping("/seafood")
  public ResponseEntity<List<ProductListResponse>> getSeafood() throws IOException, ParseException {
    final List<ProductListResponse> seafoodResponses = productListService.findProduct("비건 수산물");
    return ResponseEntity.ok(seafoodResponses);
  }

  @GetMapping("/cheese")
  public ResponseEntity<List<ProductListResponse>> getCheese() throws IOException, ParseException {
    final List<ProductListResponse> cheeseResponses = productListService.findProduct("비건 치즈");
    return ResponseEntity.ok(cheeseResponses);
  }

  @GetMapping("/milk")
  public ResponseEntity<List<ProductListResponse>> getMilk() throws IOException, ParseException {
    final List<ProductListResponse> milkResponses = productListService.findProduct("비건 우유");
    return ResponseEntity.ok(milkResponses);
  }

  @GetMapping("/protein")
  public ResponseEntity<List<ProductListResponse>> getProtein() throws IOException, ParseException {
    final List<ProductListResponse> proteinResponses = productListService.findProduct("비건 프로틴");
    return ResponseEntity.ok(proteinResponses);
  }

}
