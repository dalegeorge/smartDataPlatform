package com.xiaomi.smartDataPlatform;

import com.xiaomi.smartDataPlatform.entity.Account;
import com.xiaomi.smartDataPlatform.repository.AccountRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.List;

@RestController
@SpringBootApplication
public class SmartDataPlatformApplication {

	@RequestMapping("/")
			String home()
	{
		return "Hello World";
	}
	public static void main(String[] args) {
		// mybatis and mysql connection
		InputStream inputStream = SmartDataPlatformApplication.class.getClassLoader().getResourceAsStream("mybatisConfig.xml");
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 第一种方式写CRUD
		String statement = "com.xiaomi.smartDataPlatform.mapper.AccountMapper.save";
		Account account1 = new Account(1L,"zhangsan","1991203",25);
//		sqlSession.insert(statement,account1);
//		sqlSession.commit();
		AccountRepository accountRepository = sqlSession.getMapper(AccountRepository.class);

		// 查询表里所有对象
		List<Account> list = accountRepository.findAll();
		int count = 0;
		for (Account account:list)
		{

			System.out.println(count+":"+account+"\n");
			++count;
		}
//		sqlSession.close();

		// 添加新对象
//		Account account2 = new Account(3L,"王五","111555",23);
//		accountRepository.save(account2);
//		sqlSession.commit();
		// 通过id查询对象
//		Account account3 = accountRepository.findById(3L);
//		System.out.println(account3);
//		sqlSession.close();

		// 修改对象
//		Account account = accountRepository.findById(3L);
//		account.setAge(18);
//		account.setUsername("小明");
//		account.setPassword("12345");
//		int result = accountRepository.update(account);
//		System.out.println(result);
//		sqlSession.close();

		// 通过ID删除对象
		int resultDelete = accountRepository.deleteById(4L);
		System.out.println(resultDelete);
		sqlSession.commit();
		sqlSession.close();
//		SpringApplication.run(SmartDataPlatformApplication.class, args);
	}

}
