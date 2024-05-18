package com.example.moo.service;

import com.example.moo.domain.Product;
import com.example.moo.dto.ProductListResponse;
import com.example.moo.external.ProductScraper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductListService {

  private final ProductScraper productScrapper;

  public List<ProductListResponse> findProduct(String keyword) throws IOException, ParseException {
    List<Product> productList = productScrapper.scrape(keyword);
    List<ProductListResponse> productListResponseList = new ArrayList<>();
    return productListResponseList;
  }

}