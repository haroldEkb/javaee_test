package com.harold.service;

import com.harold.entity.Role;
import com.harold.persist.RoleRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.List;

@Stateless
public class RoleService implements Serializable {

    @EJB
    private RoleRepository roleRepository;

    public Role findById(int i) {
        return roleRepository.findById(i);
    }

    public void insert(Role product) {
        roleRepository.insert(product);
    }

    public void update(Role product) {
        roleRepository.update(product);
    }

    public void delete(Integer id) {
        roleRepository.delete(id);
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
