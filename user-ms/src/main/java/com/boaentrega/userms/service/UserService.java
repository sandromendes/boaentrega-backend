package com.boaentrega.userms.service;

import java.util.List;

import com.boaentrega.userms.domain.User;

public interface UserService {
    List<User> findAll();

    User findById(Long id);

    User save(User user);
    
    User update(User user);

    void delete(Long id);
}
