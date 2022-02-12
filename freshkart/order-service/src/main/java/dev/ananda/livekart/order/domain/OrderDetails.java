package dev.ananda.livekart.order.domain;

import java.util.List;
import dev.ananda.livekart.domain.BaseDomain;
import lombok.Data;

@Data
public class OrderDetails extends BaseDomain {
  private String id;
  private String userId;
  private double totalAmount;
  private String paymentId;
  private List<Discount> appliedDiscounts;
  private List<OrderItem> orderItems;
}
