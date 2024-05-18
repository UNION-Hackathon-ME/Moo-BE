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
    return em.createQuery("SELECT r FROM Review r WHERE r.productId = :productId", Review.class)
        .setParameter("productId", productId)
        .getResultList();
  }

  @Override
  public double selectReviewAvg(String productId) {
    Double avg = em.createQuery("SELECT AVG(r.score) FROM Review r WHERE r.productId = :productId", Double.class)
        .setParameter("productId", productId)
        .getSingleResult();
    return avg == null ? 0 : Double.parseDouble(String.format("%.1f", avg));
  }
}
