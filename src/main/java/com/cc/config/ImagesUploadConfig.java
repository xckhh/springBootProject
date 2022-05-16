/*
    解决上传图片后不能第一时间在页面显示的问题
 */
package com.cc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ImagesUploadConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/images/**").addResourceLocations("file:D:\\桌面文件夹\\学习\\springBootProject\\src\\main\\resources\\static\\images");
    }
}
//addResourceHandler("/img/**")配置表示释放当前img文件夹下的所有资源（这里我是吧图片放到idea的img目录下）
//addResourceLocations配置你图片在系统中的保存路径：格式是file:路径
//*注意*路径前一定加file：

