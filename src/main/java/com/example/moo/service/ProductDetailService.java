package com.example.moo.service;

import com.example.moo.domain.Product;
import com.example.moo.dto.ProductDetailResponse;
import com.example.moo.external.ProductScraper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductDetailService {

    private final ProductScraper productScraper;

    public ProductDetailResponse getProductInfo(String productId)
        throws IOException, ParseException {
        Product product = productScraper.scrapeProduct(productId);
        ProductDetailResponse productDetailResponse = new ProductDetailResponse(
            product.getProductId(),
            product.getProductImage(),
            product.getMallImage(),
            product.getProductName(),
            product.getPrice(),
            product.getProductDetail(),
            product.getReviewScoreAvg(),
            product.getReviewList()
        );
        return productDetailResponse;
    }
}
