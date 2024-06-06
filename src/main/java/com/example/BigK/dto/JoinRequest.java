package com.example.BigK.dto;

import com.example.BigK.entity.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class JoinRequest {

    @NotBlank(message = "아이디를 입력해주세요.")
    private String loginId;

    @NotBlank(message = "닉네임을 입력해주세요.")
    private String nickname;

    @NotBlank(message = "아이디를 입력해주세요.")
    private String password;

    @NotBlank(message = "핸드폰 번호를 입력해주세요.")
    private String phoneNumber;
    public User toEntity(){
        return User.builder()
            .loginId(this.loginId)
            .password(this.password)
            .nickname(this.nickname)
            .phoneNumber(this.phoneNumber)
            .build();
    }
    public User toEntity(String encodedPassword) {
        return User.builder()
            .loginId(this.loginId)
            .password(encodedPassword)
            .nickname(this.nickname)
            .phoneNumber(this.phoneNumber)
            .build();
    }
}
