package com.xiaomi.smartDataPlatform;

import com.xiaomi.smartDataPlatform.entity.Account;
import com.xiaomi.smartDataPlatform.entity.Platform;
import com.xiaomi.smartDataPlatform.entity.Users;
import com.xiaomi.smartDataPlatform.repository.AccountRepository;
import com.xiaomi.smartDataPlatform.repository.PlatformRepository;
import com.xiaomi.smartDataPlatform.repository.UserRepository;
import jakarta.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.List;

@RestController
@SpringBootApplication
@MapperScan("com.xiaomi.smartDataPlatform.repository")
public class SmartDataPlatformApplication {

	@Resource
	private PlatformRepository platformRepository;

	@GetMapping("/Platform")
	public List<Platform> findAll()
	{
		return platformRepository.findAll();
	}

	@RequestMapping("/")
			String home()
	{
		return "Hello World";
	}
	public static void main(String[] args) {
//		SpringApplication.run(SmartDataPlatformApplication.class, args);

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

		// 添加新对象
//		Account account2 = new Account(3L,"王五","111555",23);
//		Account account3 = new Account(2L,"李四","112086",25);
//		accountRepository.save(account3);
//		accountRepository.save(account2);
//		sqlSession.commit();
		// 通过id查询对象
//		Account account3 = accountRepository.findById(3L);
//		System.out.println(account3);

		// 修改对象
//		Account account = accountRepository.findById(3L);
//		account.setAge(18);
//		account.setUsername("小明");
//		account.setPassword("12345");
//		int result = accountRepository.update(account);
//		System.out.println(result);

		// 通过ID删除对象
//		int resultDelete = accountRepository.deleteById(4L);
//		System.out.println(resultDelete);
		// 通过名字查询对象
		Account resultFindByName = accountRepository.findByName("zhangsan");
		System.out.println(resultFindByName);

		// 通过id寻找对象
		Long resultFIndById = Long.parseLong("3");
		System.out.println(accountRepository.findById2(resultFIndById));
		//
		System.out.println(accountRepository.findByNameAndAge("李四",25));
		//
		System.out.println("account count: "+accountRepository.count());
		// 通过id返回名字
		System.out.println("name: "+accountRepository.findNameById(2L));


		sqlSession.commit();
		sqlSession.close();
	}
}
