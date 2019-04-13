package com.pgleon.user.web.api;


import com.google.common.collect.ImmutableMap;
import com.pgleon.mallspringboot.PagingParam;
import com.pgleon.rpcapi.user.UserService;
import com.pgleon.user.domain.pojo.Account;
import com.pgleon.user.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by leon on 2019-04-11 11:54
 */
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @Autowired
    private UserService userService;


    /**
     * @Description:  管理台账户新建
     * @Param: account 账户对象
     * @Return:
     */
    @PostMapping("/create")
    public Object accountCreate( @RequestBody Account account) throws Exception {
        accountService.createAccount(account);
        return account;
    }

    /**
     * @Description:  管理台账户删除
     * @Param: userId 需要删除的账户id
     * @Return:
     */
    @DeleteMapping("/{userId}/delete")
    public Object accountDelete( @PathVariable("userId") Integer userId) throws Exception {
        accountService.deleteAccount(userId);
        return ImmutableMap.builder()
                .put("userId", userId)
                .build();
    }

    /**
     * @Description:  管理台账户修改
     * @Param: userId 需要修改的账户对象
     * @Return:
     */
    @PutMapping("/{accountId}/update")
    public Object accountUpdate( @PathVariable("accountId") Integer accountId, @RequestBody Account account) throws Exception {
        accountService.updateAccount(account);
        return ImmutableMap.builder()
                .put("userId", account.getUserId())
                .build();
    }

    /**
     * @Description:  管理台账户查询
     * @Param: userId 需要删除的账户id
     * @Return:
     */
    @GetMapping("/{accountId}/get")
    public Object accountGet( @PathVariable("accountId") Integer userId) throws Exception {
        Account account = accountService.findAccount(userId);
        return account;
    }

}
