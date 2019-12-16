package com.cctv.itoken.service.admin.service;

import com.cctv.itoken.service.admin.domain.TbSysUser;

/**
 * @author zb
 * @create 2019-12-16 11:38
 */
public interface AdminService {
    /**
     * 注册
     * @param TbSysUser
     */
    public void register(TbSysUser TbSysUser);

    /**
     * 登录
     * @param loginCode  登录账户
     * @param plantPwd  明文密码
     * @return
     */
    public TbSysUser login(String loginCode,String plantPwd);


}
