package com.example.BigK.service;
import com.example.BigK.dto.MmsDto;
import com.example.BigK.entity.Mms;
import com.example.BigK.repository.MmsRepository;
import com.example.BigK.repository.NoticeRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.util.Optional;
import org.springframework.mail.javamail.MimeMessageHelper;
import com.example.BigK.dto.EmailMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring6.SpringTemplateEngine;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailService {
  private final JavaMailSender javaMailSender;
  private final SpringTemplateEngine templateEngine;
  private final NoticeRepository noticeRepository;
  private final UserService userService;
  private final MmsRepository mmsRepository;
  // 이메일 정보를 받아 전송하는 메서드
  public void sendMail(EmailMessage emailMessage) {

    MimeMessage mimeMessage = javaMailSender.createMimeMessage();

    try {
      MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
      mimeMessageHelper.setTo(emailMessage.getTo()); // 메일 수신자
      mimeMessageHelper.setSubject(emailMessage.getSubject()); // 메일 제목
      mimeMessageHelper.setText("설정하신 카테고리 관련 새로운 공고가 업로드 되었습니다."); // 메일 본문 내용, HTML 여부
      javaMailSender.send(mimeMessage);

      log.info("Success");

    } catch (MessagingException e) {
      log.info("fail");
      throw new RuntimeException(e);
    }
  }

  public void updateInfo(EmailMessage emailMessage){

  }

  public Mms saveOrUpdateMms(MmsDto mmsDto) {
    Optional<Mms> existingMms = mmsRepository.findByEmail(mmsDto.getEmail());

    Mms mms;
    if (existingMms.isPresent()) {
      mms = existingMms.get();
      mms.setCategory(mmsDto.getCategory());
      mms.setFields(mmsDto.getFields());
      mms.setStages(mmsDto.getStages());
    } else {
      mms = new Mms();
      mms.setEmail(mmsDto.getEmail());
      mms.setCategory(mmsDto.getCategory());
      mms.setFields(mmsDto.getFields());
      mms.setStages(mmsDto.getStages());
    }

    return mmsRepository.save(mms);
  }
}
