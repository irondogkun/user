package com.pgleon.user.bootconfig;

import com.pgleon.mallspringboot.config.DatasourceSettings;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("datasource.primary")
public class PrimaryDatasourceSettings extends DatasourceSettings {
}