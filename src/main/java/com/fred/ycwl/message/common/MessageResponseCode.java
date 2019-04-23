package com.fred.ycwl.message.common;

import com.fred.ycwl.common.web.ResponseCode;

/**
 *
 * <b>Description:.</b><br> 
 * @author <b>sil.zhou</b>
 * <br><b>ClassName:</b> 
 * <br><b>Date:</b> 2019/4/23 11:20
 */
public class MessageResponseCode extends ResponseCode {

    public static final ResponseCode SMS_TEMPLATE_NOT_FOUND = new ResponseCode("02001", "未找到短信模板");
    public static final ResponseCode SMS_PROVIDER_NOT_FOUND = new ResponseCode("02002", "短信服务提供商未找到");
    public static final ResponseCode SMS_SEND_ERROR = new ResponseCode("02003", "短信发送失败，请联系IT");
    public static final ResponseCode SMS_CONTENT_PARAM_NOT_MATCH =
            new ResponseCode("02004", "短信内容和参数名不匹配，请联系IT");

    private static final long serialVersionUID = -6828085003880448340L;

    public MessageResponseCode(String code, String desc) {
        super(code, desc);
    }
}
