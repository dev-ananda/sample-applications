package dev.ananda.livekart.user.domain;

import dev.ananda.livekart.domain.BaseDomain;
import lombok.Data;

@Data
public class User extends BaseDomain {
  private String id;
  private String userName;
  private String password;
  private String name;
  private String nickName;
  private String contactNo;

  private Category category;
}
