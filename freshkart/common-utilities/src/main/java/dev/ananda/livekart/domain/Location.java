package dev.ananda.livekart.domain;

import lombok.Data;

@Data
public class Location {
  private String displayName;
  private double lat;
  private double lon;
}
