package com.briup.service;

import java.util.List;

import com.briup.bean.Role;
import com.briup.bean.extend.RoleExtend;
import com.briup.util.CustomerException;

public interface IRoleService {
	void authorization(Integer roleId,List<Integer> privilegeIds);
	
	List<Role> findAll();
    
    List<RoleExtend> cascadePrivilegeFindAll();
    
    void saveOrUpdate(Role Role) throws CustomerException;
    
    void deleteById(Integer id) throws CustomerException;
}
