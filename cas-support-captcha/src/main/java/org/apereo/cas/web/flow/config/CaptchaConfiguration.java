/*
 * 版权所有.(c)2008-2017. 卡尔科技工作室
 */

package org.apereo.cas.web.flow.config;

import org.apereo.cas.web.flow.SessionCaptchaResultProvider;
import org.apereo.cas.configuration.CasConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author Carl
 * @date 2017/10/28
 * @since 1.5.0
 */
@Configuration("captchaConfiguration")
@EnableConfigurationProperties(CasConfigurationProperties.class)
public class CaptchaConfiguration {

    @Bean
    public SessionCaptchaResultProvider captchaResultProvider() {
        return new SessionCaptchaResultProvider();
    }
}
