package com.cctv.itoken.admin.test.service;

import com.cctv.itoken.service.admin.ServiceAdminApplication;
import com.cctv.itoken.service.admin.domain.TbSysUser;
import com.cctv.itoken.service.admin.service.AdminService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * @author zb
 * @create 2019-12-16 11:24
 */
@Transactional
@Rollback
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceAdminApplication.class)
public class AdminServiceTest {

    @Autowired
    private AdminService adminService;
    @Test
    public void register(){
        TbSysUser tbSysUser=new TbSysUser();
        tbSysUser.setLoginCode("zb");
        tbSysUser.setPassword("..89757");
        tbSysUser.setUserCode(UUID.randomUUID().toString());
        tbSysUser.setUserName("zb");
        tbSysUser.setUserType("ff");
        tbSysUser.setMgrType("1");
        tbSysUser.setStatus("0");
        tbSysUser.setCreateDate(new Date());
        tbSysUser.setCreateBy(tbSysUser.getUserCode());
        tbSysUser.setUpdateDate(new Date());
        tbSysUser.setUpdateBy(tbSysUser.getUserCode());
        tbSysUser.setCorpName("itoken");
        tbSysUser.setCorpCode("1");
        adminService.register(tbSysUser);
    }

    @Test
    public void login(){
        TbSysUser tbSysUser = adminService.login("zb", "..89757");
        Assert.assertNotNull(tbSysUser);
    }
}
