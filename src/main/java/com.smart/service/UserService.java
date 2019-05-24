package com.smart.service;

import com.smart.dao.LoginLogDao;
import com.smart.dao.UserDao;
import com.smart.domain.LoginLog;
import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//通过service注解将该类标注为一个服务层的bean
@Service
public class UserService {
    private UserDao userDao;
    private LoginLogDao loginLogDao;


    @Autowired  //处理userDao的dao层的bean
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired  //处理LoginLogDao的dao层的bean
    public void setLoginLogDao(LoginLogDao loginLogDao) {
        this.loginLogDao = loginLogDao;
    }

    /**
     * 验证用户名和密码是否一致
     *
     * @param userName
     * @param password
     * @return
     */
    @Autowired
    public boolean hashMatchUser(String userName, String password) {
        int machCount = userDao.getMatchCount(userName, password);
        return machCount > 0;
    }

    /**
     * 通过用户名，查找用户
     *
     * @param userName
     * @return
     */
    public User findUserByUserName(String userName) {
        return userDao.findUserByUserName(userName);
    }


    @Transactional //事务注解
    public void loginSuccess(User user) {
        user.setCredits(5 + user.getCredits());
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());
        userDao.updateLoginInfoSql(user);
        loginLogDao.insertLoginLog(loginLog);
    }
}
