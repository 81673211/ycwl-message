package com.fred.ycwl.message.web;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fred.ycwl.common.exception.BusinessException;
import com.fred.ycwl.common.web.Response;
import com.fred.ycwl.common.web.ResponseCode;
import com.fred.ycwl.message.common.MessageResponseCode;
import com.fred.ycwl.message.component.SmsSender;
import com.fred.ycwl.message.component.SmsTemplateHandler;
import com.fred.ycwl.message.web.request.SmsSendRequest;

/**
 *
 * <b>Description:.</b><br> 
 * @author <b>sil.zhou</b>
 * <br><b>ClassName:</b> 
 * <br><b>Date:</b> 2019/4/22 14:47
 */
@RestController
@RequestMapping("/sms")
public class SmsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SmsController.class);

    @Value("${sms.provider}")
    private String smsProvider;

    @Autowired
    private SmsTemplateHandler smsTemplateIdHandler;

    @Resource
    private SmsSender aliyunSmsSender;

    @PostMapping("/send")
    public Response<Void> send(@Validated SmsSendRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            LOGGER.warn("请求参数错误，原因：{}", bindingResult.getAllErrors().get(0).getDefaultMessage());
            return Response.getFailed(ResponseCode.ERROR_400);
        }
        String smsTemplateId = smsTemplateIdHandler.getTemplateId(request.getType());
        List<String> smsTemplateParamNames = smsTemplateIdHandler.getTemplateParamNames(request.getType());
        getSmsSender().send(request.getPhone(), request.getContent(), smsTemplateId, smsTemplateParamNames);
        return Response.getSuccess(null);
    }

    private SmsSender getSmsSender() {
        if ("aliyun".equals(smsProvider)) {
            return aliyunSmsSender;
        }
        throw new BusinessException(MessageResponseCode.SMS_PROVIDER_NOT_FOUND);
    }
}
