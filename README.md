# activiti5Study
总结
    1.获取所有的流程模板
    2.获取流程模板的历史版本
    3.获取流程模板的所有节点
    4.获取所有运行的流程实例、历史流程实例
    5.根据委派用户获取所有运行的流程实例、历史流程实例
    6.根据委派用户获取正在运行的任务节点
        List<Task> taskList = processEngine.getTaskService()
                .createTaskQuery()
                .taskAssignee("java1234")
                .list();
    7.根据流程实例获取正在运行的任务节点
        List<Task> taskList = processEngine.getTaskService()
                .createTaskQuery()
                .processInstanceId("5001")
                .list();
    8.根据活动节点获取委派用户
    
