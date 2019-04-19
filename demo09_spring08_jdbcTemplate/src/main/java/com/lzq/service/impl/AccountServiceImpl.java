package com.lzq.service.impl;

import com.lzq.dao.AccountDao;
import com.lzq.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao dao;


    @Override
    public void transfer(String from, String to, double money) {

        double fromMoney = dao.queryMoney(from);

        dao.update(from,fromMoney - money);
        System.out.println(1/0);
        double toMoney = dao.queryMoney(to);
        dao.update(to,toMoney + money);
    }
}
