package com.sdm.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfigurerAdapter implements WebMvcConfigurer {

	/**
	 * 跨域处理
	 * @return
	 */
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);//是否允许证书，不在默认开启
        config.addAllowedOrigin("*");//所有地址都可访问
        config.addAllowedHeader("*");//跨域请求头
        config.addAllowedMethod("*");//跨域的请求方法
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
