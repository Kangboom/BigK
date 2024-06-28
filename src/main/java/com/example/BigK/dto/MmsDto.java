package com.example.BigK.dto;

import java.util.List;

public class MmsDto {

  private String email;
  private String category;
  private List<String> fields;
  private List<String> stages;

  // Getters and Setters
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public List<String> getFields() {
    return fields;
  }

  public void setFields(List<String> fields) {
    this.fields = fields;
  }

  public List<String> getStages() {
    return stages;
  }

  public void setStages(List<String> stages) {
    this.stages = stages;
  }
}
