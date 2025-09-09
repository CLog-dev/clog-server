package com.hyomee.clog;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
@Component
@RequiredArgsConstructor
@Profile("dev")
public class DatabaseTest {

    private final DataSource dataSource;

    @PostConstruct
    public void testConnection() {
        try (Connection conn = dataSource.getConnection()) {
            log.info("✅ DB 연결에 성공했습니다. 연결 URL: {}", conn.getMetaData().getURL());
            log.info("DB 드라이버: {}", conn.getMetaData().getDriverName());
        } catch (SQLException e) {
            log.info("❌ DB 연결에 실패했습니다.: {}", e.getMessage());
        }
    }
}