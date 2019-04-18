package com.cby.dao;

import com.cby.entity.Carport;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarportMapperTest {

    private ApplicationContext applicationContext;

    @Autowired
    private CarportMapper mapper;

    @Before
    public void setUp() throws Exception {
        // 加载spring配置文件
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        // 导入需要测试的
        mapper = applicationContext.getBean(CarportMapper.class);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insert() throws Exception{
        Carport carport = new Carport();
        carport.setCarportId("004");
        int result = mapper.insert(carport);
        System.out.println(result);
    }
}