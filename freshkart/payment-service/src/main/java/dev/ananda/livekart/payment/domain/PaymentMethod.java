package dev.ananda.livekart.payment.domain;

import dev.ananda.livekart.domain.BaseDomain;
import lombok.Data;

@Data
public class PaymentMethod extends BaseDomain {
  private String id;
  private String userId;
  private PaymentType type;
}
