package com.xt.springboot;

import com.xt.springboot.beans.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * SpringBoot 单元测试
 *
 * 可以在测试期间很方便的类似编码一样进行自动注入等容器的功能
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot02ConfigApplicationTests {

	@Autowired
	Person person;

	@Autowired
	ApplicationContext ioc;

	@Autowired
	DataSource dataSource;

	// 记录器
	Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	public void testHelloService() {
		boolean b = ioc.containsBean("helloService");
		System.out.println(b);
	}

	@Test
	public void contextLoads() throws SQLException {
		System.out.println(person);
		System.out.println(dataSource.getClass());
		Connection connection = dataSource.getConnection();
		System.out.println(connection);

	}

	@Test
	public void testLog() {
//		System.out.println();

		/**
		 * 日志级别：
		 * 由低到高: trace < debug < info < warn < error
		 * 可以调整输出的日志级别: 日志就只会在这个级别及以后的高级别生效
		 */
		logger.trace("这是 trace 级别日志");
		logger.debug("这是 debug 级别日志");

		// SpringBoot 默认给我们使用的是 info 级别的，没有指定级别的就用 SpringBoot 默认规定的级别； root级别
		logger.info("这是 infog 级别日志");
		logger.warn("这是 warn 级别日志");
		logger.error("这是 error 级别日志");
	}

}
