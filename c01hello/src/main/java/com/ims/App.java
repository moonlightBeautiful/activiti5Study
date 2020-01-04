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
         * 1.构建流程引擎，根据配置文件（如果25张表存在则不再创建，不存在则从新创建）
         * 2.部署流程模板[也叫做定义]（RepositoryService流程仓库服务）：其实就是把bpmn和png文件信息写入到了数据库流程定义表中。
         * 3.启动流程实例（RuntimeService流程运行服务）：其实就是从流程模板中实例出来一个具体的流程
         * 4.查看用户任务（TaskService）
         * 5.处理用户任务（TaskService）：目前只会完成
         */

        /**
         * 1.根据配置文件构建流程引擎（如果25张表存在则不再创建，不存在则从新创建）
         */
        /**
         * 方式1： 不使用配置文件生成工作流环境（25张表）
         */
        /*  // 引擎配置
        ProcessEngineConfiguration pec = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
        pec.setJdbcDriver("com.mysql.jdbc.Driver");
        pec.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/db_activiti?useUnicode=true&characterEncoding=UTF-8");
        pec.setJdbcUsername("root");
        pec.setJdbcPassword("root");
        // 配置模式：DB_SCHEMA_UPDATE_CREATE_DROP先删除表再创建表， DB_SCHEMA_UPDATE_TRUE如果表不存在，自动创建表，DB_SCHEMA_UPDATE_FALSE不能自动创建表，需要表存在
        pec.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        // 获取流程引擎对象，并生成25张表
        ProcessEngine processEngine = pec.buildProcessEngine();*/
        /**
         * 方式2： 使用配置文件生成工作流环境（25张表）
         *      1.createProcessEngineConfigurationFromResource
         *      2.buildProcessEngine
         */
        // 引擎配置读取xml，方式1,指定xml文件
        /*ProcessEngineConfiguration processEngineConfiguration =
                ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        // 获取流程引擎对象
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();*/
        // 引擎配置读取xml，方式2，默认xml文件全路径问class路径下，名字默认为activiti.cfg.xml
         ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        /**
         * 2.部署流程定义[也叫做模板]（RepositoryService流程仓库服务）：其实就是把bpmn和png文件信息写入到了数据库流程定义表中。
         */
        /*Deployment deployment = processEngine.getRepositoryService()
                .createDeployment()
                .addClasspathResource("diagrams/Hello.bpmn") //加载资源文件
                .addClasspathResource("diagrams/Hello.png")//加载资源文件
                .name("Hello流程")
                .category("类别1")
                .deploy();
        System.out.println("部署是程署，流程模板是流程模板。每次部署流程模板，记录这次的部署。");
        System.out.println("部署只记录了一些部署信息，通过部署对象只能获取一些部署表上的信息。");
        System.out.println("部署ID:" + deployment.getId());
        System.out.println("部署Name:" + deployment.getName());
        System.out.println("部署类别:" + deployment.getDeploymentTime());
        System.out.println("部署时间:" + deployment.getDeploymentTime());*/

        /**
         * 3. 启动流程实例（RuntimeService流程运行服务）：其实就是从流程模板中实例出来一个具体的流程
         */
        /*ProcessInstance processInstance = processEngine.getRuntimeService()
                .startProcessInstanceByKey("myProcess_1"); //根据流程模板key(流程图的id)启动流程实例
        System.out.println("流程实例所属流程模板ID:" + processInstance.getProcessDefinitionId());
        System.out.println("流程实例ID:" + processInstance.getId());
        System.out.println("流程实例name:" + processInstance.getName());*/

        /**
         * 4. 查看用户任务（TaskService）：
         */
        /*List<Task> taskList = processEngine.getTaskService()
                .createTaskQuery()
                .processInstanceId("12501")
               .taskAssignee("java1234")
                .list();
        for (Task task : taskList) {
            System.out.println("任务ID:" + task.getId());
            System.out.println("任务名称:" + task.getName());
            System.out.println("任务创建时间:" + task.getCreateTime());
            System.out.println("任务委派人:" + task.getAssignee());
            System.out.println("流程实例ID:" + task.getProcessInstanceId());
        }*/
        /**
         * 4. 完成用户任务（TaskService）：
         */
       /*processEngine.getTaskService().complete("12504");*/

    }
}
