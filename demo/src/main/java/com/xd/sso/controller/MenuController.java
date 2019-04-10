package com.xd.sso.controller;

import com.xd.sso.entity.Menu;
import com.xd.sso.entity.Msg;
import com.xd.sso.entity.Menu;
import com.xd.sso.entity.User;
import com.xd.sso.service.MenuService;
import com.xd.sso.service.UserService;
import com.xd.sso.util.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/menu")
@Api(description = "菜单控制器")
public class MenuController {

    @Autowired
    MenuService menuService;

    private static final String signingKey = "signingKey";

    //初始化菜单格式
    public List<Menu> initMenu(List<Menu> rawMenu, List<Menu> menu){
        //先找到所有的一级菜单
        for (Menu m : rawMenu){
            if (m.getParentId()==0){
                menu.add(m);
            }
        }
        //给一级菜单添加子菜单
        for (Menu m : menu){
            m.setChildren(getChild(m.getId(), rawMenu));
        }
        return menu;
    }

//    //初始化菜单格式2
//    public List<Menu> initMenu2(List<Menu> rawMenu, List<Menu> menu){
//        List<Menu> first = new ArrayList<>();
//        List<Menu> children = new ArrayList<>();
//        int i=0;
//        for (Menu m : rawMenu){
//            if(m.getParentId()==0){
//                i++;
//                m.setIds(i);
//                first.add(m);
//                menu.add(m);
//            }
//        }
//        for (Menu f : first){
//            i=0;
//            children = getChildren(f.getId(), rawMenu);
//            for (Menu child : children){
//                i++;
//                child.setIds(f.getIds()*10+i);
//                menu.add(child);
//            }
//        }
//        return menu;
//    }

    public List<Menu> getChildren(int id, List<Menu> rawMenu){
        List<Menu> result = new ArrayList<>();
        for(Menu m : rawMenu){
            if (m.getParentId()==id){
                result.add(m);
            }
        }
        return result;
    }

    @GetMapping("/token")
    @ApiOperation(value = "根据token获取菜单")
    public List<Menu> getMenuByToken(HttpServletRequest request){
        String tokenName = "token";
        String token = request.getHeader(tokenName);
        System.out.println(token);
        String username = JwtUtil.myParseToken(request,tokenName, signingKey);
//        List<Menu> rawMenu = new ArrayList<>();
//        List<Menu> menu = new ArrayList<>();
//        menu = initMenu2(rawMenu,menu);
        return this.menuService.getPermitMenuByUsername(username);
    }


    @GetMapping("/{username}")
    @ApiOperation(value = "根据用户权限获取菜单")
    public List<Menu> getPermitMenu(@PathVariable String username){
//        List<Menu> rawMenu = new ArrayList<>();
//        rawMenu = menuService.getPermitMenuByUsername(username);
//        List<Menu> menu = new ArrayList<>();
//        menu = initMenu2(rawMenu,menu);
        return this.menuService.getPermitMenuByUsername(username);
    }

    @GetMapping()
    @ApiOperation(value = "获取所有菜单")
    public List<Menu> getMenu(){

//        List<Menu> rawMenu = new ArrayList<>();
//        rawMenu = menuService.getAll();
//        List<Menu> menu = new ArrayList<>();
//        menu = initMenu2(rawMenu,menu);
        return this.menuService.getAll();
    }
    private List<Menu> getChild(Integer id, List<Menu> rawMenu){
        List<Menu> childList = new ArrayList<>();
        for (Menu menu : rawMenu){
            if (menu.getParentId()==id){
                childList.add(menu);
            }
        }
        for (Menu menu : childList){
            menu.setChildren(getChild(menu.getId(), rawMenu));
        }

        if (childList.size() ==0 ){
            return null;
        }
        return childList;
    }

    @PostMapping
    @ApiOperation(value = "添加菜单")
    public Msg add(@RequestBody Menu menu){
        Integer flag = this.menuService.add(menu);
        if (flag > 0){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据id删除菜单")
    public Msg delete(@PathVariable Integer id){
        Integer flag = this.menuService.delete(id);
        if (flag > 0){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "根据id更新菜单")
    public Msg update(@RequestBody Menu menu){
        Integer flag = this.menuService.update(menu);
        if (flag > 0){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }

//    @GetMapping("/{id}")
//    public Menu getById(@PathVariable Integer id){
//        Menu menu = this.menuService.getById(id);
//        return menu;
//    }

}
