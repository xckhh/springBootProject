package com.cc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@MapperScan("com.cc.dao")
@Configuration
@SpringBootApplication
@EnableSwagger2  // 开启swagger2
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("       \\:.             .:/\n" +
                "        \\``._________.''/ \n" +
                "         \\             / \n" +
                " .--.--, / .':.   .':. \\\n" +
                "/__:  /  | '::' . '::' |\n" +
                "   / /   |`.   ._.   .'|\n" +
                "  / /    |.'         '.|\n" +
                " /___-_-,|.\\  \\   /  /.|\n" +
                "      // |''\\.;   ;,/ '|\n" +
                "      `==|:=         =:|\n" +
                "         `.          .'\n" +
                "           :-._____.-:\n" +
                "          `''       `''");
    }

}
