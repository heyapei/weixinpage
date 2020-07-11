package com.hyp.weixinpage.service.mail;

import com.hyp.weixinpage.exception.MyDefinitionException;
import com.hyp.weixinpage.pojo.modal.WeixinFeedbackEmail;

/**
 * @Author 何亚培
 * @Version V1.0
 * @Date 2020/7/12 0:23
 * @Description: TODO
 */
public interface WeixinFeedbackEmailService {


    /**
     * 保存邮件信息
     * @param weixinFeedbackEmail
     * @return 主键
     * @throws MyDefinitionException
     */
    Integer saveWeixinFeedbackEmailReturnPK(WeixinFeedbackEmail weixinFeedbackEmail) throws MyDefinitionException;

}
