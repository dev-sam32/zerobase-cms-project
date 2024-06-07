package com.zerobase.commerce.product.dto;

import com.zerobase.commerce.product.entity.CategoryType;
import com.zerobase.commerce.product.entity.Product;

public record ProductDto(
    String name,
    String category,
    int price,
    int stock
) {

  /**
   * 생성자(이름, 카테고리)
   * @param name
   * @param category
   * @return
   */
  public static ProductDto of(String name, String category) {
    return of(name, category, 0, 0);
  }

  /**
   * 생성자(이름, 카테고리, 가격, 재고)
   * @param name
   * @param category
   * @param price
   * @param stock
   * @return
   */
  public static ProductDto of(String name, String category, int price, int stock) {
    return new ProductDto(name, category, price, stock);
  }

  /**
   * Entity -> DTO
   * @param product
   * @return
   */
  public static ProductDto from(Product product) {
    return new ProductDto(
        product.getName(),
        product.getCategory().getCode(),
        product.getPrice(),
        product.getStock()
    );
  }

  /**
   * DTO -> Entity
   * @return
   */
  public Product toEntity() {
    return Product.builder()
        .name(name)
        .category(CategoryType.valueOf(category.toUpperCase()))
        .price(price)
        .stock(stock)
        .build();
  }
}
