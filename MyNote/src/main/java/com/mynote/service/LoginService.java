package com.mynote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mynote.mapper.LoginMapper;
import com.mynote.model.LoginModel;

@Service
public class LoginService {

    @Autowired
    private LoginMapper loginMapper;

    /**
     * 檢查帳號密碼是否正確
     */
    public LoginModel login(String account, String password) {
        LoginModel user = loginMapper.findByAccount(account);
        if (user == null) {
            return null;
        }
        if (!user.getPassword().equals(password)) {
            return null;
        }
        return user;
    }
}
