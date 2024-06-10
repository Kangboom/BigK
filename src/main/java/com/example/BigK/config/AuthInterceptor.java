//package com.example.BigK.config;
//
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.bind.annotation.CookieValue;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//@Configuration
//public class AuthInterceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(@CookieValue(name= "userId", required = false) HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        Cookie[] cookies = request.getCookies();
//        if (cookies != null) {
////            for (Cookie cookie : cookies) {
////                if ("authToken".equals(cookie.getName()) && "userAuthToken".equals(cookie.getValue())) {
////                    return true; // 인증된 사용자
////                }
////            }
//            return true;
//        }
//        response.sendRedirect("/login"); // 인증되지 않은 경우 로그인 페이지로 리디렉션
//        return false;
//    }
//}
