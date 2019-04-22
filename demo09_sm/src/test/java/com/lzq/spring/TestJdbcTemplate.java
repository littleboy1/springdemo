package com.lzq.spring;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class TestJdbcTemplate {


    @Test
    public void test(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        dataSource.setUrl("jdbc:mysql://localhost:3306/spring");

        dataSource.setUsername("root");

        dataSource.setPassword("admin");

        JdbcTemplate template = new JdbcTemplate(dataSource);

        template.update("insert into account values (null,?,?)","测试11",10022);


    }
}
