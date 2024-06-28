package com.example.BigK.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SearchDto {
  private String query;
  private List<Integer> statuses;
  private List<Integer> categories;
  private List<Integer> stages;
  private List<Integer> fields;

  public SearchDto(){
    statuses = new ArrayList<>();
    categories = new ArrayList<>();
    stages = new ArrayList<>();
    fields = new ArrayList<>();
  }

  public void setWebData(String queries, List<String> statuses, List<String> categories, List<String> stages, List<String> fields) {
    this.query = queries;

    // 각 카테고리, 단계, 분야 목록에서 숫자를 추출하여 리스트에 추가
    for (String status : statuses) {
      this.statuses.add(extractNumber(status));
    }
    for (String category : categories) {
      this.categories.add(extractNumber(category));
    }
    for (String stage : stages) {
      this.stages.add(extractNumber(stage));
    }
    for (String field : fields) {
      this.fields.add(extractNumber(field));
    }
  }
  // 문자열에서 숫자 추출 후 int 변환
  private Integer extractNumber(String data) {
    String number = data.replaceAll("[^0-9]", ""); // 숫자가 아닌 모든 문자를 제거
    System.out.println(data + "->"+ number + " 변환 성공");
    return Integer.parseInt(number); // 추출된 문자열을 정수로 변환
  }
}
