package com.example.moo.service;

import com.example.moo.domain.Review;
import com.example.moo.repository.ReviewRepository;
import jakarta.transaction.Transactional;

@Transactional
public class ProductReviewService {
  private final ReviewRepository repository;

  public ProductReviewService(ReviewRepository repository) {
    this.repository = repository;
  }

  public void saveReview(Review review) {
    repository.save(review);
  }
}
