package dev.ananda.livekart.domain;

import java.time.ZonedDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BaseDomain {
  private String createdBy;
  private String modifiedBy;
  private ZonedDateTime persistedOn;
  private ZonedDateTime updatedOn;

  @JsonProperty("isDeleted")
  private boolean deleted;
}
