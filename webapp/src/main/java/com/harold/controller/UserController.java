package com.harold.controller;

import com.harold.entity.Role;
import com.harold.entity.User;
import com.harold.service.RoleService;
import com.harold.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
@Interceptors({com.harold.util.Logger.class})
public class UserController implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Inject
    private UserService userService;

    @Inject
    private RoleService roleService;

    @Inject
    private HttpServletRequest request;

    private User user;

    private List<User> userList;

    private List<Role> roleList;

    @PostConstruct
    public void init(){
        this.userList = userService.findAll();
        this.roleList = roleService.findAll();
    }

    public List<User> getAllUsers() {
        return userList;
    }

    public List<Role> getAllRoles() {
        return roleList;
    }

    public String createUser() {
        this.user = new User();
        return "/admin/edit_user.xhtml?faces-redirect=true";
    }

    public String saveUser() {
        if (user.getId() == null) {
            userService.insert(user);
        } else {
            userService.update(user);
        }
        return "/admin/users.xhtml?faces-redirect=true";
    }

    public void deleteUser(User user) {
        logger.info("Deleting user");
        userService.delete(user.getId());
    }

    public String editUser(User user) {
        this.user = user;
        return "/admin/edit_user.xhtml?faces-redirect=true";
    }

    public String login(){
        return "/login.xhtml?faces-redirect=true";
    }

    public String logout() throws ServletException {
        request.logout();
        return "/index.xhtml?faces-redirect=true";
    }
}
