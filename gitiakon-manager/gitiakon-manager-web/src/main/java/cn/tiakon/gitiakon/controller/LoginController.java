package cn.tiakon.gitiakon.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Administrator
 */

//@RestController
@Controller
public class LoginController {
    private static Logger logger = LoggerFactory.getLogger("LoginController");

    @RequestMapping(value = "/")
    public String index() {
        logger.info(">> 跳转 index 页面...");
        return "index";
    }

    @RequestMapping(value = "/login")
    public String login() {
        logger.info(">> 跳转 login 页面...");
        return "login";
    }

    @RequestMapping(value = "/register")
    public String register() {
        logger.info(">> 跳转 register 页面...");
        return "register";
    }

    //    @RequestMapping(value = "/users", method = RequestMethod.POST)
    // @RequestParam(name = "username", required = false, defaultValue = "World"
    @PostMapping(value = "/login.action")
    @ResponseBody
    public ModelAndView login(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password) {
        boolean bool = "tiakon".equals(username) && "123".equals(password);
        logger.info(">> {}", bool);
        ModelAndView modelAndView = new ModelAndView();
        if (bool) {
            modelAndView.setViewName("main");
        } else {
            modelAndView.addObject("username", username);
            modelAndView.addObject("password", password);
            modelAndView.addObject("error", "用户名或密码错误！");
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    @PostMapping(value = "/register.action")
    @ResponseBody
    public String register(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password) {
        boolean bool = "Tiakon".equals(username) && "123".equals(password);
        logger.info(">> {}", bool);
        return "{\"status\":200,\"message\":\"success\",\"data\":\"\"}";
    }


}