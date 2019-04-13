package com.pgleon.user.service.impl;

import com.pgleon.user.domain.mapper.UserMapper;
import com.pgleon.user.domain.pojo.Account;
import com.pgleon.user.service.IAccountService;
import com.pgleon.user.service.UserApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * insiAP 账户接口实现类
 * Created by Zev.Sun on 2017/1/4.
 */
@Service
public class AccountServiceImpl implements IAccountService {
    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    UserMapper userMapper;
    /**
     * 新增账户
     *
     * @param account
     * @return accountId
     */
    @Override
    public Account createAccount(Account account) throws Exception {
        if (!isAccountExist(account)) {
            //账户不存在
            try {
                Integer i = userMapper.insertAccount(account);
                return account;
            } catch (Exception ex) {
                logger.error("创建账户过程中出现异常", ex, account);
                throw new UserApiException.InternalServerException("创建账户过程中出现异常");
            }
        } else {
            logger.error("账户已存在", account);
            throw new UserApiException.accountAlreadyExistException("账户已存在");
        }
    }

    /**
     * 判断账户是否已经存在
     */
    public boolean isAccountExist(Account account) throws Exception {
        if (account == null || account.getUserName() == null) {
            throw new UserApiException.noEnoughArgsException("缺少必要字段");
        }
        List<Account> accounts = userMapper.findAccounts(account);
        if (accounts != null && accounts.size() > 0) {
            return true;
        }
        return false;
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