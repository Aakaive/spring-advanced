package org.example.expert.aop;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDateTime;

@Aspect
@Slf4j
public class LoggingAspect {
    @Before("execution(* org.example.expert.domain.comment.controller.CommentAdminController.deleteComment(..)) ||" +
            "execution(* org.example.expert.domain.user.controller.UserAdminController.changeUserRole(..))")
    public void logAccess(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String userId = getUserIdFromRequest();
        String requestUrl = request.getRequestURL().toString();
        LocalDateTime requestTime = LocalDateTime.now();

        log.info("User ID: {} accessed URL: {} at: {} asdf", userId, requestUrl, requestTime);
    }

    private String getUserIdFromRequest() {
        return "exampleUserId";
    }
}
