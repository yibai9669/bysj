package edu.lntu.liuu.service.impl;

import edu.lntu.liuu.dao.AdminMapper;
import edu.lntu.liuu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public boolean veritypasswd(String name, String password) {

        return adminMapper.verifyPassword(name, password)>0?true:false;
    }
}
