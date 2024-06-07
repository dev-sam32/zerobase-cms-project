package com.zerobase.commerce.product.service;

import com.zerobase.commerce.product.dto.ProductDto;
import com.zerobase.commerce.product.entity.CategoryType;
import com.zerobase.commerce.product.entity.Product;
import com.zerobase.commerce.product.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.procedure.ProcedureOutputs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;

  // 상품 조회(단건)
  public Product findByProductId(Long productId) {
    log.info("[findByProductId] productId : {}", productId);
    return this.productRepository.findById(productId)
        .orElseThrow(() -> new EntityNotFoundException("상품을 찾을 수 없습니다. - productId: " + productId));
  }

  // 상품 조회(전체)
  public Page<Product> findByAllProducts(Pageable pageable) {
    return this.productRepository.findAll(pageable);
  }

  // 상품 등록
  public Product saveProduct(ProductDto productDto) {
    log.info("[findByProductId] productName : {}", productDto.name());
    Product product = productDto.toEntity();
    return this.productRepository.save(product);
  }

  // 상품 수정
  public Product updateProduct(Long productId, ProductDto productDto) {
    Product product = this.productRepository.getReferenceById(productId);

    Optional.ofNullable(productDto.name()).ifPresent(product::setName);
    Optional.ofNullable(productDto.category()).ifPresent(product::setCategory);
    Optional.ofNullable(productDto.price()).ifPresent(product::setPrice);
    Optional.ofNullable(productDto.stock()).ifPresent(product::setStock);

    this.productRepository.save(product);

    return product;
  }

  // 상품 삭제
  public void deleteProduct(Long productId) {
    this.productRepository.deleteById(productId);
  }


}
