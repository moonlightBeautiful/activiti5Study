package com.ims;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * @author gaoxu
 * @date 2019-07-18 10:31
 * @description ... 类
 * 1.
 */
public class App {
    public static void main(String[] args) {
        /**
         * 1.构建流程引擎：1.java配置 2.xml文件配置
         * 2.部署流程模板[也叫做定义]（RepositoryService流程仓库服务）：其实就是把bpmn和png文件信息写入到了数据库流程定义表中。
         * 3.启动流程实例（RuntimeService流程运行服务）：其实就是从流程模板中实例出来一个具体的流程
         * 4.查看用户任务（TaskService）
         * 5.处理用户任务（TaskService）：目前只会完成
         */

        /**
         * 1.构建流程引擎======================================================================================
         * 配置模式：
         *      DB_SCHEMA_UPDATE_CREATE_DROP先删除表再创建表，
         *      DB_SCHEMA_UPDATE_TRUE如果表不存在，自动创建表，
         *      DB_SCHEMA_UPDATE_FALSE不能自动创建表，需要表存在
         */
        /**
         * 1.1  java配置
         */
        /*ProcessEngineConfiguration pec = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
        pec.setJdbcDriver("com.mysql.cj.jdbc.Driver");
        pec.setJdbcUrl("jdbc:mysql://localhost:3306/db_activiti?serverTimezone=UTC");
        pec.setJdbcUsername("root");
        pec.setJdbcPassword("root");
        pec.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        ProcessEngine processEngine = pec.buildProcessEngine();*/
        /**
         * 1.2  xml配置：1.指定xml文件 2.默认xml文件
         */
        /*ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration
                .createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();*/
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        /**
         * 2.部署流程定义[也叫做模板]==============================================================
         * （RepositoryService流程仓库服务）：其实就是把bpmn和png文件信息写入到了数据库流程定义表中。
         */
        /*Deployment deployment = processEngine.getRepositoryService()
                .createDeployment()
                .addClasspathResource("diagrams/process.bpmn")
                .addClasspathResource("diagrams/process.png")
                .name("我的部署1")
                .category("类别1")
                .deploy();
        System.out.println("部署ID:" + deployment.getId());
        System.out.println("部署Name:" + deployment.getName());
        System.out.println("部署类别:" + deployment.getCategory());
        System.out.println("部署时间:" + deployment.getDeploymentTime());*/
        /**
         * 3. 启动流程实例（RuntimeService流程运行服务）：===============================================================================
         *  其实就是从流程模板中实例出来一个具体的流程
         */
       /* ProcessInstance processInstance = processEngine.getRuntimeService()
                .startProcessInstanceByKey("process");
        System.out.println("流程模板ID:" + processInstance.getProcessDefinitionId());
        System.out.println("流程实例ID:" + processInstance.getId());
        System.out.println("流程实例name:" + processInstance.getName());
        System.out.println("流程活动节点ID:" +  processInstance.getActivityId());*/

        /**
         * 4. 查看用户任务（TaskService）：===============================================================================================
         *      条件：流程实例id、指定人，可单独可组合
         *          .taskAssignee("java1234")
         */
        List<Task> taskList = processEngine.getTaskService()
                .createTaskQuery()
                .processInstanceId("5001")
                .list();
        for (Task task : taskList) {
            System.out.println("任务ID:" + task.getId());
            System.out.println("任务key:" + task.getTaskDefinitionKey());
            System.out.println("任务名称:" + task.getName());
            System.out.println("任务类别:" + task.getCategory());
            System.out.println("任务创建时间:" + task.getCreateTime());
            System.out.println("任务委派人:" + task.getAssignee());
            System.out.println("流程模板ID:" + task.getProcessDefinitionId());
            System.out.println("流程实例ID:" + task.getProcessInstanceId());
        }
        /**
         * 4. 完成用户任务（TaskService）：======================================================================================
         */
        /*processEngine.getTaskService().complete("5004");*/

    }
}
