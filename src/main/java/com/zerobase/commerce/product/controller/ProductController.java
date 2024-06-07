package com.zerobase.commerce.product.controller;

import com.zerobase.commerce.product.dto.ProductDto;
import com.zerobase.commerce.product.entity.Product;
import com.zerobase.commerce.product.service.ProductService;
import java.util.logging.Logger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/products")
@RestController
public class ProductController {

  private final ProductService productService;

  /**
   * 상품 등록
   * @param productDto
   * @return
   */
  @PostMapping
  public ResponseEntity<?> createProduct(@RequestBody ProductDto productDto) {
    log.info("[CreateProduct]");
    this.productService.saveProduct(productDto);
    return ResponseEntity.ok(productDto);
  }

  /**
   * 상품 조회(단건)
   * @return
   */
  @GetMapping("/{productId}")
  public ResponseEntity<?> findProduct(@PathVariable Long productId) {
    log.info("[FindProduct]");
    ProductDto result = ProductDto.from(this.productService.findByProductId(productId));
    return ResponseEntity.ok(result);
  }

  @GetMapping
  public ResponseEntity<?> findAllProduct(@PageableDefault(size = 20) Pageable pageable) {
    log.info("[FindAllProducts]");
    Page<?> result = this.productService.findByAllProducts(pageable).map(ProductDto::from);
    return ResponseEntity.ok(result);
  }

  /**
   * 상품 수정
   * @param productId
   * @param productDto
   * @return
   */
  @PostMapping("/{productId}")
  public ResponseEntity<?> updateProduct(@PathVariable Long productId, @RequestBody ProductDto productDto) {
    log.info("[UpdateProduct]");
    this.productService.updateProduct(productId, productDto);
    return ResponseEntity.ok("Update Product -> " + productId);
  }

  /**
   * 상품 삭제(단건) - productId
   * @param productId
   * @return
   */
  @DeleteMapping("/{productId}")
  public ResponseEntity<?> deleteProduct(@PathVariable Long productId) {
    log.info("[DeleteProduct]");
    this.productService.deleteProduct(productId);
    return ResponseEntity.ok("Delete Product -> " + productId);
  }

}
