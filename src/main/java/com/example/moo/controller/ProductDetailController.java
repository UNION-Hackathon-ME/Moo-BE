package com.example.moo.controller;


import com.example.moo.dto.ProductDetailResponse;
import com.example.moo.dto.ProductListResponse;
import com.example.moo.service.ProductDetailService;
import com.example.moo.service.ProductListService;
import java.io.IOException;
import java.util.List;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
@RequestMapping("/api/product-detail")
public class ProductDetailController {

    private final ProductDetailService productDetailService;

    public ProductDetailController(final ProductDetailService productDetailService) {
        this.productDetailService = productDetailService;
    }

    @GetMapping()
    public ResponseEntity<ProductDetailResponse> getProductInfo(@RequestParam String productId)
        throws IOException, ParseException {
        final ProductDetailResponse productDetailResponse = productDetailService.getProductInfo(productId);
        return ResponseEntity.ok(productDetailResponse);
    }
}
