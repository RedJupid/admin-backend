package com.xd.sso.service;

import com.xd.sso.dao.MenuMapper;
import com.xd.sso.entity.Menu;
import com.xd.sso.entity.MenuExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {

    @Autowired
    MenuMapper menuMapper;

    public int add(Menu menu){
        return this.menuMapper.insertSelective(menu);
    }

    public int delete(Integer id){
        MenuExample example = new MenuExample();
        MenuExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        return menuMapper.deleteByExample(example);
    }

    public int update(Menu menu){
        MenuExample example = new MenuExample();
        MenuExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(menu.getId());
        return this.menuMapper.updateByExampleSelective(menu, example);
    }

    public Menu getById(Integer id){
        MenuExample example = new MenuExample();
        MenuExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<Menu> list = new ArrayList<>();
        list= this.menuMapper.selectByExample(example);
        if(list == null || list.size()==0){
            return null;
        }else{
            return list.get(0);
        }
    }

    public List<Menu> getAll(){
        return this.menuMapper.selectByExample(null);
    }

    public List<Menu> getPermitMenuByUsername(String username){
        return this.menuMapper.selectPermitMenuByUsername(username);
    }
}
