package dev.ananda.livekart.product.domain;

import java.time.ZonedDateTime;
import java.util.Currency;
import dev.ananda.livekart.domain.BaseDomain;
import dev.ananda.livekart.domain.Location;
import lombok.Data;

@Data
public class Inventory extends BaseDomain {
  private String id;
  private String productId;
  private long quantity;
  private String sellerId;
  private Location location;

  /**
   * manufacture and validity details
   */
  private String batchId;
  private ZonedDateTime manufacturedOn;
  private ZonedDateTime expireOn;

  private double mrp;
  private double retailPrice;
  private Currency currency;
}
