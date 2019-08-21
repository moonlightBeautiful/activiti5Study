package com.java1234.c06taskassign.sec03groupAssign;


import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.User;
import org.activiti.engine.impl.persistence.entity.UserEntity;

public class IdentityTest {

    public static void main(String[] args) {
        /**
         * 获取默认流程引擎实例：会自动读取activiti.cfg.xml文件
         */
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        /**
         * 获取身份服务
         */
        IdentityService indentityService = processEngine.getIdentityService();

        /**
         * 添加用户测试
         */
        /*User user = new UserEntity();
        user.setId("lisi"); //zhangsan lisi wangwu
        user.setPassword("123");
        user.setEmail("1234@qq.com");
        indentityService.saveUser(user);*/

        /**
         * 删除用户
         */
        /*indentityService.deleteUser("lisi");*/

        /**
         * 添加组
         */
        /*Group group=new GroupEntity();
        group.setId("test");    //dev test
        group.setName("测试");
        indentityService.saveGroup(group);*/

        /**
         * 删除组
         */
        /*indentityService.deleteGroup("test");*/

        /**
         * 添加用户和组的关联关系多对多
         */
        /*indentityService.createMembership("lisi", "dev");*/

        /**
         * 删除用户和组的关联关系
         */
        /*indentityService.deleteMembership("wangwu", "test");*/

    }

}
