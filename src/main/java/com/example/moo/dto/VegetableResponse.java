package com.example.moo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VegetableResponse {
  private String vegetableName;
  private String a;

  public VegetableResponse(String vegetableName, String a) {
    this.vegetableName = vegetableName;
    this.a = a;
  }
}
