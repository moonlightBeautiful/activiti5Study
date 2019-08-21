# activiti5Study 流程变量
   任务分配：任务节点的处理人分配
        个人任务分配：assignee
            1.流程图中写死
            2.流程任务变量
            3.监听器listener
        多人任务分配：candidateUsers
            1.流程图中写死
            2.流程任务变量
            3.监听器listener
            note： 
                1.通过接口可以添加和删除候选人
                2.assignee字段为空，可以把assignee设置为某个人，就把任务分配某个人了，但一般不会这样处理
        组任务分配：
            内置用户组设计act_id_user group membership info表和identityService
            小项目用activiti内置的用户组表就可以，大的项目用自己的。
            把任务节点分配给一个组，组内的任意成员可以处理任务节点
            1.流程图中写死
            2.流程任务变量
   NOTE：如果流程图出现bug，可以从新画一个流程图。