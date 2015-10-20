package xyz.safety.service;

import xyz.safety.vo.Users;

/**
 * Created by lihongjun on 15/9/28.
 */
public interface UserService {
    void saveUser(Users user);

    Users findUserByMail(String email);

    void updateUserMailStatus(String email);

    void updateUserMailStatus(Users dbUser);
}
