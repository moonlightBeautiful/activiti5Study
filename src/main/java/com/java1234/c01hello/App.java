package com.java1234.c01hello;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * @author gaoxu
 * @date 2019-07-18 10:31
 * @description ... 类
 */
public class App {
    public static void main(String[] args) {

        // 不使用配置文件生成工作流环境（25张表）
        /*// 获取流程引擎配置（数据库驱动+地址+用户名+密码）
        ProcessEngineConfiguration pec = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
        pec.setJdbcDriver("com.mysql.jdbc.Driver");
        pec.setJdbcUrl("jdbc:mysql://47.244.180.90:3306/db_activiti?useUnicode=true&characterEncoding=UTF-8");
        pec.setJdbcUsername("root");
        pec.setJdbcPassword("root");

        // 配置模式：DB_SCHEMA_UPDATE_CREATE_DROP先删除表再创建表， DB_SCHEMA_UPDATE_TRUE如果表不存在，自动创建表，DB_SCHEMA_UPDATE_FALSE不能自动创建表，需要表存在
        pec.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        // 获取流程引擎对象，并生成25张表
        ProcessEngine pe = pec.buildProcessEngine();*/

        // 使用配置文件生成工作流环境（25张表）
        // 引擎配置
       /* ProcessEngineConfiguration processEngineConfiguration =
                ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        // 获取流程引擎对象
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();*/

        // 获取默认流程引擎实例，会自动读取activiti.cfg.xml文件
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 部署流程：可以多次部署,貌似使用的是最新的，部署完之后，在流程定义表中出现流程模板
       /*     // 使用流程引擎（RepositoryService流程仓库服务）
        Deployment deployment = processEngine.getRepositoryService()
                .createDeployment()
                .addClasspathResource("diagrams/Hello.bpmn")
                .addClasspathResource("diagrams/Hello.png")
                .name("Hello流程")
                .deploy();
        System.out.println("流程部署ID:" + deployment.getId());
        System.out.println("流程部署Name:" + deployment.getName());*/

        // 启动流程
        // 使用流程引擎（RuntimeService流程运行服务）
       /* ProcessInstance processInstance = processEngine.getRuntimeService()
                .startProcessInstanceByKey("MyFirstProcess");
        System.out.println("流程实例ID:" + processInstance.getId());
        System.out.println("流程部署ID:" + processInstance.getDeploymentId());
        System.out.println("流程定义ID:" + processInstance.getProcessDefinitionId());*/



        // 查看任务
        // 使用流程引擎（TaskService流程任务服务）
        List<Task> taskList = processEngine.getTaskService()
                .createTaskQuery()
                .taskAssignee("高旭")
                .list();
        for (Task task : taskList) {
            System.out.println("任务ID:" + task.getId());
            System.out.println("任务名称:" + task.getName());
            System.out.println("任务创建时间:" + task.getCreateTime());
            System.out.println("任务委派人:" + task.getAssignee());
            System.out.println("流程实例ID:" + task.getProcessInstanceId());
        }
        // 结束任务，如果任务不存在，则跑出异常
        // 使用流程引擎（TaskService流程任务服务）
       /* processEngine.getTaskService()
                .complete("2504");*/
    }
}
