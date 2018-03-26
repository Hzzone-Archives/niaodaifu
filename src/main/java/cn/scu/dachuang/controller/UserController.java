package cn.scu.dachuang.controller;

import cn.scu.dachuang.model.User;
import cn.scu.dachuang.service.UserService;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    public User doLogin(@RequestParam("code") String code, @RequestParam("avatarUrl") String avatarUrl,
                        @RequestParam("city") String city, @RequestParam("country") String country, @RequestParam("gender") String language,
                        @RequestParam("nickName") String nickName, @RequestParam("city") String province) throws IOException{
        String url = String.format("https://api.weixin.qq.com/sns/jscode2session?appid=wxbfe8a9c01dbe2b38&secret=ff6fca27a658664b6267f4b829a88764&js_code=%s&grant_type=authorization_code",
                code);

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Response response = client.newCall(request).execute();
        if(response.code()==200) {
            System.out.println(response.body().string());

            return new User();
        } else {
            return new User();
        }

    }
}
