package com.cctv.itoken.service.admin.controller;

import com.cctv.itoken.common.dto.BaseResult;
import com.cctv.itoken.service.admin.domain.TbSysUser;
import com.cctv.itoken.service.admin.service.AdminService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author zb
 * @create 2019-12-16 14:36
 */
@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * 登录
     * @param loginCode
     * @param pwd
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public BaseResult login(String loginCode, String pwd){
        //检查登录信息
        BaseResult baseResult = checkLogin(loginCode, pwd);
        if(baseResult!=null){
            return baseResult;
        }
        TbSysUser tbSysUser = adminService.login(loginCode, pwd);
        if(tbSysUser!=null){
            return BaseResult.ok(tbSysUser);
        }else {
            return BaseResult.notOk(Lists.newArrayList(new BaseResult.Error("","登录失败")));
        }
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(TbSysUser tbSysUser){
        adminService.register(tbSysUser);
        return "success";
    }

    private BaseResult checkLogin(String loginCode,String pwd){

        BaseResult baseResult=null;
        /*List<BaseResult.Error> errors= Lists.newArrayList();

        if(StringUtils.isEmpty(loginCode)){
            BaseResult.Error error=new BaseResult.Error();
            error.setField("loginCode");
            error.setMessage("登录账号不能为空");
            errors.add(error);
        }

        if(StringUtils.isEmpty(pwd)){
            BaseResult.Error error=new BaseResult.Error();
            error.setField("psaaWord");
            error.setMessage("密码不能为空");
            errors.add(error);
        }*/

        if(StringUtils.isEmpty(loginCode)||StringUtils.isEmpty(pwd)){
            baseResult=BaseResult.notOk(Lists.newArrayList(
                    new BaseResult.Error("loginCode","登录账户不能为空"),
                    new BaseResult.Error("pwd","密码不能为空")
            ));
        }
        return baseResult;
    }
}
