package com.java1234.c03flow;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricActivityInstance;

import java.io.IOException;
import java.util.List;

/**
 * @author gaoxu
 * @date 2019-07-18 10:31
 * @description ... 类
 */
public class App {
    public static void main(String[] args) throws IOException {
        // 获取默认流程引擎实例，会自动读取activiti.cfg.xml文件
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //RepositoryService流程仓库服务：可以多次部署,升版本。部署完之后，在流程定义表中出现流程模板
        // 部署流程，bpmn和png文件：
        /*Deployment deployment = processEngine.getRepositoryService()
                .createDeployment()
                .addClasspathResource("diagrams/studentLeaveProcess.bpmn")
                .addClasspathResource("diagrams/studentLeaveProcess.png")
                .name("学生请假流程")
                .deploy();
        System.out.println("流程部署ID:" + deployment.getId());
        System.out.println("流程部署Name:" + deployment.getName());*/

        // 启动流程：RuntimeService流程运行服务
        /*ProcessInstance processInstance = processEngine.getRuntimeService()
                .startProcessInstanceByKey("studentLeaveProcess");
        System.out.println("流程实例ID:" + processInstance.getId());
        System.out.println("流程定义ID:" + processInstance.getProcessDefinitionId());*/
        // 根据用户名查询正在运行的任务
        /*List<Task> taskList = processEngine.getTaskService()
                .createTaskQuery()
                .taskAssignee("李四")
                .list();
        for (Task task : taskList) {
            System.out.println("任务ID:" + task.getId());
            System.out.println("任务名称:" + task.getName());
            System.out.println("任务创建时间:" + task.getCreateTime());
            System.out.println("任务委派人:" + task.getAssignee());
            System.out.println("流程实例ID:" + task.getProcessInstanceId());
        }*/
        // 完成任务
        /*processEngine.getTaskService()
                .complete("20002");*/
        // 查询流程实例状态（正在执行或者已经结束）：用流程实例id在运行时表中查询
        //当流程实例结束，则运行时表全部清空
        /*ProcessInstance pi = processEngine.getRuntimeService() // 获取运行时Service
                .createProcessInstanceQuery() // 创建流程实例查询
                .processInstanceId("25001") // 用流程实例id查询
                .singleResult();
        if (pi != null) {
            System.out.println("流程正在执行！");
        } else {
            System.out.println("流程已经执行结束！");
        }*/
        // 历史流程实例任务节点查询：包含历史流程实例的过程
        /*List<HistoricTaskInstance> list = processEngine.getHistoryService() // 历史相关Service
                .createHistoricTaskInstanceQuery() // 创建历史任务实例查询
                .processInstanceId("17501") // 用流程实例id查询
                .finished() // 查询已经完成的任务
                .list();
        for (HistoricTaskInstance hti : list) {
            System.out.println("任务ID:" + hti.getId());
            System.out.println("流程实例ID:" + hti.getProcessInstanceId());
            System.out.println("任务名称：" + hti.getName());
            System.out.println("办理人：" + hti.getAssignee());
            System.out.println("开始时间：" + hti.getStartTime());
            System.out.println("结束时间：" + hti.getEndTime());
            System.out.println("=================================");
        }*/

        // 历史流程实例活动节点查询：包含start和end节点
        List<HistoricActivityInstance> list = processEngine.getHistoryService() // 历史相关Service
                .createHistoricActivityInstanceQuery() // 创建历史活动实例查询
                .processInstanceId("17501") // 执行流程实例id
                .finished()
                .list();
        for (HistoricActivityInstance hai : list) {
            System.out.println("活动ID:" + hai.getId());
            System.out.println("流程实例ID:" + hai.getProcessInstanceId());
            System.out.println("活动名称：" + hai.getActivityName());
            System.out.println("办理人：" + hai.getAssignee());
            System.out.println("开始时间：" + hai.getStartTime());
            System.out.println("结束时间：" + hai.getEndTime());
            System.out.println("=================================");
        }
    }
}
