package com.lzq.spring;


import com.lzq.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:Spring_config.xml")
public class UserSpringIOCTemplate {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test2(){

        jdbcTemplate.update("inse rt into account values (null,?,?)","测试",10000);
    }

    @Test
    public void test3(){

        List<Account> accounts = jdbcTemplate.query("select * from account", new MybeanMapper(), null);
        System.out.println(accounts);
    }

}
class MybeanMapper implements RowMapper{

    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();
        account.setId(rs.getInt("id"));
        account.setName(rs.getString("name"));
        account.setMoney(rs.getInt("money"));
        return account;
    }
}