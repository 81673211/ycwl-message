package com.fred.ycwl.message.web.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 *
 * <b>Description:.</b><br> 
 * @author <b>sil.zhou</b>
 * <br><b>ClassName:</b> 
 * <br><b>Date:</b> 2019/4/22 15:13
 */
@Data
public class SmsSendRequest implements Serializable {
    private static final long serialVersionUID = -6920323184115717945L;

    @NotBlank(message = "手机号不能为空")
    private String phone;

    @NotBlank(message = "短信内容不能为空")
    private String content;

    @NotBlank(message = "短信类型不能为空")
    private String type;
}
