# activiti5Study
简介：
    业务流程管理（BPM，也就是工作流）开源项目。目前有jBPM、activiti等。
    推荐书籍：activiti实战。
    activiti由生成25张表（也就是activiti的上下文）组成。需要jdk1.6+
    官网下载地址：https://www.activiti.org/get-started
helloWorld：
    1.pom引入依赖
        4个依赖： mysql驱动、activiti引擎和模型、activiti与spring整合
    2.数据库
        创建数据库 db_activiti
    3.生成25张表：
        构建流程引擎：会在数据库25张表，是activiti的运行环境。
            1.在java中配置流程引擎
            2.读取xml配置流程引擎  
        初始化的流程环境，只有act_ge_property表有数据。
            next.dbid：不懂
            schema.history：不懂
            schema.version：activiti版本。
    4.25张表简介：分为6种类型
        ACT_GE_*: 'GE'表示general，通用配置。 activiti版本、资源文件等。 
        ACT_RE_*: 'RE'表示repository，仓库。流程部署信息、流程模板信息。                                     
        ACT_RU_*: 'RU'表示runtime，运行时，包含流程实例，任务，变量，异步任务，等运行中的数据。 Activiti只在流程实例执行过程中保存这些数据， 在流程结束时就会删除这些记录。 这样运行时表可以一直很小速度很快。                                        
        ACT_ID_*: 'ID'表示identity，身份，包含身份信息，比如用户，组等等。                                        
        ACT_HI_*: 'HI'表示history，历史，包含历史数据，比如历史流程实例， 变量，任务等等。                                       
         
开发流程辅助工具
    1.Activiti Designer
        是#Activiti#配套的基于Eclipse（等编码工具）的可视化流程设计器，有Activiti团队开发，紧密贴合BPMN2.0规范以及Activiti的扩展元素。
        除了可视化设计之外，还可以打包流程资源文件（包括bpmn、png、jar）、自动生成流程测试代码（JUnit）。 
    2.Activiti Modeler
        网页版（B/S）在线流程设计器。
        5.6版本之后推出新版Activiti Modeler，新版Activiti Modeler基于Signavio，重新命名为：KISBPM，意为：keep it simple。
        在activiti的github上找不到Activiti Modeler了，现在两者合并在一起了，下载Activiti Explorer之后就可以直接使用Activiti Modeler。
    3.Activiti Explorer
        官方demo，把压缩包中提供的activiti-explorer.war部署到Tomcat中即可使用Activiti Modeler。
        5.11版本之后，把Activiti Modeler整合到了Activiti Explorer，可以直接创建、修改模型后部署到流程引擎。
        使用
            1.更改数据库 
                1.activiti-explorer\WEB-INF\lib中添加myslq驱动包
                2.修改activiti-explorer项目中activiti-explorer\WEB-INF\classes的db.properties为：
                    db=mysql
                    jdbc.driver=com.mysql.jdbc.Driver
                    jdbc.url=jdbc:mysql://localhost:3306/db_activiti?serverTimezone=UTC
                    jdbc.username=root
                    jdbc.password=root
                3.修改activiti-custom-context.xml：将dbProperties到最后的注释放开，不做任何修改；
            2.activiti-custom-context.xml注释取消掉 
            3.汉化，部分不完美，用到在学吧
            4.登陆使用
                账号	    密码	    角色
                kermit	kermit	admin
                gonzo	gonzo	manager
                fozzie	fozzie	user
                http://localhost:8080/activiti-explorer/
    4.camunda-modeler
        idea中可视化流程设计器
        官网下载解压，然后idea安装 External Tools里添加外部工具，快捷键ctrl+shift+alt+t调用
