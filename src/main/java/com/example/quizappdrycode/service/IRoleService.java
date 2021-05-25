package com.example.quizappdrycode.service;

import com.example.quizappdrycode.model.Role;

public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String name);
}
