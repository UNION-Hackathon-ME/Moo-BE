package com.example.moo.service;

import com.example.moo.domain.Vegetable;
import com.example.moo.dto.VegetableResponse;
import com.example.moo.external.ProductScrapper;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
  private final ProductScrapper productScrapper;

  public List<VegetableResponse> findVegetables() {
    Vegetable vegetable = productScrapper.scrape();
    return new ArrayList<>();
  }
}
