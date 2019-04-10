package com.xd.sso.service;

import com.xd.sso.dao.UserRoleMapper;
import com.xd.sso.entity.UserRole;
import com.xd.sso.entity.UserRoleExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRoleService {

    @Autowired
    UserRoleMapper userRoleMapper;

    public int add(UserRole userRole){
        return this.userRoleMapper.insertSelective(userRole);
    }

    public int delete(Integer id){
        UserRoleExample example = new UserRoleExample();
        UserRoleExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        return userRoleMapper.deleteByExample(example);
    }

    public int update(UserRole userRole){
        UserRoleExample example = new UserRoleExample();
        UserRoleExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(userRole.getId());
        return this.userRoleMapper.updateByExampleSelective(userRole, example);
    }

    public UserRole getById(Integer id){
        UserRoleExample example = new UserRoleExample();
        UserRoleExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<UserRole> list = new ArrayList<>();
        list= this.userRoleMapper.selectByExample(example);
        if(list == null || list.size()==0){
            return null;
        }else{
            return list.get(0);
        }
    }

    public List<UserRole> getAll(){
        return this.userRoleMapper.selectByExample(null);
    }
}
