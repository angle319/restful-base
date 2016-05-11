package com.ccolor.mybatis.mapper;

import com.ccolor.mybatis.bean.Account;

public interface AccountMapper {

  Account getAccountByUsername(String username);

}
