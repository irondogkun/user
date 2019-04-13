package com.pgleon.user.service;

import org.apache.coyote.PushToken;

import java.util.List;

/**
 * Created by leon on 2019-04-13 13:16
 */
public interface IPushTokenService {
    Object create(PushToken pushToken);

    PushToken getOne(String token, int userId);

    List<PushToken> getList(int userId);
}
