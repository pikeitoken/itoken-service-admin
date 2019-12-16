package com.cctv.itoken.service.admin.service.impl;


import com.cctv.itoken.service.admin.domain.TbSysUser;
import com.cctv.itoken.service.admin.mapper.TbSysUserMapper;
import com.cctv.itoken.service.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.entity.Example;

/**
 * @author zb
 * @create 2019-12-16 11:42
 */
@Service
@Transactional(readOnly = true)
public class AdminServiceImpl implements AdminService {
    @Autowired
    private TbSysUserMapper tbSysUserMapper;

    @Override
    @Transactional(readOnly = false)
    public void register(TbSysUser tbSysUser) {
        tbSysUser.setPassword(DigestUtils.md5DigestAsHex(tbSysUser.getPassword().getBytes()));
        tbSysUserMapper.insert(tbSysUser);
    }

    @Override
    public TbSysUser login(String loginCode, String plantPwd) {
        Example example=new Example(TbSysUser.class);
        example.createCriteria().andEqualTo("loginCode",loginCode);
        TbSysUser tbSysUser=tbSysUserMapper.selectOneByExample(example);
        String pwd=DigestUtils.md5DigestAsHex(plantPwd.getBytes());
        if(plantPwd.equals(pwd)){
            return tbSysUser;
        }
        return null;
    }
}
