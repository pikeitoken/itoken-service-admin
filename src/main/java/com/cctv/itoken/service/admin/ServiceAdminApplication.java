package com.cctv.itoken.service.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author zb
 * @create 2019-12-16 9:52
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.cctv.itoken.service.admin.mapper")
public class ServiceAdminApplication  {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAdminApplication.class,args);
    }

}
