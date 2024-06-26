package cn.itcast.user.web;

import cn.itcast.user.config.MfProperties;
import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private MfProperties mfProperties;

    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id,@RequestHeader(value = "mf",required = false) String mf) {
        System.out.println(mf);
        return userService.queryById(id);
    }

    @GetMapping("/yq")
    public MfProperties getMf(){
        return mfProperties;
    }
}
