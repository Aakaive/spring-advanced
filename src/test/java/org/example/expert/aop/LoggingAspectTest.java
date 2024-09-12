package org.example.expert.aop;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")  // 또는 테스트 프로파일을 사용할 경우
public class LoggingAspectTest {

    @Test
    public void testLogAccess() {
        // Mock HttpServletRequest
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getRequestURL()).thenReturn(new StringBuffer("http://example.com/api/comments/123"));

        // Mock ServletRequestAttributes
        ServletRequestAttributes attributes = new ServletRequestAttributes(request);
        RequestContextHolder.setRequestAttributes(attributes);

        // Create a LoggingAspect instance
        LoggingAspect loggingAspect = new LoggingAspect();

        // Create a mock JoinPoint
        JoinPoint joinPoint = mock(JoinPoint.class);

        // Call logAccess method
        loggingAspect.logAccess(joinPoint);

        // Verify that the log method was called
        // Use a logging framework to capture the logs or verify via an assert statement
        // For simplicity, you can check the log output manually or use a tool to capture logs
    }
}
