package com.cjrj.edu.shiro;

import com.cjrj.edu.entity.Menu;
import com.cjrj.edu.entity.Role;
import com.cjrj.edu.entity.User;
import com.cjrj.edu.entity.vo.ActiviUser;
import com.cjrj.edu.entity.vo.MenuVO;
import com.cjrj.edu.service.MenuService;
import com.cjrj.edu.service.RoleService;
import com.cjrj.edu.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserRealm extends AuthorizingRealm {
    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;
    @Resource
    private MenuService menuService;

    /**
     * 提供用户信息返回权限信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        ActiviUser user = (ActiviUser) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 根据用户名查询当前用户拥有的角色
        Set<Role> roles = roleService.findRoles(user.getUsername());
        Set<String> roleNames = new HashSet<String>();
        for (Role role : roles) {
            roleNames.add(role.getRoleName());
        }
        // 将角色名称提供给info
        authorizationInfo.setRoles(roleNames);
        // 根据用户名查询当前用户权限

        // 将权限名称提供给info
//        authorizationInfo.setStringPermissions(menuTree);

        return authorizationInfo;
    }

    /**
     *     提供账户信息返回认证信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        User user = userService.findByUsername(username);
        if (user == null) {
            // 用户名不存在抛出异常
            throw new UnknownAccountException();
        }
        if (user.getLocked() == new BigDecimal(0)) {
            // 用户被管理员锁定抛出异常
            throw new LockedAccountException();
        }
        ActiviUser activiUser=new ActiviUser();
        activiUser.setUserId(user.getUserId());
        activiUser.setUsername(user.getUsername());
        activiUser.setPassword(user.getPassword());
        activiUser.setEmail(user.getEmail());
        activiUser.setDeptid(user.getDeptid());
        activiUser.setLocked(user.getLocked());
        List<MenuVO> menus = menuService.findMenus(activiUser.getUsername(),new BigDecimal(0));
        List<MenuVO> menuTree=new ArrayList<MenuVO>();
        for (MenuVO menu :
                menus) {
            menu.setTree(menuService.findMenus(activiUser.getUsername(),menu.getMenuId()));
            menuTree.add(menu);
        }
        activiUser.setTree(menuTree);
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(activiUser,
                activiUser.getPassword(), getName());
        return authenticationInfo;
    }
}
