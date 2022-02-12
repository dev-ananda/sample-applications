package dev.ananda.livekart.product.domain;

import dev.ananda.livekart.domain.BaseDomain;
import lombok.Data;

@Data
public class Category extends BaseDomain {
  private String id;
  private String name;
  private String description;
}
