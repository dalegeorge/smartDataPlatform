package com.xiaomi.smartDataPlatform.test;

import com.xiaomi.smartDataPlatform.SmartDataPlatformApplication;
import com.xiaomi.smartDataPlatform.repository.UserRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Tester1 {
    public static void main(String[] args)
    {
        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("mybatisConfig.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserRepository userRepository = sqlSession.getMapper(UserRepository.class);
        System.out.println(userRepository.findById(3L));
    }
}
