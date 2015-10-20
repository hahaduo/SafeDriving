package xyz.safety.service.impl;

import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;
import xyz.safety.service.UserService;
import xyz.safety.util.PasswordHash;
import xyz.safety.vo.Country;
import xyz.safety.vo.Users;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

/**
 * Created by lihongjun on 15/9/28.
 */
@Service("userService")
public class UserServiceImpl extends BaseService<Users> implements UserService {
    public void saveUser(Users user) {
        String pwd = user.getPassword();
        try {
            String pwdHash = PasswordHash.createHash(pwd);
            user.setPassword(pwdHash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        save(user);
    }

    public Users findUserByMail(String email) {

        Users ret;
        Example example = new Example(Users.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtil.isEmpty(email)) {
            criteria.andEqualTo("email", email);
            List<Users> users = selectByExample(example);
            if (users != null && users.size() > 0) {
                ret = users.get(0);
            } else {
                ret = null;
            }
        } else {
            ret = null;
        }


        return ret;
    }

    public void updateUserMailStatus(String email) {

    }

    public void updateUserMailStatus(Users dbUser) {
        updateAll(dbUser);
    }


}
