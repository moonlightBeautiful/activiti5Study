
package com.java1234.c06taskassign.sec02multiUserAssign;


import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 多用户分配：流程中设置流程变量${userids} candidateUsers
 */
public class AssignTest2 {

    public static void main(String[] args) {
        /**
         * 生成工作流环境（25张表）：不使用配置文件，就要手动set数据库信息
         */
        /*
        // 获取流程引擎配置（数据库驱动+地址+用户名+密码）
        ProcessEngineConfiguration pec = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
        pec.setJdbcDriver("com.mysql.jdbc.Driver");
        pec.setJdbcUrl("jdbc:mysql://47.244.180.90:3306/db_activiti?useUnicode=true&characterEncoding=UTF-8");
        pec.setJdbcUsername("root");
        pec.setJdbcPassword("root");
        // 配置模式：DB_SCHEMA_UPDATE_CREATE_DROP先删除表再创建表， DB_SCHEMA_UPDATE_TRUE如果表不存在，自动创建表，DB_SCHEMA_UPDATE_FALSE不能自动创建表，需要表存在
        pec.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        */
        /**
         * 生成工作流环境（25张表）：用配置文件，配置文件中有数据库的信息和生成数据库的模式
         */
        // 引擎配置读取配置文件
       /*
       ProcessEngineConfiguration processEngineConfiguration =
                ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        // 引擎配置生成工作流环境
        processEngineConfiguration.buildProcessEngine();
        */

        /**
         * 获取默认流程引擎实例：会自动读取activiti.cfg.xml文件
         */
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        /**
         * 部署流程：
         *      使用RepositoryService流程仓库服务，重复部署，部署id和定义id和定义的version会变，定义的key不变
         * 两种部署方式：
         *      bpmn和png文件方式、bpmn和png文件的压缩文件方式
         */
        // 部署流程方式1：bpmn和png文件：
       /*Deployment deployment = processEngine.getRepositoryService()
                .createDeployment()
                .addClasspathResource("diagrams/multiUsers02.bpmn")
                .addClasspathResource("diagrams/multiUsers02.png")
                .name("多用户分配流程02")
                .deploy();
        System.out.println("流程部署ID:" + deployment.getId());
        System.out.println("流程部署Name:" + deployment.getName());*/
        // 部署流程方式2：bpmn和png文件的压缩文件：
         /*InputStream inputStream = App.class // 取得当前class对象
                .getClassLoader() // 获取类加载器
                .getResourceAsStream("diagrams/hello.zip"); // 获取指定文件资源流
        ZipInputStream zipInputStream = new ZipInputStream(inputStream); // 实例化zip输入流
        Deployment deployment = processEngine.getRepositoryService() // 获取部署相关Service
                .createDeployment() // 创建部署
                .addZipInputStream(zipInputStream) // 添加zip输入流
                .name("HelloWorld流程") // 流程名称
                .deploy(); // 部署
        System.out.println("流程部署ID:" + deployment.getId());
        System.out.println("流程部署Name:" + deployment.getName());*/

        /**
         * 启动流程：
         *      其实就是从流程定义（最新版）中实例化一个流程实例
         */
       /* Map<String,Object> variables=new HashMap<String,Object>();
        variables.put("userIds", "张三,李四,王五");
        ProcessInstance processInstance = processEngine.getRuntimeService()
                .startProcessInstanceByKey("multiUsers02",variables);
        System.out.println("流程实例ID:" + processInstance.getId());
        System.out.println("流程定义ID:" + processInstance.getProcessDefinitionId());*/

        /**
         * 查询运行的流程任务：根据用户名查询正在运行的流程任务
         */
        /*List<Task> taskList = processEngine.getTaskService()
                .createTaskQuery()
                .taskCandidateUser("李四")  //张三 李四 王五
                .list();
        for (Task task : taskList) {
            System.out.println("任务ID:" + task.getId());
            System.out.println("任务名称:" + task.getName());
            System.out.println("任务创建时间:" + task.getCreateTime());
            System.out.println("任务委派人:" + task.getAssignee());
            System.out.println("任务干支ID:" + task.getExecutionId());
            System.out.println("流程实例ID:" + task.getProcessInstanceId());
            System.out.println("流程定义ID:" + task.getProcessDefinitionId());
            System.out.println("=============================================");
        }*/

        /**
         * 结束正在运行的流程任务：
         */
        /*processEngine.getTaskService()
                .complete("37505");*/

        /**
         *  历史流程实例查询：
         */
       /* List<HistoricProcessInstance> list = processEngine.getHistoryService() // 历史相关Service
                .createHistoricProcessInstanceQuery()
                .finished()
                .list();
        for (HistoricProcessInstance hai : list) {
            System.out.println("历史流程ID:" + hai.getId());
            System.out.println("历史流程定义名称:" + hai.getProcessDefinitionName());
            System.out.println("开始时间：" + hai.getStartTime());
            System.out.println("结束时间：" + hai.getEndTime());
            System.out.println("==================================================================");
        }*/
    }
}