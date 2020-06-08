package com.ims;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gaoxu
 * @date 2019-07-18 10:31
 * @description 流程变量学习类
 */
public class App {
    public static void main(String[] args) throws IOException {
        /**
         * 获取默认流程引擎实例，会自动读取activiti.cfg.xml文件
         */
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        /**
         * 部署流程======================================================================================
         *      1：bpmn和png文件：
         */
       /*Deployment deployment = processEngine.getRepositoryService()
                .createDeployment()
                .addClasspathResource("diagrams/studentLeaveProcess.bpmn")
                .addClasspathResource("diagrams/studentLeaveProcess.png")
                .name("学生请假流程")
                .deploy();
        System.out.println("流程部署ID:" + deployment.getId());
        System.out.println("流程部署Name:" + deployment.getName());*/

        /**
         * 启动流程：=============================================================================
         */
        /*ProcessInstance processInstance = processEngine.getRuntimeService()
                .startProcessInstanceByKey("studentLeaveProcess");
        System.out.println("流程实例ID:" + processInstance.getId());
        System.out.println("流程定义ID:" + processInstance.getProcessDefinitionId());*/

        /**
         * 查询正在运行的用户任务===============================================================================
         */
        /*List<Task> taskList = processEngine.getTaskService()
                .createTaskQuery()
                .taskAssignee("张三")
                .list();
        for (Task task : taskList) {
            System.out.println("任务ID:" + task.getId());
            System.out.println("任务名称:" + task.getName());
            System.out.println("任务创建时间:" + task.getCreateTime());
            System.out.println("任务委派人:" + task.getAssignee());
            System.out.println("任务执行对象ID:" + task.getExecutionId());
            System.out.println("流程实例ID:" + task.getProcessInstanceId());
            System.out.println("流程模板ID:" + task.getProcessDefinitionId());
            System.out.println("========================================================");
        }*/

        /**
         * 结束正在运行的用户任务=====================================================================
         */
        /*processEngine.getTaskService()
                .complete("57502");*/


//=========================设置流程变量==============================================================================
        /**
         * TaskService给正在运行的流程实例设置全局和局部变量：act_ru_variable
         *      1.一个一个设置
         *      2.一次性设置
         */
        /*TaskService taskService = processEngine.getTaskService(); // 任务服务
        String taskId = "35004";
        taskService.setVariable(taskId, "days", 2);
        taskService.setVariable(taskId, "date", new Date());
        taskService.setVariable(taskId, "reason", "发烧");
        Student student = new Student();
        student.setId(1);
        student.setName("张三");
        taskService.setVariable(taskId, "student", student); // 存序列化对象
        taskService.setVariableLocal(taskId, "localDate", new Date()); //局部流程变量*/
        /*Map<String, Object> variables=new HashMap<String,Object>();
        variables.put("days", 2);
        variables.put("date", new Date());
        variables.put("reason", "发烧");
        variables.put("student", student);
        taskService.setVariables(taskId, variables);*/

        /**
         * TaskService查询正在运行的流程实例的全局和局部变量：act_ru_variable
         *          1.一个一个获取
         *          2.一次性获取
         */
        /*TaskService taskService = processEngine.getTaskService(); // 任务Service
        String taskId = "40002";
        Integer days = (Integer) taskService.getVariable(taskId, "days");
        Date date=(Date) taskService.getVariable(taskId, "date");
        String reason = (String) taskService.getVariable(taskId, "reason");
        Student student = (Student) taskService.getVariable(taskId, "student");
        Date localDate = (Date) taskService.getVariableLocal(taskId, "localDate"); // 局部变量
        System.out.println("请假天数：" + days);
        System.out.println("请假日期：" + date);
        System.out.println("请假日期（局部）：" + localDate);
        System.out.println("请假原因：" + reason);
        System.out.println("请假对象：" + student.getId() + "," + student.getName());*/
        /*TaskService taskService=processEngine.getTaskService(); // 任务Service
        String taskId="32502";
        Map<String,Object> variables=taskService.getVariables(taskId);
        Integer days=(Integer) variables.get("days");
        Date date=(Date) variables.get("date");
        String reason=(String) variables.get("reason");
        Student student=(Student)variables.get("student");
        System.out.println("请假天数："+days);
        System.out.println("请假日期："+date);
        System.out.println("请假原因："+reason);
        System.out.println("请假对象："+student.getId()+","+student.getName());*/

        /**
         * RuntimeService给正在运行的流程实例设置全局和局部变量：act_ru_variable
         *      1.一个一个设置
         *      2.一次性设置
         */
        /*RuntimeService runtimeService = processEngine.getRuntimeService();
        String executionId = "50001";
        runtimeService.setVariable(executionId, "days", 2);
        runtimeService.setVariable(executionId, "date", new Date());
        runtimeService.setVariable(executionId, "reason", "发烧");
        Student student = new Student();
        student.setId(1);
        student.setName("张三");
        runtimeService.setVariable(executionId, "student", student);
        runtimeService.setVariableLocal(executionId, "localDate", new Date()); //局部流程变量*/
        /*RuntimeService runtimeService = processEngine.getRuntimeService();
        String executionId = "45001";
        Map<String, Object> variables=new HashMap<String,Object>();
        Student student = new Student();
        student.setId(1);
        student.setName("张三");
        variables.put("days", 5);
        variables.put("date", new Date());
        variables.put("reason", "发烧");
        variables.put("student", student);
        runtimeService.setVariables(executionId, variables);*/

        /**
         * RuntimeService查询正在运行的流程实例设置全局和局部变量：act_ru_variable
         *      1.一个一个获取
         *      2.一次性获取
         */
        /*RuntimeService runtimeService = processEngine.getRuntimeService();
        String executionId = "50001";
        Integer days = (Integer) runtimeService.getVariable(executionId, "days");
        Date date = (Date) runtimeService.getVariable(executionId, "date");
        String reason = (String) runtimeService.getVariable(executionId, "reason");
        Student student = (Student) runtimeService.getVariable(executionId, "student");
        Date localDate = (Date) runtimeService.getVariableLocal(executionId, "localDate");
        System.out.println("请假天数：" + days);
        System.out.println("请假日期：" + date);
        System.out.println("请假原因：" + reason);
        System.out.println("请假对象：" + student.getId() + "," + student.getName());
        System.out.println("请假日期(局部)：" + localDate);*/
        /*RuntimeService runtimeService = processEngine.getRuntimeService(); // 任务Service
        String executionId = "52501";
        Map<String, Object> variables = runtimeService.getVariables(executionId);
        Integer days = (Integer) variables.get("days");
        Date date = (Date) variables.get("date");
        String reason = (String) variables.get("reason");
        Student student = (Student) variables.get("student");
        System.out.println("请假天数：" + days);
        System.out.println("请假日期：" + date);
        System.out.println("请假原因：" + reason);
        System.out.println("请假对象：" + student.getId() + "," + student.getName());*/

        /**
         * 启动流程时设置流程变量
         */
        /*Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("days", 2);
        variables.put("date", new Date());
        variables.put("reason", "发烧");
        Student student = new Student();
        student.setId(1);
        student.setName("张三");
        variables.put("student", student);
        ProcessInstance processInstance = processEngine.getRuntimeService()
                .startProcessInstanceByKey("studentLeaveProcess", variables);
        System.out.println("流程实例ID:" + processInstance.getId());
        System.out.println("流程定义ID:" + processInstance.getProcessDefinitionId());*/

        /**
         * 结束用户任时设置和修改（重复设置就好了）流程变量
         */
        /*Map<String, Object> variables=new HashMap<String,Object>();
        variables.put("days", 72);
        variables.put("date", new SimpleDateFormat("YYYY-MM-DD").format(new Date()));
        variables.put("reason", "发烧2");
        Student student=new Student();
        student.setId(1);
        student.setName("张三2");
        variables.put("student", student);
        processEngine.getTaskService()
                .complete("57502", variables); */
    }
}
