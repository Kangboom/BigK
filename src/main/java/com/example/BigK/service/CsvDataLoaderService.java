package com.example.BigK.service;
import com.example.BigK.entity.Notice;
import com.example.BigK.repository.NoticeRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CsvDataLoaderService {

  private final NoticeRepository noticeRepository;

  @Transactional
  public void loadCsvData() throws IOException, CsvException {
    String csvFile = "C:\\Users\\USER\\Desktop\\bigkdatabase.csv"; // CSV 파일 경로를 설정합니다.
    try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
      List<String[]> rows = reader.readAll();
      List<Notice> notices = new ArrayList<>();

      for (String[] row : rows) {
        if (row[0].equals("id")) {
          continue; // Skip header row
        }
        Notice notice = Notice.builder()
            .status(Integer.parseInt(row[1])) // status 컬럼을 staus로 변경
            .department(row[2])
            .name(row[3])
            .start_day(new SimpleDateFormat("yyyy-MM-dd").parse(row[4]))
            .end_day(new SimpleDateFormat("yyyy-MM-dd").parse(row[5]))
            .link(row[6])
            .update_flag(Integer.parseInt(row[7])) // update 컬럼을 update_flag로 변경
            .category(Integer.parseInt(row[8]))
            .stage(Integer.parseInt(row[9]))
            .field(Integer.parseInt(row[10]))
            .build();
        notices.add(notice);
      }
      noticeRepository.saveAll(notices);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Transactional
  public void loadCsvSampleData() throws IOException, CsvException {
    String csvFile = "C:\\Users\\USER\\Desktop\\bigksample.csv"; // CSV 파일 경로를 설정합니다.
    try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
      List<String[]> rows = reader.readAll();
      List<Notice> notices = new ArrayList<>();

      for (String[] row : rows) {
        if (row[0].equals("id")) {
          continue; // Skip header row
        }
        Notice notice = Notice.builder()
            .status(Integer.parseInt(row[1])) // status 컬럼을 staus로 변경
            .department(row[2])
            .name(row[3])
            .start_day(new SimpleDateFormat("yyyy-MM-dd").parse(row[4]))
            .end_day(new SimpleDateFormat("yyyy-MM-dd").parse(row[5]))
            .link(row[6])
            .update_flag(Integer.parseInt(row[7])) // update 컬럼을 update_flag로 변경
            .category(Integer.parseInt(row[8]))
            .stage(Integer.parseInt(row[9]))
            .field(Integer.parseInt(row[10]))
            .build();
        notices.add(notice);
      }
      noticeRepository.saveAll(notices);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

