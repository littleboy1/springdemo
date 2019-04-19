package com.lzq.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
@Repository
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

//    @Resource
//    private JdbcTemplate jdbcTemplate;
    //第一種方式装备数据源
//    @Autowired
//    public AccountDaoImpl(DataSource dataSource) {
//
//        setDataSource(dataSource);
//    }

    @Autowired
    private DataSource dataSource;


    @PostConstruct
    private void  initialize(){
        setDataSource(dataSource);
    }

    @Override
    public void update(String name, double money) {

//        jdbcTemplate.update("update account set money = "+money+" where name = " +"'"+ name + "'" );
        this.getJdbcTemplate().update("update account set money = "+money+" where name = " +"'"+ name + "'" );
    }

    @Override
    public double queryMoney(String name) {

//        double  money = jdbcTemplate.queryForObject("select money from account where name = ? ", new RowMapper<Double>() {
        double  money = this.getJdbcTemplate().queryForObject("select money from account where name = ? ", new RowMapper<Double>() {
            @Override
            public Double mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getDouble("money");
            }
        }, name);
        return money;
    }


}
