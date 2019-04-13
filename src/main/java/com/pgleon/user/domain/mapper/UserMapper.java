package com.pgleon.user.domain.mapper;

import com.pgleon.rpcapi.user.pojo.TokenIdentity;
import com.pgleon.user.domain.pojo.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Description 用户模块接口
 * Created by leon on 2019-04-11 15:47
 */
@Mapper
public interface UserMapper {
    /**
     * @Description: 用户登录成功后 生成token并存储
     */
    @Insert("insert into token (user_id, token, app_id, device_id, device_name, created) values (#{userId}, #{token}, #{appId}, #{deviceId}, #{deviceName},now())")
    int insertUserIdAndToken(@Param("userId") int userId, @Param("token") String token, @Param("appId") String appId, @Param("deviceId") String deviceId, @Param("deviceName") String deviceName);

    /**
     * @Description: 用户退出登录删除token
     */
    @Delete("delete from token where token = #{user_token} and user_id = #{userId}")
    int deleteToken(@Param("user_token") String user_token, @Param("userId") int userId);

    /**
     * @Description: 用户退出登录删除token
     */
    @Delete("delete from token where user_id = #{userId} and app_id = #{appId}")
    boolean deleteInvalidateToken(@Param("userId") Integer userId, @Param("appId") String appId);

    @Delete("delete from token where token = #{token}")
    boolean deleteInvalidateTokenByToken(@Param("token") String token);

    /**
     * @Description: 根据token获取userId
     */
    @Select("select user_id ,token from token t where t.token = #{token}")
    Integer selectUserIdByToken(@Param("token") String token);

    /**
     * @Description: 根据userId获取账户所属公司id
     */
    @Select("select company_id as companyId from user where id = #{userId}")
    Integer selectCompanyIdByUserId(@Param("userId") Integer userId);


    /**
     * @Description: 根据用户名和公司判断该账户是否已经存在
     */
    @Select({
            "<script>",
            "select id as userId from user where user_name = #{account.userName} ",
            "and company_id = #{account.companyId} ",
            "and id <![CDATA[<>]]> #{account.userId}",
            "</script>"
    })
    List<Account> findAccountsExceptSelf(@Param("account") Account account);

    /**
     * @Description: 根据用户名和公司判断该账户是否已经存在
     */
    @Select("select id as userId from user where user_name = #{account.userName} and company_id = #{account.companyId}")
    List<Account> findAccounts(@Param("account") Account account);


    /**
     * @Description: insiAP新增账户
     */
    @Insert("INSERT INTO user (user_name,phone,company_id,password,role_id,user_type,user_status,branch_id,created,creater_id) " +
            "VALUES " +
            "(#{account.userName},#{account.phone},#{account.companyId},#{account.password},#{account.roleId}," +
            "#{account.userType},#{account.status},#{account.branchId},now(),#{account.createrId})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID() as userId", keyProperty = "account.userId", before = false, resultType = Integer.class)
    Integer insertAccount(@Param("account") Account account);

    /**
     * @Description: insiAP删除账户
     */
    @Delete("delete from user where id = #{userId}")
    Integer deleteAccount(@Param("userId") Integer userId);

    /**
     * @Description: insiAP修改账户
     */
    @Update({
            "<script>",
            "UPDATE user SET ",
            "<when test='account.userName != null and account.userName != \"\"'>",
            "user_name = #{account.userName},",
            "</when>",
            "<when test='account.phone != null and account.phone != \"\"'>",
            "phone = #{account.phone},",
            "</when>",
            "<when test='account.roleId != null and account.roleId != \"\"'>",
            "role_id = #{account.roleId},",
            "</when>",
            "<when test='account.companyId != null and account.companyId != \"\"'>",
            "company_id = #{account.companyId},",
            "</when>",
            "<when test='account.userType != null and account.userType != \"\"'>",
            "user_type = #{account.userType},",
            "</when>",
            "<when test='account.status != null and account.status != \"\"'>",
            "user_status = #{account.status},",
            "</when>",
            "modified = NOW() WHERE id = #{account.userId}",
            "</script>"
    })
    Integer updateAccount(@Param("account") Account account);

    /**
     * @Description: 根据userId获取账户信息
     */
    @Select("select id as userId,user_name as userName,phone ,company_id as companyId,user_type as userType,user_status as userType,unix_timestamp(created)*1000 as createTime from user where id = #{userId}")
    Account findAccount(@Param("userId") Integer userId);

