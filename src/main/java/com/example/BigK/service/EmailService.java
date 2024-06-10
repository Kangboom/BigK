package com.example.BigK.service;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
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

  private final UserService userService;

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
}
