package com.example.BigK.service;

import com.example.BigK.dto.NoticeDto;
import com.example.BigK.dto.SearchDto;
import com.example.BigK.entity.Notice;
import com.example.BigK.repository.NoticeRepository;
import com.example.BigK.repository.UserRepository;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class NoticeService {
  private final NoticeRepository noticeRepository;
  private final UserRepository userRepository;


  // 데이터 베이스 테스트 만드는 함수
  public void setNoticeTest() {
    NoticeDto notice = new NoticeDto();
    notice.setStatus(1);
    notice.setDepartment("Finance");
    notice.setName("Annual Financial Report");
    notice.setStart_day(new Date());
    notice.setEnd_day(new Date());
    notice.setLink("http://example.com/report");
    notice.setCategory(1);
    notice.setStage(1);
    notice.setField(1);
    notice.setUpdate_flag(0);
    noticeRepository.save(notice.toEntity());
  }

  // 1. 새로운 공지 확인 메서드


  // 2. 데이터베이스에서 선택된 카테고리 가져오는 메서드
  public List<Notice> search(SearchDto searchData) {
    return noticeRepository.findAll((Specification<Notice>) (root, query, criteriaBuilder) -> {
      List<Predicate> predicates = new ArrayList<>();

      // Query matches name
      if (searchData.getQuery() != null && !searchData.getQuery().isEmpty()) {
        predicates.add(criteriaBuilder.like(root.get("name"), "%" + searchData.getQuery() + "%"));
      }

      // Statuses filter
      if (searchData.getStatuses() != null && !searchData.getStatuses().isEmpty()) {
        predicates.add(root.get("status").in(searchData.getStatuses()));
      }

      // Categories filter
      if (searchData.getCategories() != null && !searchData.getCategories().isEmpty()) {
        predicates.add(root.get("category").in(searchData.getCategories()));
      }

      // Stages filter
      if (searchData.getStages() != null && !searchData.getStages().isEmpty()) {
        predicates.add(root.get("stage").in(searchData.getStages()));
      }

      // Fields filter
      if (searchData.getFields() != null && !searchData.getFields().isEmpty()) {
        predicates.add(root.get("field").in(searchData.getFields()));
      }

      return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    });
  }
}
