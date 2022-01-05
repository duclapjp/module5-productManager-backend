package com.example.testspring.service.user;

import com.example.testspring.model.User;
import com.example.testspring.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends IGeneralService<User>, UserDetailsService {
}
