package com.harold.service;

import com.harold.entity.User;
import com.harold.persist.UserRepository;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.List;

@Stateless
@DeclareRoles({"ADMIN", "MANAGER"})
public class UserService implements Serializable {

    @EJB
    private UserRepository userRepository;

    public User findById(int i) {
        return userRepository.findById(i);
    }

    @RolesAllowed("ADMIN")
    public void insert(User product) {
        userRepository.insert(product);
    }

    @RolesAllowed("ADMIN")
    public void update(User product) {
        userRepository.update(product);
    }

    @RolesAllowed("ADMIN")
    public void delete(Integer id) {
        userRepository.delete(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
