# activiti5Study 流程任务分配
个人任务分配：assignee
    1.流程图中写死    图片5
    2.流程图中EL表达式 变量   图片6
        流程启动或任务结束时，为变量赋值用户
    3.流程图中任务节点配置监听器listener    图片7
        自定义类实现TaskListener接口
多人任务分配：候选人candidate Users
    1.流程图中写死    图片1
    2.流程任务EL表达式 变量    图片2
    3.监听器listener   图片3
    note： 
        通过接口可以添加和删除候选人
组任务分配：候选组candidate  Group
    1.流程图中写死      图片8
    2.流程任务变量      图片9
    3.监听器listener
    note：
        1.activiti内置用户分组表：act_id_user、act_id_group、act_id_membership、act_id_info表
            工具类identityService
        小项目用activiti内置的用户组表就可以，大的项目用自己的。
        把任务节点分配给一个组，组内的任意成员可以处理任务节点