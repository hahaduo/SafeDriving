package xyz.safety.controller;

import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import xyz.safety.mail.EmailMessage;
import xyz.safety.mail.template.TemplateFactory;
import xyz.safety.mail.transport.EmailTransportConfiguration;
import xyz.safety.service.UserService;
import xyz.safety.util.PasswordHash;
import xyz.safety.vo.Users;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

/**
 * 处理用户登录的controller
 *
 * Created by lihongjun on 15/9/28.
 */

@Controller
@RequestMapping(value = "login")
public class LoginController {

    private String PAGE_LOGIN_OK = "login/loginOk";
    private String PAGE_LOGIN_SIGNON = "login/login";
    private String PAGE_LOGIN_SIGNUP = "login/signUp";
    private String LOGIN_FAILED_INVALIDPASSWORD = "密码不正确";
    private String LOGIN_FAILED_MAILNOTEXIST = "邮件地址不存在";
    private String PAGE_LOGIN_MAILBOX_CONFIRM_OK = "login/MailBoxConfirmOk";
    private String PUBLIC_KEY_EMAIL = "SafeDriving";

    @Autowired
    private UserService userService;


    /**
     * 进入用户注册画面
     * @return
     */
    @RequestMapping(value = "signup", method = RequestMethod.GET)
    public ModelAndView signUp() {
        ModelAndView result = new ModelAndView(PAGE_LOGIN_SIGNUP);
        return result;
    }

    /**
     * 进入用户登录画面
     * @return
     */
    @RequestMapping(value = "signon", method = RequestMethod.GET)
    public ModelAndView signOn() {
        ModelAndView result = new ModelAndView(PAGE_LOGIN_SIGNON);
        return result;
    }

    /**
     * 来自用户登录画面，根据用户输入的登录信息判断是否合法用户
     * @param user
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request,Users user) {
        ModelAndView result = new ModelAndView(PAGE_LOGIN_OK);
        //根据用户的email取得用户的存储密码
        Users dbUser = userService.findUserByMail(user.getEmail());
        if (dbUser == null) {
            //没有找到用户，邮件地址无效
            result = new ModelAndView(PAGE_LOGIN_SIGNON);
            result.addObject("msg", LOGIN_FAILED_MAILNOTEXIST);
            result.addObject("email", user.getEmail());

        } else {
            //密码正确与否的标识
            boolean pwdValidFlag = false;
            try {
                pwdValidFlag = PasswordHash.validatePassword(user.getPassword(), dbUser.getPassword());

            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (InvalidKeySpecException e) {
                e.printStackTrace();
            }

            if (pwdValidFlag) {
                //密码正确，返回登录成功画面
                result.addObject("user", user);

                //将用户信息置入session，方便以后filter进行权限判断
                request.getSession().setAttribute("user",user);

            } else {
                //密码不正确，返回登录页面，设置提示消息
                result = new ModelAndView(PAGE_LOGIN_SIGNON);
                result.addObject("msg", LOGIN_FAILED_INVALIDPASSWORD);
                result.addObject("email", user.getEmail());
            }
        }
        return result;
    }

    /**
     * 保存注册画面填写的新用户数据
     * @param user
     * @return
     */
    @RequestMapping(value = "saveUser", method = RequestMethod.POST)
    public ModelAndView save(Users user) {
        ModelAndView result = new ModelAndView(PAGE_LOGIN_OK);
        userService.saveUser(user);
        result.addObject("user", user);

        EmailTransportConfiguration.configure("smtp.mxhichina.com", true,
                false, "noreply@safed.xyz", "Passw0rd@123456");

        Map<String, String> map = new HashMap<>();
        try {
//            String encMail = DesUtil.encrypt(user.getEmail(), PUBLIC_KEY_EMAIL);
            String encMail = user.getEmail();
            map.put("email", encMail);
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            String maiBody = TemplateFactory.generateHtmlFromFtl("template_1.ftl", map);
            new EmailMessage().from("noreply@safed.xyz").to(user.getEmail())
                    .withSubject("Fluent Mail API")
//				.withAttachment("file_name")
                    .withMailType(2)
                    .withBody(maiBody).send();

            System.out.println("Check your inbox!");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 直接进入用户登录成功画面，测试用
     * @return
     */
    @RequestMapping(value = "loginok", method = RequestMethod.GET)
    public ModelAndView loginOk() {
        ModelAndView result = new ModelAndView(PAGE_LOGIN_OK);
        Users user = new Users();
        user.setEmail("bigbower@163.com");
        result.addObject("user", user);
        return result;
    }

    /**
     * 邮件确认
     *
     * @param m 电子邮件，传入前通过url加密
     * @return
     */
    @RequestMapping(value = "email_cert",method = RequestMethod.GET)
    public ModelAndView mailConfirm(@RequestParam("m") String m) {
        ModelAndView result = new ModelAndView(PAGE_LOGIN_MAILBOX_CONFIRM_OK);
        try {

//            String email = DesUtil.decrypt(m, PUBLIC_KEY_EMAIL);
            String email = m;
            Users dbUser = userService.findUserByMail(email);
            dbUser.setMailConfirmYn("Y");
            userService.updateUserMailStatus(dbUser);
            System.out.println(dbUser.getNickName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
