package xyz.safety.service.impl;

import org.springframework.stereotype.Service;
import xyz.safety.service.UserService;
import xyz.safety.vo.Users;

/**
 * Created by lihongjun on 15/9/28.
 */
@Service("userService")
public class UserServiceImpl extends BaseService<Users> implements UserService {
    public void saveUser(Users user) {
         save(user);
    }
}
