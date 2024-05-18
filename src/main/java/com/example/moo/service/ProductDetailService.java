package com.example.moo.service;

import com.example.moo.domain.Product;
import com.example.moo.dto.ProductDetailResponse;
import com.example.moo.dto.ProductListResponse;
import com.example.moo.external.ProductScraper;
import com.example.moo.external.ProductScrapper;
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

    public List<ProductDetailResponse> findProduct(String keyword)
        throws IOException, ParseException {
        List<Product> productList = productScraper.scrape(keyword);
        List<ProductDetailResponse> productListResponseList = new ArrayList<>();
        return productListResponseList;
    }
}
