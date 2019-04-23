package com.fred.ycwl.message.component;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fred.ycwl.common.exception.BusinessException;
import com.fred.ycwl.message.common.MessageResponseCode;
import com.fred.ycwl.message.config.SmsTemplateConfig;
import com.fred.ycwl.message.config.SmsTemplateConfig.TemplateEntity;

/**
 *
 * <b>Description:.</b><br> 
 * @author <b>sil.zhou</b>
 * <br><b>ClassName:</b> 
 * <br><b>Date:</b> 2019/4/22 16:53
 */
@Component
public class SmsTemplateHandler {

    @Value("${sms.provider}")
    private String smsProvider;

    @Autowired
    private SmsTemplateConfig smsTemplateConfig;

    public String getTemplateId(String smsType) {
        return getTemplateEntity(smsType).getId();
    }

    public List<String> getTemplateParamNames(String smsType) {
        return getTemplateEntity(smsType).getParams();
    }

    private TemplateEntity getTemplateEntity(String smsType) {
        if ("aliyun".equals(smsProvider)) {
            Map<String, SmsTemplateConfig.TemplateEntity> aliyunTemplate = smsTemplateConfig.getAliyun();
            TemplateEntity templateEntity = aliyunTemplate.get(smsType);
            if (templateEntity == null) {
                throw new BusinessException(MessageResponseCode.SMS_TEMPLATE_NOT_FOUND);
            }
            return templateEntity;
        }
        throw new BusinessException(MessageResponseCode.SMS_PROVIDER_NOT_FOUND);
    }
}
