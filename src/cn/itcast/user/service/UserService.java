package cn.itcast.user.service;

import cn.itcast.user.dao.UserDao;
import cn.itcast.user.domain.User;

/**
 * User的业务逻辑层
 * @author Administrator
 *
 */
public class UserService {
	private UserDao userDao = new UserDao();
	
	/**
	 * 注册功能
	 * @param user
	 * @throws UserException
	 */
	public void register(User user) throws UserException{
		/**
		 * 1、使用用户名去查询，如果返回null,完成添加
		 * 2、如果返回不是null,抛出异常
		 */
		User _user = userDao.findByUsername(user.getUsername());
		if(_user != null) throw new UserException("用户名"+user.getUsername()+"已被注册");
		
		userDao.add(user);
		
	}
}
