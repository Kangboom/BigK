package com.example.BigK.dto;

import java.util.List;

public class InputDto {
    private String query;
    private List<String> statuses;
    private List<String> categories;
    private List<String> stages;
    private List<String> fields;

    // Getters and Setters
    public String getQuery() {
        return query;
    }
    public void setQuery(String query) {
        this.query = query;
    }

    public List<String> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<String> statuses) {
        this.statuses = statuses;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<String> getStages() {
        return stages;
    }

    public void setStages(List<String> stages) {
        this.stages = stages;
    }

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }
}
