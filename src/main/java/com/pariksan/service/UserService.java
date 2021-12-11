package com.pariksan.service;

import com.pariksan.model.User;
import com.pariksan.model.UserRole;

import java.util.Set;

public interface UserService {

    //For creating User
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;
}