package com.example.moo.service;

import com.example.moo.domain.Product;
import com.example.moo.dto.ProductListResponse;
import com.example.moo.external.ProductScrapper;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductListService {

  private final ProductScrapper productScrapper;

  public List<ProductListResponse> findProduct(String keyword) {
    Product product = productScrapper.scrape(keyword);
    return new ArrayList<>();
  }

}