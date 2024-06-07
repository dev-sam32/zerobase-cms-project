package com.zerobase.commerce.product.entity;

import com.zerobase.commerce.common.entity.AuditingFields;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "PRODUCT")
public class Product extends AuditingFields {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Setter
  @Column(length = 10, nullable = false)
  private String name;

  @Column(length = 10, nullable = false)
  @Enumerated(EnumType.STRING)
  private CategoryType category;

  @Setter
  @Column(nullable = false)
  @Builder.Default
  private int price = 0;

  @Setter
  @Column(nullable = false)
  @Builder.Default
  private int stock = 0;

  public void setCategory(String category) {
    this.category = CategoryType.valueOf(category.toUpperCase());
  }
}
