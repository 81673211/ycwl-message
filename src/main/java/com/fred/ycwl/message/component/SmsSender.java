package com.fred.ycwl.message.component;

import java.util.List;

/**
 *
 * <b>Description:.</b><br> 
 * @author <b>sil.zhou</b>
 * <br><b>ClassName:</b> 
 * <br><b>Date:</b> 2019/4/22 15:45
 */
public interface SmsSender {

    void send(String phone, String content, String templateId, List<String> templateParams);
}
