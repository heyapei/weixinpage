package com.hyp.weixinpage.controller.page;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author 何亚培
 * @Version V1.0
 * @Date 2020/5/27 18:30
 * @Description: TODO
 */
@Controller("/")
@Slf4j
public class PageController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index/index";
    }

}
