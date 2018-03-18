package cn.scu.dachuang.controller;

import cn.scu.dachuang.exception.LoginException;
import cn.scu.dachuang.exception.RegisterException;
import cn.scu.dachuang.model.User;
import cn.scu.dachuang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LoginAndRegisterController {


    @Autowired
    private UserService userService;

    /**
     * 返回登陆界面
     * @return
     */
    @GetMapping("/login")
    public String LoginGet(){
        return "login";
    }


    /**
     * 登陆
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public String LoginPost(@RequestParam("user_id") String user_id, @RequestParam("password") String password, HttpServletResponse response) throws IOException{
        if(user_id.length()==0 || password.length()==0)
            return "invalid email or password";
        try {
            User user = userService.findUserByID(user_id);
            if(!password.equals(user.getUserPassword()))
                return "password incorrect";
        } catch (LoginException e){
            return e.getMessage();
        }
        response.sendRedirect("/");
        return "";
//        return String.format("%s %s", user_id, password);
    }

    @RequestMapping("/foo")
    @ResponseBody
    public String handleFoo(HttpServletResponse response) throws IOException {
        response.sendRedirect("/");
        return "";
    }


    @GetMapping("/register")
    public String RegisterGet(){
        return "register";
    }


    @PostMapping("/register")
    @ResponseBody
    public String RegisterPost(@RequestParam("user_id") String user_id, @RequestParam("password") String password, @RequestParam("user_name") String user_name,  HttpServletResponse response) throws IOException{
        try {
            User user = new User();
            user.setUserName(user_name);
            user.setUserPassword(password);
            user.setUserId(user_id);
            userService.registerUser(user);
        }catch (RegisterException e){
            return e.getMessage();
        }
        response.sendRedirect("/");
        return "";
    }
}
