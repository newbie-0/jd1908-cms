package com.briup.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.bean.User;
import com.briup.bean.UserExample;
import com.briup.bean.UserRole;
import com.briup.bean.UserRoleExample;
import com.briup.bean.extend.UserExtend;
import com.briup.dao.UserMapper;
import com.briup.dao.UserRoleMapper;
import com.briup.dao.extend.UserExtendMapper;
import com.briup.service.IUserService;
import com.briup.util.CustomerException;
import com.briup.vm.UserVM;

@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private UserExtendMapper userExtendMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public UserExtend findById(Integer id) {
        return userExtendMapper.selectById(id);
    }

    @Override
    public List<User> findAll() {
        return userMapper.selectByExample(new UserExample());
    }

    @Override
    public List<UserExtend> cascadeRoleFindAll() {
        return userExtendMapper.selectAll();
    }

    @Override
    public void saveOrUpdate(User user) throws CustomerException {
        if(user.getId()!=null){
            userMapper.updateByPrimaryKey(user);
        } else {
            // 判断用户名是否被占用
            UserExample example = new UserExample();
            example.createCriteria().andUsernameEqualTo(user.getUsername());
            List<User> list = userMapper.selectByExample(example);
            if(list.size()>0){
                throw new CustomerException("该用户已经被占用");
            }
            // 初始化
            user.setRegisterTime(new Date());
            user.setStatus(UserExtend.STATUS_NORMAL);
            userMapper.insert(user);
        }
    }

    @Override
    public void changeStatus(Integer id,String status) throws CustomerException {
        User user = this.findById(id);
        if(user==null){
            throw new CustomerException("该用户不存在");
        }
        user.setStatus(status);
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void deleteById(Integer id) throws CustomerException {
        User user = this.findById(id);
        if(user==null){
            throw new CustomerException("该用户不存在");
        }
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void setRoles(Integer id, List<Integer> roles) {
        // 根据userid查询自己的角色
        UserRoleExample example = new UserRoleExample();
        example.createCriteria().andUserIdEqualTo(id);
        // 用户角色关系,获取所有老的角色
        List<UserRole> list = userRoleMapper.selectByExample(example);
        List<Integer> oldRoles = new ArrayList<>();
        Iterator<UserRole> iterator = list.iterator();
        while(iterator.hasNext()){
            oldRoles.add(iterator.next().getRoleId());
        }
        // [1,2,3] -> [3,4] 添加1,2 => [1,2,3,4]
        // 依次判断新角色是否存在于list中，如果不存在则添加
        for(Integer roleId : roles){
            if(!oldRoles.contains(roleId)){
                UserRole userRole = new UserRole();
                userRole.setRoleId(roleId);
                userRole.setUserId(id);
                userRoleMapper.insert(userRole);
            }
        }
        // [1,2,3] -> [1,2,3,4]   删除 3,4  => [1,2]
        // 一次判断老的角色是否存在于roles中，如果不存在则删除
        for(UserRole userRole : list){
            if(!roles.contains(userRole.getRoleId())){
                userRoleMapper.deleteByPrimaryKey(userRole.getId());
            }
        }


    }

	@Override
	public User login(UserVM vm) throws CustomerException {
		User user = userMapper.selectByUsername(vm.getUsername());
		if (user == null)
			throw new CustomerException("用户名不存在");
		else {
			if (!user.getPassword().equals(vm.getPassword())) {
				throw new CustomerException("密码错误");
			} else {
				return user;
			}
		}
	}
}