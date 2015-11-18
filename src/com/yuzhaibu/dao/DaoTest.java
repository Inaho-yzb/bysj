package com.yuzhaibu.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yuzhaibu.entity.User_normal;

public class DaoTest {

	@Test
	public void test() {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		User_normalDao dao = ctx.getBean(User_normalDao.class);
		
		List<User_normal> list = dao.findAll();
		for(User_normal user:list){
			System.out.println(user.getNickname());
		}
	}

}
