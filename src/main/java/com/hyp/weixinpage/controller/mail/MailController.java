package com.hyp.weixinpage.controller.mail;

import com.hyp.weixinpage.pojo.modal.WeixinFeedbackEmail;
import com.hyp.weixinpage.pojo.vo.MailVO;
import com.hyp.weixinpage.pojo.vo.resultone.MyError;
import com.hyp.weixinpage.pojo.vo.resultone.Result;
import com.hyp.weixinpage.service.mail.MailService;
import com.hyp.weixinpage.service.mail.WeixinFeedbackEmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 何亚培
 * @Version V1.0
 * @Date 2020/5/27 22:38
 * @Description: TODO
 */

@Controller
@RequestMapping("mail")
@Slf4j
public class MailController {
    @Autowired
    private MailService mailService;

    @RequestMapping("/sendTextMail")
    @ResponseBody
    public Result sendTextMail(MailVO mailDO) {
        try {
            mailService.sendTextMail(mailDO);
        } catch (Exception e) {
            log.info("发送文本邮件失败：{}，错误信息:{}", mailDO.toString(), e.toString());
            return Result.buildResult(Result.Status.UNAUTHORIZED);
        }
        log.info("发送文本邮件成功：{}", mailDO.toString());
        return Result.buildResult(Result.Status.OK);
    }

    @RequestMapping("/sendHtmlMail")
    @ResponseBody
    public Result sendHtmlMail(MailVO mailDO) {
        Map<String, Object> map = new HashMap<>(16);
        try {
            map.put("附件名", "附件的绝对路径");
            mailDO.setAttachment(map);
            mailService.sendHtmlMail(mailDO, false);
        } catch (Exception e) {
            log.info("发送富文本邮件失败：{}，附件参数：{}，错误信息：{}", mailDO.toString(), map, e.toString());
            return Result.buildResult(Result.Status.UNAUTHORIZED);
        }
        log.info("发送富文本邮件成功：{}，附件参数：{}", mailDO.toString(), map);
        return Result.buildResult(Result.Status.OK);
    }

    /*@RequestMapping("/sendTemplateMail")
    @ResponseBody
    public Result sendTemplateMail(MailVO mailDO) {

        *//*MailVO mailDO = new MailVO();
        mailDO.setEmail(email);
        mailDO.setTitle(subject);*//*
        Map<String, Object> map = new HashMap<>(16);
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            map.put("time", format.format(new Date()));
            mailDO.setAttachment(map);
            mailService.sendTemplateMail(mailDO);
        } catch (Exception e) {
            log.info(e.toString());
            //log.info("发送网页模板邮件失败：{}，用户名：{}，用户发送的信息：{}，网页模板参数：{}，错误信息：{}", name, message, mailDO.toString(), map, e.toString());
            return Result.buildResult(Result.Status.UNAUTHORIZED);
        }
        //log.info("发送网页模板邮件成功：{}，用户名：{}，用户发送的信息：{}，网页模板参数：{}", name, message, mailDO.toString(), map);
        return Result.buildResult(Result.Status.OK);
    }*/

    @Autowired
    private WeixinFeedbackEmailService weixinFeedbackEmailService;

    @RequestMapping("/sendTemplateMail")
    public String sendTemplateMail(
            @RequestParam(required = true) String name,
            @RequestParam(required = true) String email,
            @RequestParam(required = true) String subject,
            @RequestParam(required = true) String message, ModelMap map) {
        MailVO mailDO = new MailVO();
        mailDO.setEmail(email);
        mailDO.setTitle("趣互动反馈通知");
        mailDO.setContent(message);
        Map<String, Object> map1 = new HashMap<>(16);
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            map1.put("time", format.format(new Date()));
            map1.put("userName", name);
            mailDO.setAttachment(map1);
            mailService.sendTemplateMail(mailDO);
        } catch (Exception e) {
            log.info("发送网页模板邮件失败：{}，用户名：{}，用户发送的信息：{}，网页模板参数：{}，错误信息：{}", name, message, mailDO.toString(), map, e.toString());
            //return Result.buildResult(Result.Status.UNAUTHORIZED);
            MyError myError = new MyError(500, "发送失败了", "请检查您的邮箱地址是否正确，我们需要它用于及时回复您");
            map.put("myError", myError);
            return "error/error";
        }
        log.info("发送网页模板邮件成功：{}，用户名：{}，用户主题：{}，用户发送的信息：{}，网页模板参数：{}", name, subject, message, mailDO.toString(), map);

        WeixinFeedbackEmail weixinFeedbackEmail = WeixinFeedbackEmail.init();
        weixinFeedbackEmail.setSendToName(name);
        weixinFeedbackEmail.setSendTo(email);
        weixinFeedbackEmail.setEmailTitle(subject);
        weixinFeedbackEmail.setEmailContent(message);
        weixinFeedbackEmailService.saveWeixinFeedbackEmailReturnPK(weixinFeedbackEmail);
        map.put("message", true);
        return "index/index";
    }


}
