package com.sdm.auth.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * ModelMapper配置
 */
@Configuration
public class ModelMapperConfig {

	/**
	 * 入住对象
	 * 关闭ModelMapper模糊匹配
	 * @return
	 */
    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper =  new ModelMapper();
        modelMapper.getConfiguration().setFullTypeMatchingRequired(true);
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);//默认为standard模式，设置为strict模式
        return modelMapper;
    }
}
