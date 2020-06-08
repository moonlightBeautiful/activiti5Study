package com.ims;


import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;

public class UserAndGroupStudy {

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
         *  act_id_user=====================================================
         */
        /**
         * 添加用户
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
         *  act_id_group=====================================================
         */
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
         *  act_id_membership=====================================================
         */
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
