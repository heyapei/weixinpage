package com.hyp.weixinpage.service.mail;

import com.hyp.weixinpage.pojo.vo.MailVO;

/**
 * @Author 何亚培
 * @Version V1.0
 * @Date 2020/5/27 19:06
 * @Description: TODO
 */
public interface MailService {
    /**
     * 纯文本邮件
     * @param mailVO
     */
    void sendTextMail(MailVO mailVO);

    /**
     * 发送的邮件是富文本（附件，图片，html等）
     * @param mailVO
     * @param isShowHtml 是否解析html
     */
    void sendHtmlMail(MailVO mailVO, boolean isShowHtml);

    /**
     * 发送模板邮件 使用thymeleaf模板
     * 若果使用freemarker模板
     *     Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
     *     configuration.setClassForTemplateLoading(this.getClass(), "/templates");
     *     String emailContent = FreeMarkerTemplateUtils.processTemplateIntoString(configuration.getTemplate("mail.ftl"), params);
     * @param mailVO
     */
    void sendTemplateMail(MailVO mailVO);
}
