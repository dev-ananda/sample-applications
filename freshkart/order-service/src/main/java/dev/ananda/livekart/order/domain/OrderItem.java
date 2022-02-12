package dev.ananda.livekart.order.domain;

import dev.ananda.livekart.domain.BaseDomain;
import lombok.Data;

@Data
public class OrderItem extends BaseDomain {
  private String id;
  private String orderId;
  private String productId;
  private String inventoryId;

  private long quantity;
  private double unitPrice;

  // quantity * unitPrice
  private double totalAmount;

  // totalAmount - discount (if any)
  private double effectiveAmountPaid;
}
