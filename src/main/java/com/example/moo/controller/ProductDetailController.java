package com.example.moo.controller;


import com.example.moo.dto.ProductDetailResponse;
import com.example.moo.dto.ProductListResponse;
import com.example.moo.service.ProductDetailService;
import com.example.moo.service.ProductListService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product-detail")
public class ProductDetailController {

    private final ProductDetailService productDetailService;

    public ProductDetailController(final ProductDetailService productDetailService) {
        this.productDetailService = productDetailService;
    }

    @GetMapping("/insect")
    public ResponseEntity<List<ProductDetailResponse>> getInsect() {
        final List<ProductDetailResponse> insectResponses = productDetailService.findProduct("식용 곤충");
        return ResponseEntity.ok(insectResponses);
    }

    @GetMapping("/chicken")
    public ResponseEntity<List<ProductDetailResponse>> getChicken() {
        final List<ProductDetailResponse> chickenResponses = productDetailService.findProduct("비건 닭고기");
        return ResponseEntity.ok(chickenResponses);
    }

    @GetMapping("/beef")
    public ResponseEntity<List<ProductDetailResponse>> getBeef() {
        final List<ProductDetailResponse> beefResponses = productDetailService.findProduct("비건 소고기");
        return ResponseEntity.ok(beefResponses);
    }

    @GetMapping("/pork")
    public ResponseEntity<List<ProductDetailResponse>> getPork() {
        final List<ProductDetailResponse> porkResponses = productDetailService.findProduct("비건 돼지고기");
        return ResponseEntity.ok(porkResponses);
    }

    @GetMapping("/seafood")
    public ResponseEntity<List<ProductDetailResponse>> getSeafood() {
        final List<ProductDetailResponse> seafoodResponses = productDetailService.findProduct("비건 수산물");
        return ResponseEntity.ok(seafoodResponses);
    }

    @GetMapping("/cheese")
    public ResponseEntity<List<ProductDetailResponse>> getCheese() {
        final List<ProductDetailResponse> cheeseResponses = productDetailService.findProduct("비건 치즈");
        return ResponseEntity.ok(cheeseResponses);
    }

    @GetMapping("/milk")
    public ResponseEntity<List<ProductDetailResponse>> getMilk() {
        final List<ProductDetailResponse> milkResponses = productDetailService.findProduct("비건 우유");
        return ResponseEntity.ok(milkResponses);
    }

    @GetMapping("/protein")
    public ResponseEntity<List<ProductDetailResponse>> getProtein() {
        final List<ProductDetailResponse> proteinResponses = productDetailService.findProduct("비건 프로틴");
        return ResponseEntity.ok(proteinResponses);
    }

}
