package com.pgleon.user.service;

import com.pgleon.user.domain.pojo.Account;

import java.util.List;

/**
 * Created by leon on 2019-04-11 12:04
 */
public interface IAccountService {
    /**
     * 新增账户
     *
     * @return accountId
     */
    Account createAccount(Account account) throws Exception;

    /**
     * 删除账户
     *
     * @param userId 删除账户的id
     * @return accountId
     */
    Integer deleteAccount(Integer userId) throws Exception;

    /**
     * 修改账户
     *
     * @param account 修改的账户
     * @return accountId
     */
    Integer updateAccount(Account account) throws Exception;

    /**
     * 单个账户查询
     *
     * @return Account
     */
    Account findAccount(Integer userId) throws Exception;


}
