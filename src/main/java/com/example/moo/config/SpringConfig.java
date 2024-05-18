package com.example.moo.config;

import com.example.moo.repository.ReviewRepository;
import com.example.moo.repository.ReviewRepositoryImpl;
import com.example.moo.service.ProductReviewService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
  private EntityManager em;

  @Autowired
  public SpringConfig(EntityManager em) {
    this.em = em;
  }

  @Bean
  public ProductReviewService productReviewService() {
    return new ProductReviewService(reviewRepository());
  }

  @Bean
  public ReviewRepositoryImpl reviewRepository() {
    return new ReviewRepositoryImpl(em);
  }

}
