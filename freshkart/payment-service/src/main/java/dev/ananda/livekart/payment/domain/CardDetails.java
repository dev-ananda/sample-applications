package dev.ananda.livekart.payment.domain;

import lombok.Data;

@Data
public class CardDetails {
  private String uniqueNumber;
  private int expiryMonth;
  private int expiryYear;
}
