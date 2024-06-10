package com.example.BigK.controller;

import com.example.BigK.dto.SearchDataDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {
    @PostMapping("/search")
    public ResponseEntity<String> receiveActiveItems(@RequestBody SearchDataDto searchData) {
        System.out.println("Received query: " + searchData.getQuery());
        System.out.println("Received statuses: " + searchData.getStatuses());
        System.out.println("Received categories: " + searchData.getCategories());
        System.out.println("Received stages: " + searchData.getStages());
        System.out.println("Received fields: " + searchData.getFields());

        // 검색 및 필터링 로직을 구현할 수 있음

        return ResponseEntity.ok("Search data processed successfully!");
    }
}
