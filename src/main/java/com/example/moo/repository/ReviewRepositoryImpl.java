package com.example.moo.repository;

import com.example.moo.domain.Review;
import jakarta.persistence.EntityManager;
import java.util.List;

public class ReviewRepositoryImpl implements ReviewRepository {
  private final EntityManager em;

  public ReviewRepositoryImpl(EntityManager em) {
    this.em = em;
  }

  @Override
  public void save(Review review) {
    em.persist(review);
  }

  @Override
  public List<Review> findReviews(String productId) {
    return em.createQuery("SELECT * FROM review WHERE product_id = " + productId, Review.class).getResultList();
  }
}
