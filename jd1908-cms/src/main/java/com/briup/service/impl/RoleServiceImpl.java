package com.briup.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.bean.Role;
import com.briup.bean.RoleExample;
import com.briup.bean.RolePrivilege;
import com.briup.bean.RolePrivilegeExample;
import com.briup.bean.extend.RoleExtend;
import com.briup.dao.RoleMapper;
import com.briup.dao.RolePrivilegeMapper;
import com.briup.dao.extend.RoleExtendMapper;
import com.briup.service.IRoleService;
import com.briup.util.CustomerException;

@Service
public class RoleServiceImpl implements IRoleService {
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private RoleExtendMapper roleExtendMapper;
    @Resource
    private RolePrivilegeMapper rolePrivilegeMapper;

    @Override
    public void authorization(Integer roleId, List<Integer> privilegeIds) {
        // 根据roleid查询出所有的权限
        RolePrivilegeExample example = new RolePrivilegeExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        List<RolePrivilege> list = rolePrivilegeMapper.selectByExample(example);
        // 将list转换为privilegeIDs的集合
        List<Integer> old_privilegeIds = new ArrayList<>();
        for(RolePrivilege rp : list){
            old_privilegeIds.add(rp.getPrivilegeId());
        }
        // 依次判断privilegeIds 是否存在old_privilegeIds，如果不在则插入
        for(Integer privilegeId : privilegeIds){
            if (!old_privilegeIds.contains(privilegeId)) {
                RolePrivilege rp = new RolePrivilege();
                rp.setRoleId(roleId);
                rp.setPrivilegeId(privilegeId);
                rolePrivilegeMapper.insert(rp);
            }
        }
        // 依次判断 是否存在old_privilegeIds 是否存在privilegeIds，如果不存在删除
        for(Integer privilegeId: old_privilegeIds){
            if(!privilegeIds.contains(privilegeId)){
                // 根据privilegeId 从桥表中删除
                example.clear();
                example.createCriteria()
                        .andRoleIdEqualTo(roleId)
                        .andPrivilegeIdEqualTo(privilegeId);
                rolePrivilegeMapper.deleteByExample(example);
            }
        }

    }

    @Override
    public List<Role> findAll() {

        return roleMapper.selectByExample(new RoleExample());
    }

    @Override
    public List<RoleExtend> cascadePrivilegeFindAll() {
        return roleExtendMapper.selectAll();
    }

    @Override
    public void saveOrUpdate(Role Role) throws CustomerException {
        if(Role.getId()!=null){
            roleMapper.updateByPrimaryKey(Role);
        } else {
            roleMapper.insert(Role);
        }
    }

    @Override
    public void deleteById(Integer id) throws CustomerException {
        Role role = roleMapper.selectByPrimaryKey(id);
        if(role == null){
            throw new CustomerException("要删除的角色不存在");
        }
        roleMapper.deleteByPrimaryKey(id);
    }
}