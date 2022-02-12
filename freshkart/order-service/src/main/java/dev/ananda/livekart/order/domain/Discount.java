package dev.ananda.livekart.order.domain;

import dev.ananda.livekart.domain.BaseDomain;
import lombok.Data;

@Data
public class Discount extends BaseDomain {
  private String id;
  private String name;
  private String description;
  private DiscountType type;
}
