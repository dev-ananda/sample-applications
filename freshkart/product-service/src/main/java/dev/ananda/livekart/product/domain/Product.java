package dev.ananda.livekart.product.domain;

import dev.ananda.livekart.domain.BaseDomain;
import lombok.Data;

@Data
public class Product extends BaseDomain {
  private String id;
  private String name;
  private String description;
  private String sku;
  private Category category;
  private SubCategory subCategory;
  private Unit unit;
  private String unitValue;
}
