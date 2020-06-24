package org.bobo.clockin.configuration;

import org.bobo.clockin.bean.Configuration;
import org.bobo.clockin.mapper.cinmapper.CinConfigurationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.beans.IntrospectionException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@org.springframework.context.annotation.Configuration
public class AppConfig {
    @Autowired
    private CinConfigurationMapper cinConfigurationMapper;
//    @Resource
//    private RedisTemplate<String, Object> redisTemplate;

    @Bean
    public AppConfiguration cacheAppConfig()
            throws IllegalArgumentException, SecurityException, IntrospectionException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        System.out.println("----------------------appConfig-----------------------");
        AppConfiguration appConfiguration = new AppConfiguration();
       // ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        List<Configuration> configurations = cinConfigurationMapper.selectAll();
        Class clazz=appConfiguration.getClass();
        for (Configuration config : configurations) {
            //vo.set(config.getKey(), config.getValue());
            Field field = clazz.getDeclaredField(config.getKey());
            field.setAccessible(true);
            field.set(appConfiguration, config.getValue());
        }
//        appConfiguration.setAppName((String) vo.get("AppName"));
//        appConfiguration.setStartWorkTime((String) vo.get("StartWorkTime"));
//        appConfiguration.setEndWorkTime((String) vo.get("EndWorkTime"));
//        appConfiguration.setSubsidyRule1((String) vo.get("SubsidyRule1"));
//        appConfiguration.setSubsidyRule1StartTime((String) vo.get("SubsidyRule1StartTime"));
//        appConfiguration.setSubsidyRule1EndTime((String) vo.get("SubsidyRule1EndTime"));
//        appConfiguration.setSubsidyRule2((String) vo.get("SubsidyRule2"));
//       // appConfiguration.setSubsidyRule2StartTime((String) vo.get("SubsidyRule2StartTime"));
//        appConfiguration.setSubsidyRule2EndTime((String) vo.get("SubsidyRule2EndTime"));
//        appConfiguration.setWeekSubsidyRule((String) vo.get("WeekSubsidyRule"));

        System.out.println(appConfiguration);
        System.out.println("----------------------appConfig-----------------------");
        return appConfiguration;
    }
}
