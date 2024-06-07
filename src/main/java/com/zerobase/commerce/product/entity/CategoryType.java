package com.zerobase.commerce.product.entity;

import java.util.Arrays;
import lombok.Getter;

@Getter
public enum CategoryType {
  FOOD("food", "책");

  private String code;
  private String name;

  CategoryType(String code, String name) {
    this.code = code;
    this.name = name;
  }
}
