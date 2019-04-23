package com.fred.ycwl.message.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 *
 * <b>Description:.</b><br> 
 * @author <b>sil.zhou</b>
 * <br><b>ClassName:</b> 
 * <br><b>Date:</b> 2019/4/22 16:12
 */
@Component
@ConfigurationProperties("sms.template")
@Data
public class SmsTemplateConfig {

    private Map<String, TemplateEntity> aliyun = new HashMap<>();

    //留作扩展 private Map<String, String> other = new HashMap<>();

    @Data
    public static final class TemplateEntity {

        private String id;

        private List<String> params;
    }
}