    /**
     * @Description: 根据userId获取账户信息
     */
    @Select({
            "<script>",
            "select u.id as userId,u.user_name as userName,u.phone ,u.company_id as companyId,u.user_type as userType,u.user_status as userType,unix_timestamp(u.created)*1000 as createTime," +
                    "(select group_concat(r.role_name) from account_role ar,role r where ar.account_id = u.id and ar.role_id = r.id ) as roleNames ",
            "from user u where u.company_id = #{companyId} ",
            "<when test='branchIds != null and branchIds.size()>0'>",
            " and branch_id in ",
            "<foreach  index='index' item='branchId' collection='branchIds' open='(' separator=',' close=')'>",
            "   #{branchId}",
            "</foreach>",
            "</when>",
            "<when test='queryCondition != null and queryCondition != \"\"'>",
            " and u.user_name like CONCAT('%',#{queryCondition},'%') ",
            "</when>",
            "ORDER BY u.created Desc LIMIT #{pageStart}, #{pageSize}",
            "</script>"
    })
    List<Account> findAccountList(@Param("queryCondition") String queryCondition, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize, @Param("companyId") Integer companyId, @Param("branchIds") List<Integer> branchIds);

    /**
     * @Description: 查询账户总数量
     */
    @Select({
            "<script>",
            "select count(1) from user where company_id = #{companyId} ",
            "<when test='branchIds != null and branchIds.size()>0'>",
            " and branch_id in ",
            "<foreach  index='index' item='branchId' collection='branchIds' open='(' separator=',' close=')'>",
            "   #{branchId}",
            "</foreach>",
            "</when>",
            "<when test='queryCondition != null and queryCondition != \"\"'>",
            " and user_name like CONCAT('%',#{queryCondition},'%') ",
            "</when>",
            "ORDER BY created",
            "</script>"
    })
    int findAccountListCount(@Param("queryCondition") String queryCondition, @Param("companyId") Integer companyId, @Param("branchIds") List<Integer> branchIds);

    /**
     * @Description: 根据用户id删除所有该用户的token
     */
    @Delete("delete from token where user_id = #{userId}")
    Integer delTokenByUserId(@Param("userId") Integer userId);

    /**
     * @Description: 根据用户修改token状态 0:未删除   1:修改密码删除   2:其他用户登录删除
     */
    @Update({
            "<script>",
            "update token set delete_flag = #{tokenStatus} where user_id = #{userId} ",
            "<when test='tokenStatus != null and tokenStatus != \"\" and tokenStatus == 2'>",
            "and app_id = 'ybt' ",
            "</when>",
            "</script>"
    })
    Integer updateTokenByUserId(@Param("userId") Integer userId, @Param("tokenStatus") int tokenStatus);

    /**
     * @Description: 根据userId获取账户信息
     */
    @Select("select token from token where user_id = #{userId}")
    List<String> selectTokenByUserId(@Param("userId") Integer userId);


    @Select("SELECT COUNT(1)" +
            "  FROM sys_agent_company_module " +
            " WHERE company_id = #{companyId}" +
            "   AND agent_id = #{agentId}" +
            "   AND `status` = 2 ")
    int countNewModulesByCompanyIdAndAgentId(@Param("companyId") Integer companyId, @Param("agentId") Integer agentId);


    @Select("SELECT module_id " +
            "  FROM sys_agent_company_module" +
            " WHERE company_id = #{companyId} " +
            "   AND agent_id is NULL " +
            "   AND `status` = 2")
    List<Integer> getNewModuleIds(@Param("companyId") Integer companyId);

    @Select("SELECT module_id " +
            "  FROM sys_agent_company_module" +
            " WHERE company_id = #{companyId}" +
            "   AND agent_id = #{agentId}" +
            "   AND `status` = 2")
    List<Integer> getNewModuleIdsByAgentId(@Param("companyId") Integer companyId, @Param("agentId") Integer agentId);


    /**
     * 管理台修改密码
     *
     * @param userId
     * @param newPassword
     * @return
     */
    @Update("UPDATE user SET password = #{newPassword} WHERE id = #{userId}")
    boolean insiApChangePassword(@Param("userId") Integer userId, @Param("newPassword") String newPassword);

    /**
     * 根据组织机构id获取账户
     *
     * @param branchId
     * @return
     */
    @Select("SELECT id FROM user WHERE branch_id = #{branchId}")
    List<Integer> getAccountByBranchId(@Param("branchId") Integer branchId);


    /**
     * 根据token获取token体
     *
     * @param token
     * @return
     */
    @Select("SELECT user_id as userId,token,app_id as appId,device_id as deviceId,device_name as deviceName,delete_flag as deleteFlag,created FROM token WHERE token = #{token}")
    TokenIdentity getTokenIdentityByToken(@Param("token") String token);

    /**
     * 获取当前代理人最新的token
     *
     * @param userId
     * @param appId
     * @return
     */
    @Select("SELECT user_id as userId,token,app_id as appId,device_id as deviceId,device_name as deviceName,delete_flag as deleteFlag,date_format(created,'%Y-%m-%d %H:%i:%s' ) as created " +
            "FROM token " +
            "WHERE user_id = #{userId} " +
            "AND app_id = #{appId} " +
            "ORDER BY created DESC LIMIT 1 ")
    TokenIdentity getLastTokenIdentity(@Param("userId") Integer userId, @Param("appId") String appId);
}
