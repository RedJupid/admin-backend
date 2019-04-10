package com.xd.sso.service;

import com.xd.sso.dao.UserMapper;
import com.xd.sso.entity.User;
import com.xd.sso.entity.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public int add(User user){
        return this.userMapper.insertSelective(user);
    }

    public int delete(Integer id){
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        return userMapper.deleteByExample(example);
    }

    public int update(User user){
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(user.getId());
        return this.userMapper.updateByExampleSelective(user, example);
    }

    public User getById(Integer id){
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<User> list = new ArrayList<>();
        list= this.userMapper.selectByExample(example);
        if(list == null || list.size()==0){
            return null;
        }else{
            return list.get(0);
        }
    }

    public List<User> getAll(){
        return this.userMapper.selectByExample(null);
    }

    public User getByName(String name){
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(name);
        List<User> list = new ArrayList<>();
        list= this.userMapper.selectByExample(example);
        if(list == null || list.size()==0){
            return null;
        }else{
            return list.get(0);
        }
    }

    public User getWithRoles(String username){

        User user = this.userMapper.selectUserWithRoles(username);
        return user;
    }

}
