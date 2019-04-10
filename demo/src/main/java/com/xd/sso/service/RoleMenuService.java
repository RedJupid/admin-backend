package com.xd.sso.service;

import com.xd.sso.dao.RoleMenuMapper;
import com.xd.sso.entity.RoleMenu;
import com.xd.sso.entity.RoleMenuExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleMenuService {

    @Autowired
    RoleMenuMapper roleMenuMapper;

    public int add(RoleMenu roleMenu){
        return this.roleMenuMapper.insertSelective(roleMenu);
    }

    public int delete(Integer id){
        RoleMenuExample example = new RoleMenuExample();
        RoleMenuExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        return roleMenuMapper.deleteByExample(example);
    }

    public int update(RoleMenu roleMenu){
        RoleMenuExample example = new RoleMenuExample();
        RoleMenuExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(roleMenu.getId());
        return this.roleMenuMapper.updateByExampleSelective(roleMenu, example);
    }

    public RoleMenu getById(Integer id){
        RoleMenuExample example = new RoleMenuExample();
        RoleMenuExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<RoleMenu> list = new ArrayList<>();
        list= this.roleMenuMapper.selectByExample(example);
        if(list == null || list.size()==0){
            return null;
        }else{
            return list.get(0);
        }
    }

    public List<RoleMenu> getAll(){
        return this.roleMenuMapper.selectByExample(null);
    }
}
