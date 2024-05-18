package com.example.moo.service;

import com.example.moo.dto.ProductDetailResponse;
import com.example.moo.external.ProductScraper;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductDetailService {

    private final ProductScraper productScraper;

    public ProductDetailResponse getProductInfo(String productId)
        throws IOException, ParseException {
        ProductDetailResponse productDetailResponse = productScraper.scrapeProduct(productId);
        return productDetailResponse;
    }
}
