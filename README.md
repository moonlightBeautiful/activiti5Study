# activiti5Study
1.hello
    1.1简介：
        业务流程管理（BPM，也就是工作流）开源项目。
    1.2推荐书籍：activiti实战
    1.3代码实战
        0.用到4个依赖 mysql驱动 activiti引擎和模型  activiti与spring整合
        1.不使用配置文件初始化activiti
        2.不使用配置文件初始化activiti
    1.4activiti自己创建25张表，6种类型
    1.5安装4activiti辅助插件ActiBMPN
        Activiti BPMN 2.0 designer
        http://activiti.org/designer/update/
        然后选择自动创建流程定义图片当保存实例图的时候
        NOTE：idea使用的时候有时候报错，从起idea，忽略吧，解决不了
    1.6跑流程
        代码层次和数据库层次
2.流程定义
3.流程实例
4.流程变量
5.流程控制网关
6.任务分配
    个人任务分配：1.在示例图中写死 2.使用流程变量${流程变量} 3.监听器方式
    
    
    
    
Activiti Designer
是#Activiti#配套的基于Eclipse（等编码工具）的可视化流程设计器，有Activiti团队开发，紧密贴合BPMN2.0规范以及Activiti的扩展元素。除了可视化设计之外，还可以打包流程资源文件（包括bpmn、png、jar）、自动生成流程测试代码（JUnit）。
Activiti Modeler
网页版在线流程设计器。
Activiti Explorer
官方demo，目前把Activiti Modeler整合进来了