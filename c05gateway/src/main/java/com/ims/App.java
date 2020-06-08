package com.ims;


import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gaoxu
 * @date 2019-07-18 10:31
 * @description 连接线的学习，没有使用网关。
 */
public class App {
    public static void main(String[] args) throws IOException {

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        /**
         * 部署流程：====================================================================================
         */
        Deployment deployment = processEngine.getRepositoryService()
                .createDeployment()
                .addClasspathResource("diagrams/StudentLeaveProcess3.bpmn")
                .addClasspathResource("diagrams/StudentLeaveProcess3.png")
                .name("学生请假流程3排它网关测试")
                .deploy();
        System.out.println("流程部署ID:" + deployment.getId());
        System.out.println("流程部署Name:" + deployment.getName());

        /**
         * 启动流程：===========================================================================================
         */
        /*ProcessInstance processInstance = processEngine.getRuntimeService()
                .startProcessInstanceByKey("studentLeaveProcess2");
        System.out.println("流程实例ID:" + processInstance.getId());
        System.out.println("流程模板ID:" + processInstance.getProcessDefinitionId());
        System.out.println("流程模板Key:" + processInstance.getProcessDefinitionKey());*/

        /**
         * 查询运行的用户任务：===============================================================================
         */
        /*List<Task> taskList = processEngine.getTaskService()
                .createTaskQuery()
                .taskAssignee("李四2")
                .list();
        for (Task task : taskList) {
            System.out.println("任务ID:" + task.getId());
            System.out.println("任务名称:" + task.getName());
            System.out.println("任务创建时间:" + task.getCreateTime());
            System.out.println("任务委派人:" + task.getAssignee());
            System.out.println("流程执行对象ID:" + task.getExecutionId());
            System.out.println("流程实例ID:" + task.getProcessInstanceId());
            System.out.println("流程模板ID:" + task.getProcessDefinitionId());
            System.out.println("流程模板Key:" + task.getTaskDefinitionKey());
            System.out.println("========================================================");
        }*/

        /**
         * 结束正在运行的流程任务：
         */
        /*processEngine.getTaskService().complete("12504");*/

//===============================================================================================================
        /**
         * 结束正在运行的用户任务：附加连接线、网关 变量
         */
        /*Map<String, Object> conditions =new HashMap<String,Object>();
        conditions.put("msg", "一般情况");  //days 32 5 15
        processEngine.getTaskService().complete("15002",conditions);*/

    }
}
