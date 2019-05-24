package com.smart.service;

import static org.testng.Assert.*;
import org.testng.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;

import static org.testng.Assert.assertTrue;


@ContextConfiguration("classpath*:/smart-context.xml")
public class UserServiceTest extends AbstractTransactionalTestNGSpringContextTests {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @Test
    public void HashMatchCount() {
        boolean b1 = userService.hashMatchUser("admin","ah123456");
        boolean b2 = userService.hashMatchUser("admin","23213");

        assertTrue(b1);
        assertTrue(b2);

    }
}
