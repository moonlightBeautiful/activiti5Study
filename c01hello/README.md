# activiti5Study
1.hello
    简介：
        业务流程管理（BPM，也就是工作流）开源项目。
        推荐书籍：activiti实战
    代码实:1：生成25张表（也就是activiti的上下文）
        1.pom引入依赖
            4个依赖： mysql驱动 activiti引擎和模型  activiti与spring整合
        2.数据库
            创建数据库 db_activiti
        3.生成25张表：只有act_ge_property表有数据
            流程引擎配置（2种配置方式，使用xml配置数据库或者在java中设置数据库）
            生成流程引擎
            会在数据库 db_activiti 中生成 activiti 需要的25张表，这25张表就是activiti的运行环境     
        4.25张表简介：
            分为6种类型
                ACT_RE_*: 'RE'表示repository，仓库，包含了流程定义和流程静态资源 （图片，规则，等等）。                                     
                ACT_RU_*: 'RU'表示runtime，运行时，包含流程实例，任务，变量，异步任务，等运行中的数据。 Activiti只在流程实例执行过程中保存这些数据， 在流程结束时就会删除这些记录。 这样运行时表可以一直很小速度很快。                                        
                ACT_ID_*: 'ID'表示identity，身份，包含身份信息，比如用户，组等等。                                        
                ACT_HI_*: 'HI'表示history，历史，包含历史数据，比如历史流程实例， 变量，任务等等。                                       
                ACT_GE_*: 'GE'表示general，通用， 包含资源文件，用在不同的场景下。      
    idea中使用ActiBMPN绘制流程图
        编辑器中安装4activiti辅助插件ActiBMPN
            Activiti BPMN 2.0 designer
            http://activiti.org/designer/update/
            然后选择自动创建流程定义图片当保存实例图的时候
            NOTE：idea使用的时候有时候报错，从起idea，忽略吧，解决不了
        画流程图：bmpn文件（本质上其实是xml文件）
            iagrams	英[ˈdaɪəgræmz] 美[ˈdaɪəˌgræmz]  n.	简图; 图解; 图表; 示意图;
            右键，新建文件，选择BMPN file文件创建，绘制流程图
                必须有开始和结束节点，中间放任务节点，节点与节点中间使用连线。
                任务节点可以指定处理人assignee
        导出png图片：先变成xml文件，再导出png文件
            右击bpmn文件，选择【Refactor】-->【Rename】，修改其扩展名为.xml，点击【Refactor】
            xml文件：
                <process>标签会告诉你流程中使用的全部元素和其属性
                <bpmndi>标签会告诉你流程图中元素的大小、位置等
            接着右击此xml文件，选择【Diagrams】-->【Show BPMN 2.0 Diagrams...】
            打开的界面点击【Export to file】图标，弹出【Save as image】窗口，点击【OK】即可导出png图片
        解决中文乱码问题
            在IDEA的安装目录，在配置文件两个文件中加上-Dfile.encoding=UTF-8
            反正我这里是解决不了乱码问题，所以用英文吧，考，就这样吧
    代码实战2：流程走起来
        1.idea画流程，生成bpmn和png文件
        2.代码跑流程
            1.根据流程配置，获取流程引擎
            2.部署流程模板(也叫做流程定义)
            3.启动流程实例
            4.流程结束(最后一个任务结束)
        3.看数据
            1.生成流程环境：系统配置表
                act_ge_property(系统配置表)：activiti版本信息和下一个流程部署的id
            2.部署流程模板(也叫做流程定义)：通用数据表+仓库表
                通用数据表
                    act_ge_property(系统配置表)：
                        nextdbid：发生了变化，更新了，流程模板id来自于这里
                    act_ge_bytearray(资源文件表):
                        id：自动生成
                        name:资源的路径
                        deployment_id：流程部署表的id
                        byte:图片的二进制
                仓库表
                    act_re_deployment(流程部署表)：
                        id：自动生成，来自于act_ge_property的nextdbid
                        name:流程部署的名称
                        category：类型
                        tenant_id： 租户，这里应该是所属用户
                        deployment_time：部署时间
                    act_re_procdef(流程定义表)：
                        id：自动生成，规律 流程图的id:数字
                        key：流程图的id，在bmp文件中指定
                        name：流程图的名称，在bmp文件中指定
                        version:版本
                        deployment_id：指向流程部署表的id
                        resource_name：bmp文件路径
                        dgrm_resource_name：png文件路径                
            3.启动流程实例： 运行时表+历史表 
                运行时表 
                    act_ru_identitylink(身份联系表)：流程实例涉及到的人                                  
                        id：自动生成
                        type：类型
                        uer_id：用户id，来自bmp文件
                        proc_inst_id：流程实例的id  
                        task_id：任务id，为null
                        proc_def_id：流程定义id，为null  
                    act_ru_task(任务表)：流程实例的所有任务
                        id：自动生成
                        execution_id：执行实例表的id
                        proc_inst_id：流程实例的id
                        proc_def_id：指向流程定义表的id  
                        name：任务名称，来自bmp文件，也就是节点的name
                        task_def_ke：节点的id，来自bmp文件
                        assignee：任务执行人  
                        create_time：任务生成时间
                    act_ru_execution(执行对象表)：工作流程的核心表，执行到哪个节点，哪个节点就是执行对象，并行的话就有多个执行对象                   
                        id：自动生成
                        proc_inst_id：流程实例id，一个流程实例可能有多个执行对象。
                        proc_def_id：指向流程定义表的id
                        act_id：流程运行到的节点的id
                        is_active：激活状态，1激活，0非激活状态。
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
            4.流程结束(最后一个任务结束)：运行时表+历史表 
                1.运行时表数据全部清空
                2.历史表：数据发生了变化
                    act_hi_procinst(流程实例历史表)：增加了结束时间
                    act_hi_actinst(活动节点实例历史表)：增加了任务结束时间和结束节点数据
                    act_hi_taskinst(任务实例历史表)：增加了完成的任务    
        