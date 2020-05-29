# activiti5Study
总结
    1.获取所有的流程模板
    2.获取流程模板的历史版本
    3.获取流程模板的所有节点
    4.获取所有运行的流程实例、历史流程实例
    5.根据委派用户获取所有运行的流程实例、历史流程实例
    6.根据委派用户获取所有活动节点
        List<Task> taskList = processEngine.getTaskService()
                .createTaskQuery()
                .taskAssignee("java1234")
                .list();
    7.根据流程实例获取正在运行的活动节点
        List<Task> taskList = processEngine.getTaskService()
                .createTaskQuery()
                .processInstanceId("5001")
                .list();
    8.根据活动节点获取委派用户
    
    
2.流程定义
3.流程实例
4.流程变量
    简介
    使用TaskService设置和获取流程变量
    局部流程变量
    使用RunningService设置和获取流程变量
    启动流程的时候设置流程变量
    完成任务的时候设置流程变量
5.流程控制网关
6.任务分配
    个人任务分配：1.在示例图中写死 2.使用流程变量${流程变量} 3.监听器方式
