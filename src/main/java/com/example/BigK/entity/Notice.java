package com.example.BigK.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Notice {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long id;

  @Column
  private int status;

  @Column
  private String department;

  @Column
  private String name;

  @Column
  private Date start_day;

  @Column
  private Date end_day;

  @Column
  private String link;

  @Column
  private int category;

  @Column
  private int stage;

  @Column
  private int field;

  @Column
  private int update_flag;


}
