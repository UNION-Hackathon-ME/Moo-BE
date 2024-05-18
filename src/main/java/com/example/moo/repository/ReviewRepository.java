package com.example.moo.repository;

import com.example.moo.domain.Review;
import com.example.moo.dto.ProductReviewRequest;
import java.util.List;

public interface ReviewRepository {
  void save(Review review);
  List<Review> findReviews(String productId);
}
