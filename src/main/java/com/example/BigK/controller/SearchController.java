package com.example.BigK.controller;

import com.example.BigK.dto.InputDto;
import com.example.BigK.dto.SearchDto;
import com.example.BigK.entity.Notice;
import com.example.BigK.service.CsvDataLoaderService;
import com.example.BigK.service.NoticeService;
import com.opencsv.exceptions.CsvException;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class SearchController {

    private final NoticeService noticeService;
    private final CsvDataLoaderService csvDataLoaderService;
    @PostMapping("/search")
    public String receiveActiveItems(@ModelAttribute InputDto inputData, Model model) {



        SearchDto searchDto = new SearchDto();
        searchDto.setWebData(inputData.getQuery(), inputData.getStatuses(), inputData.getCategories(), inputData.getStages(), inputData.getFields());

        // 검색 및 필터링 로직을 구현할 수 있음
        List<Notice> noticeList = noticeService.search(searchDto);
        for (Notice notice : noticeList) {
            // 웹에서 전송한거 DTO로 받아오기
            System.out.println("Received query: " + inputData.getQuery());
            System.out.println("Received statuses: " + inputData.getStatuses());
            System.out.println("Received categories: " + inputData.getCategories());
            System.out.println("Received stages: " + inputData.getStages());
            System.out.println("Received fields: " + inputData.getFields()+"\n");

            System.out.println("status: " + notice.getStatus());
            System.out.println("category: " + notice.getCategory());
            System.out.println("stage: " + notice.getStage());
            System.out.println("field: " + notice.getField());
            System.out.println("----------------------------------------");
        }

        // notice 전달
        model.addAttribute("notices", noticeList);

        return "notice";
    }

//    @GetMapping("/search-test")
//    public String searchTest(){
//        noticeService.setNoticeTest();
//        return "home";
//    }

    @GetMapping("/csvdata")
    public String test2(Model model) throws IOException, CsvException {
        csvDataLoaderService.loadCsvData();

        return "home";
    }
}
