package com.ccolor.mybatis.service;

import com.ccolor.mybatis.bean.Account;
import com.ccolor.mybatis.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

  @Autowired
  private AccountMapper accountMapper;

  public Account getAccount(String username) {
	
    return accountMapper.getAccountByUsername(username);
  }
}
