package cn.hzzone.dachuang.controller;

import cn.hzzone.dachuang.model.User;
import cn.hzzone.dachuang.service.UserService;
import cn.hzzone.dachuang.util.Message;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private OkHttpClient client = new OkHttpClient();

    @PostMapping("/doLogin")
    public Message<User> doLogin(@RequestParam("code") String code, @RequestParam("avatarUrl") String avatarUrl,
                        @RequestParam("city") String city, @RequestParam("country") String country, @RequestParam("gender") boolean gender,
                        @RequestParam("nickName") String nickName, @RequestParam("province") String province,
                        @RequestParam("language") String user_language) throws IOException {
        System.out.println(code);
        String url = String.format("https://api.weixin.qq.com/sns/jscode2session?appid=wxbfe8a9c01dbe2b38&secret=ff6fca27a658664b6267f4b829a88764&js_code=%s&grant_type=authorization_code",
                code);

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response);
        if(response.code()==200) {
//            System.out.println(response.body().string());
            String return_data = response.body().string();
            JsonParser parser = new JsonParser();
            JsonObject object = (JsonObject) parser.parse(return_data);
            String session_key = object.get("session_key").getAsString();
            String openid = object.get("openid").getAsString();
            User user = userService.findUserByID(openid);
            System.out.println(user);
            if(user==null) {
                User user1 = new User();
                user1.setCity(city);
                user1.setCountry(country);
                user1.setOpenId(openid);
                user1.setProvince(province);
                user1.setSessionKey(session_key);
                user1.setSex(gender);
                user1.setUserImg(avatarUrl);
                user1.setUserName(nickName);
                user1.setUserLanguage(user_language);

                userService.registerUser(user1);
                Message<User> message = new Message<>(user1, 2, "注册成功");
                return message;

            } else {
                Message<User> message = new Message<>(user, 1, "登陆成功");
                return message;
            }
        } else {
            return new Message<User>(new User(), 0, "微信服务器连接失败");
        }

    }

}
