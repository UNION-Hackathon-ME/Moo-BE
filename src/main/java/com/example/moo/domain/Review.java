package com.example.moo.domain;

import com.example.moo.repository.ReviewRepository;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Review {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column
  private String productId;

  @Column
  private double score;

  @Column
  private String comment;

  public Review(String productId, double score, String comment) {
    this.productId = productId;
    this.score = score;
    this.comment = comment;
  }
}
