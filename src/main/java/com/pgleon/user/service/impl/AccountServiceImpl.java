package com.pgleon.user.service.impl;

import com.pgleon.user.domain.pojo.Account;
import com.pgleon.user.service.IAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * insiAP 账户接口实现类
 * Created by Zev.Sun on 2017/1/4.
 */
@Service
public class AccountServiceImpl implements IAccountService {
    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    /**
     * 新增账户
     *
     * @param account
     * @return accountId
     */
    @Override
    public Account createAccount(Account account) throws Exception {
        return null;
    }

    /**
     * 删除账户
     *
     * @param userId 删除账户的id
     * @return accountId
     */
    @Override
    public Integer deleteAccount(Integer userId) throws Exception {
        return null;
    }

    /**
     * 修改账户
     *
     * @param account 修改的账户
     * @return accountId
     */
    @Override
    public Integer updateAccount(Account account) throws Exception {
        return null;
    }

    /**
     * 单个账户查询
     *
     * @param userId
     * @return Account
     */
    @Override
    public Account findAccount(Integer userId) throws Exception {
        return null;
    }
}