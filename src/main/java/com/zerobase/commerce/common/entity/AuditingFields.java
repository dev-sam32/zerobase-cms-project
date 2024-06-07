package com.zerobase.commerce.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Converter;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateTimeConverter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class AuditingFields {
  @CreatedDate
  @Column(nullable = false, updatable = false)
  private LocalDateTime createdAt;    // 생성일시

  @LastModifiedDate
  @Column(nullable = false)
  private LocalDateTime modifiedAt;   // 수정일시
}
