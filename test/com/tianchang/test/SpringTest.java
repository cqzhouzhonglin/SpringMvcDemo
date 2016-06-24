package com.tianchang.test;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    @Resource
    private SqlSessionTemplate sqlSession;

    /**
     * @param sqlSession the sqlSession to set
     */
    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-common.xml");
        Object supperDao = ctx.getBean("supperDao");
        System.out.println(supperDao);
    }

}
