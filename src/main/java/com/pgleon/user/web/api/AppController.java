package com.pgleon.user.web.api;

import com.google.common.collect.ImmutableMap;
import com.pgleon.mallspringboot.sign.NoNeedSign;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by leon on 2019-04-13 13:14
 */
@NoNeedSign
@RestController
@RequestMapping("/app")
public class AppController {

    /**
     * @Author Leon
     * @Description:获取服务端时间，进行时间校验
     **/
    @GetMapping("/systemTime/get")
    public Object getDateTime() {

        return ImmutableMap.builder()
                .put("dateTime", System.currentTimeMillis())
                .build();
    }




}
