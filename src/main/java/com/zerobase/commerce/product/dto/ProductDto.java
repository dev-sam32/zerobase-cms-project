package com.zerobase.commerce.product.dto;

import com.zerobase.commerce.product.entity.Product;

public record ProductDto(
    Long id,
    String name,
    String category,
    int price,
    int stock
) {

  public static ProductDto of(Long id, String name, String category) {
    return of(id, name, category, 0, 0);
  }

  public static ProductDto of(Long id, String name, String category, int price, int stock) {
    return new ProductDto(id, name, category, price, stock);
  }

  public static ProductDto from(Product product) {
    return new ProductDto(
        product.getId(),
        product.getName(),
        product.getCategory(),
        product.getPrice(),
        product.getStock()
    );
  }

  public Product toEntity() {
    return Product.builder()
        .name(name)
        .category(category)
        .price(price)
        .stock(stock)
        .build();
  }
}
