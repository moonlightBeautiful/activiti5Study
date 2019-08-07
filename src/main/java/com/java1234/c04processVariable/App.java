package com.java1234.c04processVariable;

import com.java1234.c04processVariable.model.Student;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.history.HistoricActivityInstance;
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
         * 部署流程：使用RepositoryService流程仓库服务，重复部署，部署id和定义id和定义的version会变，定义的key不变
         * 两种部署方式：bpmn和png文件方式、bpmn和png文件的压缩文件方式
         */
        // 部署流程方式1：bpmn和png文件：
      /*  Deployment deployment = processEngine.getRepositoryService()
                .createDeployment()
                .addClasspathResource("diagrams/studentLeaveProcess.bpmn")
                .addClasspathResource("diagrams/studentLeaveProcess.png")
                .name("学生请假流程")
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
         * 启动流程：其实就是从流程定义（最新版）中实例化一个流程实例
         */
        /*ProcessInstance processInstance = processEngine.getRuntimeService()
                .startProcessInstanceByKey("studentLeaveProcess");
        System.out.println("流程实例ID:" + processInstance.getId());
        System.out.println("流程定义ID:" + processInstance.getProcessDefinitionId());*/

        /**
         * 启动流程：其实就是从流程定义（最新版）中实例化一个流程实例，启动的时候设置流程变量
         */
        /*Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("days", 2);
        variables.put("date", new Date());
        variables.put("reason", "发烧");
        Student student = new Student();
        student.setId(1);
        student.setName("张三");
        variables.put("student", student);
        ProcessInstance processInstance = processEngine.getRuntimeService() // 运行时Service
                .startProcessInstanceByKey("studentLeaveProcess", variables); // 启动流程的时候，设置流程变量
        System.out.println("流程实例ID:" + processInstance.getId());
        System.out.println("流程定义ID:" + processInstance.getProcessDefinitionId());*/


        /**
         * 根据用户名查询正在运行的流程任务
         */
        /*List<Task> taskList = processEngine.getTaskService()
                .createTaskQuery()
                .taskAssignee("李四")
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
         * TaskService给正在运行的流程任务设置全局和局部变量：act_ru_variable
         */
        /*TaskService taskService = processEngine.getTaskService(); // 任务服务
        String taskId = "25004";
        taskService.setVariable(taskId, "days", 2);
        taskService.setVariableLocal(taskId, "date", new Date()); //局部流程变量
        taskService.setVariable(taskId, "reason", "发烧");
        Student student = new Student();
        student.setId(1);
        student.setName("张三");
        taskService.setVariable(taskId, "student", student); // 存序列化对象*/
        /*Map<String, Object> variables=new HashMap<String,Object>();
        variables.put("days", 2);
        variables.put("date", new Date());
        variables.put("reason", "发烧");
        variables.put("student", student);
        taskService.setVariables(taskId, variables);*/

        /**
         * TaskService查询正在运行的流程任务的全局和局部变量：act_ru_variable，2种方式，11设置和map集中设置
         */
        /*TaskService taskService = processEngine.getTaskService(); // 任务Service
        String taskId = "25004";
        Integer days = (Integer) taskService.getVariable(taskId, "days");
        // Date date=(Date) taskService.getVariable(taskId, "date");
        Date date = (Date) taskService.getVariableLocal(taskId, "date");
        String reason = (String) taskService.getVariable(taskId, "reason");
        Student student = (Student) taskService.getVariable(taskId, "student");
        System.out.println("请假天数：" + days);
        System.out.println("请假日期：" + date);
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
         * RuntimeService给正在运行的流程任务设置全局和局部变量：act_ru_variable
         */
       /* RuntimeService runtimeService = processEngine.getRuntimeService(); // 任务服务
        String executionId = "45001";
        runtimeService.setVariable(executionId, "days", 2);
        runtimeService.setVariableLocal(executionId, "date", new Date()); //局部流程变量
        runtimeService.setVariable(executionId, "reason", "发烧");
        Student student = new Student();
        student.setId(1);
        student.setName("张三");
        runtimeService.setVariable(executionId, "student", student); // 存序列化对象*/
        /*RuntimeService runtimeService = processEngine.getRuntimeService(); // 任务服务
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
         * RuntimeService查询正在运行的流程任务的全局和局部变量：act_ru_variable，2种方式，11设置和map集中设置
         */
        /*RuntimeService runtimeService = processEngine.getRuntimeService(); // 任务Service
        String executionId = "45001";
        Integer days = (Integer) runtimeService.getVariable(executionId, "days");
        // Date date=(Date) taskService.getVariable(taskId, "date");
        Date date = (Date) runtimeService.getVariableLocal(executionId, "date");
        String reason = (String) runtimeService.getVariable(executionId, "reason");
        Student student = (Student) runtimeService.getVariable(executionId, "student");
        System.out.println("请假天数：" + days);
        System.out.println("请假日期：" + date);
        System.out.println("请假原因：" + reason);
        System.out.println("请假对象：" + student.getId() + "," + student.getName());*/
        /*RuntimeService runtimeService = processEngine.getRuntimeService(); // 任务Service
        String executionId = "52501";
        Map<String,Object> variables=runtimeService.getVariables(executionId);
        Integer days=(Integer) variables.get("days");
        Date date=(Date) variables.get("date");
        String reason=(String) variables.get("reason");
        Student student=(Student)variables.get("student");
        System.out.println("请假天数："+days);
        System.out.println("请假日期："+date);
        System.out.println("请假原因："+reason);
        System.out.println("请假对象："+student.getId()+","+student.getName());*/

        /**
         * 结束正在运行的流程任务
         */
        /*processEngine.getTaskService()
                .complete("52510");*/

        /**
         * 结束正在运行的流程任务，同时设置和修改（重复设置就好了）流程变量
         */
        /*Map<String, Object> variables=new HashMap<String,Object>();
        variables.put("days", 72);
        variables.put("date", new SimpleDateFormat("YYYY-MM-DD").format(new Date()));
        variables.put("reason", "发烧2");
        Student student=new Student();
        student.setId(1);
        student.setName("张三2");
        variables.put("student", student);
        processEngine.getTaskService() // 任务相关Service
                .complete("57502", variables); //完成任务的时候，设置流程变量*/

        /**
         *  历史流程实例节点查询：包含start和end节点
         */

        List<HistoricActivityInstance> list = processEngine.getHistoryService() // 历史相关Service
                .createHistoricActivityInstanceQuery() // 创建历史活动实例查询
                .list();
                /*.processInstanceId("17501") // 执行流程实例id
                .finished()
                .list();*/
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
