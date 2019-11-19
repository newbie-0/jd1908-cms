package com.briup.dao.extend;

import java.util.List;

import com.briup.bean.Privilege;
import com.briup.vm.PrivilegeTree;

public interface PrivilegeExtendMapper {
	List<PrivilegeTree> selectAll();

    List<Privilege> selectByParentId(Integer id);

    List<Privilege> selectByRoleId(Integer id);
}
