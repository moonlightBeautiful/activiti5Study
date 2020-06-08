import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricProcessInstanceQuery;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.io.IOException;
import java.util.List;

/**
 * @author gaoxu
 * @date 2019-07-18 10:31
 * @description ... 类
 */
public class App {
    public static void main(String[] args) throws IOException {
        /**
         * 流程实例
         *  1.流程模板(定义)部署：
         *      Activiti Explorer部署
         *  2.启动流程实例：
         *      1.通过key，默认启动最新版本
         *      2.通过id
         *  3.查询任务
         *      0.查询全部任务
         *      1.通过执行人查询
         *      2.通过流程id查询
         *      3.混合方式查询
         *  4.完成任务
         *      1.通过任务id
         *  5.查询流程状态   查询运行时流程实例表
         *      2种状态：1.正在执行 2.执行完了
         *     1.查询所有正在运行的流程实例
         *     2.查询指定流程实例是否完成
         *  6.历史流程实例查询
         *  7.历史任务查询  历史任务实例表
         *      已经完成的 或者 未完成的
         *  8.历史活动查询 历史活动实例表
         *      已经完成的 或者 未完成的
         */

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        /**
         *  1.流程模板(定义)部署：================================================================================
         *       Activiti Explorer乱码，只能手动部署 哎
         */
       /* Deployment deployment = processEngine.getRepositoryService()
            .createDeployment()
            .addClasspathResource("diagrams/StudentLeaveProcess.bpmn")
            .addClasspathResource("diagrams/StudentLeaveProcess.png")
            .name("学生请假流程部署")
            .deploy();
        System.out.println("流程部署ID:" + deployment.getId());
        System.out.println("流程部署Name:" + deployment.getName());*/

        /**
         *  2.启动流程实例：通过key，默认启动最新版本=================================================================
         */
       /* ProcessInstance processInstance = processEngine.getRuntimeService()
                .startProcessInstanceByKey("studentLeaveProcess");
        System.out.println("流程模板bpmn文件的ID:" + processInstance.getProcessDefinitionKey());
        System.out.println("流程模板ID:" + processInstance.getProcessDefinitionId());
        System.out.println("流程实例ID:" + processInstance.getId());*/

        /**
         *  3.查询流程实例正在执行的任务==========================================================================
         *      0.全部任务
         *      1.通过执行人查询
         *      2.通过流程id查询
         *      3.混合方式查询
         */
        /*List<Task> taskList = processEngine.getTaskService()
                .createTaskQuery()
                .taskCandidateOrAssigned("王五")
                .list();
        for (Task task : taskList) {
            System.out.println("任务ID:" + task.getId());
            System.out.println("任务名称:" + task.getName());
            System.out.println("任务创建时间:" + task.getCreateTime());
            System.out.println("任务委派人:" + task.getAssignee());
            System.out.println("流程实例ID:" + task.getProcessInstanceId());
            System.out.println("====================================================================");
        }*/
        /**
         *  4.完成任务
         *      1.通过任务id
         */
        /* processEngine.getTaskService().complete("27502");*/

        /**
         *  5.查询流程状态：2种状态：1.正在执行 2.执行完了。查询运行时流程实例表，=========================================
         *      1.查询所有正在运行的流程实例
         *      2.查询指定流程实例是否完成
         */
        /**
         *      1.查询所有正在运行的流程实例
         */
       /* List<ProcessInstance> processInstances = processEngine.getRuntimeService() // 获取运行时Service
                .createProcessInstanceQuery()
                .list(); // 创建流程实例查询
        for(ProcessInstance processInstance : processInstances){
            System.out.println("正在执行的流程实例！"+processInstance.getProcessInstanceId());
        }*/
        /**
         *      2.查询指定流程实例是否完成
         */
        /*ProcessInstance pi = processEngine.getRuntimeService() // 获取运行时Service
                .createProcessInstanceQuery() // 创建流程实例查询
                .processInstanceId("25001") // 用流程实例id查询
                .singleResult();
        if (pi != null) {
            System.out.println("流程正在执行！");
        } else {
            System.out.println("流程已经执行结束！");
        }*/

        /**
         * 6.历史流程实例查询   =============================================================================
         *      1.已完成的
         *      2.未完成的
         */
        /*List<HistoricProcessInstance> list = processEngine.getHistoryService() // 历史相关Service
                .createHistoricProcessInstanceQuery()
                .finished() // 查询已经完成的任务  unfinished()  //未完成的
                .list();
        for (HistoricProcessInstance hpi : list) {
            System.out.println("流程实例ID:" + hpi.getId());
            System.out.println("流程实例名称：" + hpi.getName());
            System.out.println("流程实例开始时间：" + hpi.getStartTime());
            System.out.println("流程实例结束时间：" + hpi.getEndTime());
            System.out.println("==============================================");
        }*/

        /**
         * 7.历史任务查询   ==============================================================================
         *      已完成的 或者 未完成的
         */
         /*List<HistoricTaskInstance> list = processEngine.getHistoryService() // 历史相关Service
                .createHistoricTaskInstanceQuery() // 创建历史任务实例查询
                //.processInstanceId("17501") // 用流程实例id查询
                .finished() // 查询已经完成的任务  unfinished()  //未完成的
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

        /**
         *  8.历史活动查询 历史活动实例表 包含start和end节点===================================================
         *      已完成的 或者 未完成的
         */
        /*List<HistoricActivityInstance> list = processEngine.getHistoryService() // 历史相关Service
                .createHistoricActivityInstanceQuery() // 创建历史活动实例查询
                //.processInstanceId("17501") // 执行流程实例id
                .finished()     // 查询已经完成的任务  unfinished()  //未完成的
                .list();
        for (HistoricActivityInstance hai : list) {
            System.out.println("活动ID:" + hai.getId());
            System.out.println("流程实例ID:" + hai.getProcessInstanceId());
            System.out.println("活动名称：" + hai.getActivityName());
            System.out.println("办理人：" + hai.getAssignee());
            System.out.println("开始时间：" + hai.getStartTime());
            System.out.println("结束时间：" + hai.getEndTime());
            System.out.println("=================================");
        }*/

    }
}
