package com.example.BigK.dto;

import com.example.BigK.entity.Notice;
import com.example.BigK.entity.User;
import jakarta.persistence.Column;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NoticeDto {

  private int status;
  private String department;
  private String name;
  private Date start_day;
  private Date end_day;
  private String link;
  private int category;
  private int stage;
  private int field;
  private int update_flag;

  public Notice toEntity(){
    return Notice.builder()
        .status((this.status))
        .department(this.department)
        .name(this.name)
        .start_day(this.start_day)
        .end_day(this.end_day)
        .link(this.link)
        .update_flag(this.update_flag)
        .category(this.category)
        .stage(this.stage)
        .field(this.field)
        .build();
  }
  public static NoticeDto fromEntity(Notice notice) {
    return new NoticeDto(
        notice.getStatus(),
        notice.getDepartment(),
        notice.getName(),
        notice.getStart_day(),
        notice.getEnd_day(),
        notice.getLink(),
        notice.getCategory(),
        notice.getStage(),
        notice.getField(),
        notice.getUpdate_flag()
    );
  }
}
