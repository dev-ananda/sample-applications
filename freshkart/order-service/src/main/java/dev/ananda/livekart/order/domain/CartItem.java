package dev.ananda.livekart.order.domain;

import dev.ananda.livekart.domain.BaseDomain;
import lombok.Data;

@Data
public class CartItem extends BaseDomain {
  private String cartId;
  private String productId;
  private long quantity;
}
