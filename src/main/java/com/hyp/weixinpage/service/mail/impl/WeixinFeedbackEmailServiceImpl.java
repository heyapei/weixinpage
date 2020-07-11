package com.hyp.weixinpage.service.mail.impl;

import com.hyp.weixinpage.exception.MyDefinitionException;
import com.hyp.weixinpage.mapper.WeixinFeedbackEmailMapper;
import com.hyp.weixinpage.pojo.modal.WeixinFeedbackEmail;
import com.hyp.weixinpage.service.mail.WeixinFeedbackEmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author 何亚培
 * @Version V1.0
 * @Date 2020/7/12 0:24
 * @Description: TODO
 */
@Service
@Slf4j
public class WeixinFeedbackEmailServiceImpl implements WeixinFeedbackEmailService {
    @Autowired
    private WeixinFeedbackEmailMapper weixinFeedbackEmailMapper;

    /**
     * 保存邮件信息
     *
     * @param weixinFeedbackEmail
     * @return 主键
     * @throws MyDefinitionException
     */
    @Override
    public Integer saveWeixinFeedbackEmailReturnPK(WeixinFeedbackEmail weixinFeedbackEmail) throws MyDefinitionException {
        if (weixinFeedbackEmail == null) {
            throw new MyDefinitionException("用户的反馈数据为空，无法同步到邮件系统");
        }
        Integer key = null;
        try {
            int i = weixinFeedbackEmailMapper.insertUseGeneratedKeys(weixinFeedbackEmail);
            if (i > 0) {
                key = weixinFeedbackEmail.getId();
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("保存用户反馈信息到邮件系统操作过程错误，错误原因：{}", e.toString());
            throw new MyDefinitionException("保存用户反馈信息到邮件系统操作过程错误");
        }
        return key;
    }
}
