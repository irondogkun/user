package com.pgleon.user.domain.mapper;

import org.apache.coyote.PushToken;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by leon on 2019-04-13 13:28
 */
@Mapper
public interface PushTokenMapper {

    @Insert("insert into push_token " +
            "(push_token, push_platform, device_id,app_id,app_version,app_version_name,app_os," +
            "agent_id,company_id,created,modified)" +
            "values" +
            "(#{o.pushToken}, #{o.pushPlatform}, #{o.deviceId}, #{o.app_id}, #{o.app_version}, #{o.app_version_name}, #{o.app_os}," +
            " #{o.agentId},#{o.companyId}, now(), now());")
    int create(@Param("o") PushToken o);

    @Select("select id as pushTokenId,push_token as pushToken, push_platform as pushPlatform, " +
            "device_id as deviceId,app_id ,app_version ,app_version_name ,app_os ,agent_id as agentId " +
            "from push_token " +
            "where push_token=#{token} and agent_id=#{agentId}")
    PushToken getOne(@Param("token") String token, @Param("agentId") int agentId);

    @Select("select id as pushTokenId,push_token as pushToken, push_platform as pushPlatform, " +
            "device_id as deviceId,app_id ,app_version ,app_version_name ,app_os ,agent_id as agentId " +
            "from push_token " +
            "where app_id=#{o.app_id} and app_version=#{o.app_version} and agent_id=#{o.agentId}")
    PushToken get(@Param("o") PushToken o);

    @Select("select id as pushTokenId,push_token as pushToken, push_platform as pushPlatform, " +
            "device_id as deviceId,app_id ,app_version ,app_version_name ,app_os ,agent_id as agentId " +
            "from push_token " +
            "where agent_id=#{agentId}")
    List<PushToken> getList(@Param("agentId") int agentId);
}
