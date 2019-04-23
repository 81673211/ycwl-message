package com.fred.ycwl.message;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *
 * <b>Description:.</b><br> 
 * @author <b>sil.zhou</b>
 * <br><b>ClassName:</b> 
 * <br><b>Date:</b> 2019/4/22 14:29
 */
@SpringBootApplication
@EnableEurekaClient
public class MessageServiceApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(MessageServiceApplication.class).web(WebApplicationType.SERVLET).run(args);
    }
}
