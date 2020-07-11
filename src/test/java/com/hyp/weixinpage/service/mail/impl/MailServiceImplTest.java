package com.hyp.weixinpage.service.mail.impl;

import com.hyp.weixinpage.pojo.vo.MailVO;
import com.hyp.weixinpage.service.mail.MailService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.mail.internet.AddressException;
import java.io.UnsupportedEncodingException;


/**
 * @Author 何亚培
 * @Version V1.0
 * @Date 2020/5/27 19:25
 * @Description: TODO
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MailServiceImplTest {

    @Autowired
    private MailService mailService;



    @Test
   public void sendMail() throws AddressException, UnsupportedEncodingException {
        //mailService.sendMail("heyapei@hotmail.com","简单邮件","springboot实现邮件发送");
        log.info("发送邮件测试");
        MailVO mailVO = new MailVO();
        mailVO.setEmail("heyapei@hotmail.com");
        mailVO.setContent("内容属性<h1>nihaoya</h1>");
        mailVO.setTitle("标题属性");
        mailService.sendTextMail(mailVO);
    }
}