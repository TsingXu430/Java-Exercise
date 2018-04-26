package test.dao;

import org.junit.jupiter.api.Test;

import cn.itcast.user.dao.UserDao;
import cn.itcast.user.domain.User;

public class UserDaoTest {
	@Test
	public void testFindByUsername() {
		UserDao userDao = new UserDao();
		User user = userDao.findByUsername("王五");
		System.out.print(user);
	}
	
	@Test
	public void testAdd() {
		UserDao userDao = new UserDao();
		User user = new User();
		user.setUsername("王五");
		user.setPassword("wangwu");
		userDao.add(user);
	}
}