25张表详细介绍：
    1.流程图：bpmn和png文件
        camunda-modeler画完，保存为bpmn和png        
    2.跑流程，看表数据
        1.初始化25张表：通用配置表
            通用配置表
                act_ge_property(系统配置表)：
                    schema.version：activiti版本信息
                    schema.history：不知道啥意思
                    next.dbid：下一个id，流程模板id、流程实例id等
        2.部署流程模板(也叫做流程定义)：通用配置表+仓库表，以act_re_deployment(流程模板部署表)为主。
            首先不会法神变化的表：历史表、运行时表、身份表等
            通用配置表
                act_ge_property(系统配置表)：
                    nextdbid：发生了变化，更新了
                act_ge_bytearray(资源文件表):
                    id：下一个主键改变
                    name：资源的路径
                    deployment_id：流程部署表的id
                    byte:图片的二进制
            仓库表
                act_re_deployment(流程模板部署表)：
                    id：来自于act_ge_property(系统配置表)的nextdbid字段的值
                    name:部署名称
                    category：部署类型
                    tenantID：所属用户id
                    deployment_time：部署时间
                act_re_procdef(流程模板表)：
                    id：自动生成
                    key：流程图的id，在bmp文件中指定
                    name：流程图的名称，在bmp文件中指定
                    version:版本，1开始递增。
                    deployment_id：流程模板部署表的id
                    resource_name：bmp文件路径
                    dgrm_resource_name：png文件路径 
        3.启动流程实例：运行时表+历史表，以act_ru_execution(执行对象表)为主。 
            运行时表 
                act_ru_execution(执行对象表)：工作流程的核心表，执行到哪个节点，哪个节点就是执行对象，并行的话就有多个执行对象                   
                    id：自动生成
                    proc_inst_id：流程实例id，一个流程实例可能有多个执行对象。
                    proc_def_id：指向流模板id
                    act_id：流程运行到的任务id
                    is_active：激活状态，1激活，0非激活状态。
                act_ru_task(任务表)：流程实例的所有任务
                    id：自动生成
                    execution_id：执行对象表的id
                    proc_inst_id：流程实例id
                    proc_def_id：流程模板id  
                    name：任务名称，来自bmp文件
                    task_def_ke：任务key，来自bmp文件
                    assignee：任务执行人，来自bmp文件 
                    create_time：任务生成时间
                act_ru_identitylink(身份联系表)：执行对象的身份联系                                 
                    id：自动生成
                    type：类型
                    uer_id：用户id，来自bmp文件
                    proc_inst_id：流程实例的id  
                    task_id：任务id，为null
                    proc_def_id：流程定义id，为null                         
            历史表
                act_hi_procinst(流程实例历史表)：
                    id：自动生成 
                    proc_inst_id：流程实例的id
                    proc_def_id：指向流程定义表的id  
                    start_time：开始时间
                    end_time：结束时间
                    start_act_id：开始节点id
                    end_act_id：结束节点id
                act_hi_actinst(活动节点实例历史表)：所有节点都是活动节点
                    id：自动生成 
                    act_id：节点id，来自bmp文件
                    act_name:节点名称，来自bmp文件
                    act_type:节点类型，来自bmp文件
                    task_id：任务id，如果是任务节点，则有
                    assignee：任务执行人
                    start_time：开始时间
                    end_time：结束时间
                    proc_def_id：指向流程定义表的id
                    proc_inst_id：流程实例的id
                    execution_id：执行对象表的id                    
                act_hi_taskinst(任务实例历史表)：任务完成后才会有数据
                    id：自动生成 
                    proc_def_id：指向流程定义表的id
                    task_def_ke：节点id，来自bmp文件
                    proc_inst_id：流程实例的id
                    execution_id：执行实例表的id
                    name:任务名称，来自bmp文件，也就是节点的name
                    assignee：任务执行人
                    start_time：开始时间
                    end_time：结束时间
                act_hi_identitylink(身份联系历史表 ):
                    id：自动生成 
                    type：类型
                    user_id：用户id，来自bmp文件
                    proc_inst_id：流程实例的id
        4.查看用户任务(也叫活动节点)
            1.根据流程实例id
            2.根据委派人         
        5.完成用户任务(完成最后一个用户任务，流程结束)：运行时表+历史表      
            1.运行时表数据全部清空
            2.历史表：数据发生了变化
                act_hi_procinst(流程实例历史表)：增加了结束时间
                act_hi_actinst(活动节点实例历史表)：增加了任务结束时间和结束节点数据
                act_hi_taskinst(任务实例历史表)：增加了完成的任务  
                  
        