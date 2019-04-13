package com.pgleon.user.bootconfig;

import com.pgleon.mallspringboot.config.DatasourceSettings;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
@MapperScan(value = {
        "com.ebt.service.user.domain.mapper.primary"}, sqlSessionFactoryRef = "primarySqlSessionFactory")
public class PrimaryDatasourceConfig {

    @Autowired
    private PrimaryDatasourceSettings datasourceSettings;

    @Primary
    @Bean
    public DataSource primaryDataSource() {
        return DatasourceSettings.build(this.datasourceSettings);
    }

    @Bean("primarySqlSessionFactory")
    public SqlSessionFactory primarySqlSessionFactory() throws Exception {
        DataSource dataSource = primaryDataSource();
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setVfs(SpringBootVFS.class);
        return factory.getObject();
    }

    @Bean("primarySqlSessionTemplate")
    public SqlSessionTemplate primarySqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(primarySqlSessionFactory());
    }
}
