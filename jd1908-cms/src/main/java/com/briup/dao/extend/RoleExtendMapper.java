package com.briup.dao.extend;

import java.util.List;

import com.briup.bean.Role;
import com.briup.bean.extend.RoleExtend;

public interface RoleExtendMapper {
	List<Role> selectByUserId(long id);

    List<RoleExtend> selectAll();
}
