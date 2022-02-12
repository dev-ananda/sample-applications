package dev.ananda.livekart.product.domain;

import dev.ananda.livekart.domain.BaseDomain;
import lombok.Data;

@Data
public class SubCategory extends BaseDomain {
  private String id;
  private String categoryId;
  private String name;
  private String description;
}
