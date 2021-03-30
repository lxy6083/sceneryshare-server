package com.lxy.sceneryshare.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 定位各种文件或者头像地址
 */
@Configuration
public class FileConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //前端用户头像地址
        registry.addResourceHandler("/avatarImages/**").addResourceLocations(
                "file:" + System.getProperty("user.dir") + System.getProperty("file.separator") + "avatarImages" + System.getProperty("file.separator")
        );

        //景区图片
        registry.addResourceHandler("/scenery/**").addResourceLocations(
                "file:" + System.getProperty("user.dir") +  System.getProperty("file.separator") + "scenery" + System.getProperty("file.separator")
        );

    }
}
