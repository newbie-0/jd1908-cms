package com.briup.service;

import java.util.List;

import com.briup.bean.User;
import com.briup.bean.extend.UserExtend;
import com.briup.util.CustomerException;
import com.briup.vm.UserVM;

public interface IUserService {
	UserExtend findById(Integer id);

    List<User> findAll();
    
    List<UserExtend> cascadeRoleFindAll();

    void saveOrUpdate(User User) throws CustomerException;

    void changeStatus(Integer id,String status) throws CustomerException;
    
    void deleteById(Integer id) throws CustomerException;
    
    void setRoles(Integer id, List<Integer> roles);
    
    User login(UserVM vm) throws CustomerException;
}
