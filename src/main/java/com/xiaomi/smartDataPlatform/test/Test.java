package com.xiaomi.smartDataPlatform.test;

import com.xiaomi.smartDataPlatform.SmartDataPlatformApplication;
import com.xiaomi.smartDataPlatform.repository.CustomerRepository;
import com.xiaomi.smartDataPlatform.repository.ProductRespoitory;
import com.xiaomi.smartDataPlatform.repository.UserRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Test {
    public static void main(String[] args)
    {
        InputStream inputStream = SmartDataPlatformApplication.class.getClassLoader().getResourceAsStream("mybatisConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 实现接口代理
        UserRepository userRepository = sqlSession.getMapper(UserRepository.class);
        System.out.println(userRepository.findById(5L));
//        PlatformRepository platformRepository = sqlSession.getMapper(PlatformRepository.class);
//        System.out.println(platformRepository.findAll());
//        System.out.println(platformRepository.findById(1L));

        CustomerRepository customerRepository = sqlSession.getMapper(CustomerRepository.class);
        System.out.println(customerRepository.findById(1L));

        ProductRespoitory productRespoitory = sqlSession.getMapper(ProductRespoitory.class);
        System.out.println(productRespoitory.findById(5L));
        sqlSession.close();
    }
}
