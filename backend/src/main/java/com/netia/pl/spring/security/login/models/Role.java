package com.netia.pl.spring.security.login.models;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Enumerated(EnumType.STRING)
  @Column(length = 20)
  private EnumRole name;

  public Role() {

  }

  public Role(EnumRole name) {
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public EnumRole getName() {
    return name;
  }

  public void setName(EnumRole name) {
    this.name = name;
  }
}