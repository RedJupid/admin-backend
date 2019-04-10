package com.xd.sso.service;

import com.xd.sso.dao.RoleMapper;
import com.xd.sso.dao.UserRoleMapper;
import com.xd.sso.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    UserRoleMapper userRoleMapper;

    public Role getWithMenus(String name){
        return this.roleMapper.selectRoleWithMenus(name);
    }

    public int add(Role role){
        return this.roleMapper.insertSelective(role);
    }

    public int delete(Integer id){
        RoleExample example = new RoleExample();
        RoleExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        return roleMapper.deleteByExample(example);
    }

    public int update(Role role){
        RoleExample example = new RoleExample();
        RoleExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(role.getId());
        return this.roleMapper.updateByExampleSelective(role, example);
    }

    public Role getById(Integer id){
        RoleExample example = new RoleExample();
        RoleExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<Role> list = new ArrayList<>();
        list= this.roleMapper.selectByExample(example);
        if(list == null || list.size()==0){
            return null;
        }else{
            return list.get(0);
        }
    }

    public List<Role> getAll(){
        return this.roleMapper.selectByExample(null);
    }
}
