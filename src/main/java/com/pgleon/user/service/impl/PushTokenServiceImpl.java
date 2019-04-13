package com.pgleon.user.service.impl;

import com.pgleon.user.domain.mapper.PushTokenMapper;
import com.pgleon.user.service.IPushTokenService;
import org.apache.coyote.PushToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by leon on 2019-04-13 13:26
 */
@CacheConfig(cacheNames = "pushToken")
@Service
public class PushTokenServiceImpl implements IPushTokenService {

    @Autowired
    private PushTokenMapper pushTokenMapper;

    @Override
    public Object create(PushToken pushToken) {
        return null;
    }

    @Override
    public PushToken getOne(String token, int userId) {
        return null;
    }

    @Override
    public List<PushToken> getList(int userId) {
        return null;
    }
}
