# activiti5Study hello
   构建activiti工作流环境，就是在数据库汇中生成25张表和一些数据。
        ACT_RE_*: 'RE'表示repository。  这些仓库的表，包含了流程定义和流程静态资源 （图片，规则，等等）。                                     
        ACT_RU_*: 'RU'表示runtime。 这些运行时的表，包含流程实例，任务，变量，异步任务，等运行中的数据。 Activiti只在流程实例执行过程中保存这些数据， 在流程结束时就会删除这些记录。 这样运行时表可以一直很小速度很快。                                        
        ACT_ID_*: 'ID'表示identity。 这些身份表，包含身份信息，比如用户，组等等。                                        
        ACT_HI_*: 'HI'表示history。 这些历史表，包含历史数据，比如历史流程实例， 变量，任务等等。                                       
        ACT_GE_*: 'GE'表示general。这些通用数据表， 包含资源文件。                                     
        还有一些辅助表。
    画一个流程图
        idea不知道为啥总是包activiBPM插件错误，忽略吧 解决：重启idea
    代码层次走流程图
    数据库表层次流程图
        # 生成流程引擎涉及到的表：
            1个，通用数据相关的表
            # activiti版本信息和流程id生成策略表
                ACT_GE_PROPERTY
                    next.dbid：下一个流程部署的id
                    其他的版本信息
        # 部署流程定义涉及到的表：
            流程部署、通用数据（流程部署或实例启动id生成策略和资源文件）、流程定义相关的表。
            # 系统配置表：发生了变化
                ACT_GE_PROPERTY
                    next.dbid：next.dbid字段发生了变化
            # 流程部署表
                ACT_RE_DEPLOYMENT
                    ID：自动生成，来自于ACT_GE_PROPERTY（系统配置表）
                    NAME:流程部署的名称
            # 流程定义表
                ACT_RE_PROCDEF
                    ID：自动生成
                    KEY：流程图的id，在bmp文件中指定
                    NAME：流程图的名称，在bmp文件中指定
                    DEPLOYMENT_ID：指向流程部署表的ID
                    RESOURCE_NAME：bmp文件路径
                    DGRM_RESOURCE_NAME：png文件路径
            # 资源文件表
                 ACT_GE_BYTEARRAY
                    ID：自动生成
                    NAME:资源的路径
                    DEPLOYMENT_ID：流程部署表的ID
         # 启动流程实例涉及到的表：
            运行时和历史相关的表：ACT_RU_*、ACT_HI_*。            
            # 运行时：
                # 执行对象表：工作流程的核心表，执行到哪个节点，哪个节点就是执行对象，并行的话就有多个执行对象
                    act_ru_execution
                        ID：自动生成
                        PROC_INST_ID：流程实例ID，一个流程实例可能有多个执行实例。
                        PROC_DEF_ID：指向流程定义表的ID
                        ACT_ID：流程运行到的节点的ID
                        IS_ACTIVE：激活状态，1激活，0非激活状态。
                # 任务执行表
                    act_ru_task 
                        ID：自动生成
                        EXECUTION_ID：执行实例表的ID
                        PROC_INST_ID：流程实例的ID
                        PROC_DEF_ID：指向流程定义表的ID  
                        NAME：任务名称，来自bmp文件，也就是节点的NAME
                        TASK_DEF_KE：节点的ID，来自bmp文件
                        ASSIGNEE：任务执行人  
                        CREATE_TIME：任务生成时间
                # 身份联系执行表
                    act_ru_identitylink
                        ID：自动生成
                        TYPE：类型
                        UER_ID：用户id，来自bmp文件
                        PROC_INST_ID：流程实例的ID
            # 历史：  
                # 流程实例历史表
                    act_hi_procinst
                       ID：自动生成 
                       PROC_INST_ID：流程实例的ID
                       PROC_DEF_ID：指向流程定义表的ID  
                       START_TIME：开始时间
                       END_TIME：结束时间
                       START_ACT_ID：开始节点ID
                       END_ACT_ID：结束节点ID
                # 活动节点实例历史表
                    act_hi_actinst
                        ID：自动生成 
                        PROC_DEF_ID：指向流程定义表的ID
                        EXECUTION_ID：执行实例表的ID
                        PROC_INST_ID：流程实例的ID
                        ACT_ID：节点ID，来自bmp文件
                        TASK_ID：任务ID
                        ACT_NAME:节点名称，来自bmp文件
                        ACT_TYPE:节点类型，来自bmp文件
                        ASSIGNEE：任务执行人
                        START_TIME：开始时间
                        END_TIME：结束时间
                # 任务实例历史表 
                    act_hi_taskinst
                        ID：自动生成 
                        PROC_DEF_ID：指向流程定义表的ID
                        TASK_DEF_KE：节点ID，来自bmp文件
                        PROC_INST_ID：流程实例的ID
                        EXECUTION_ID：执行实例表的ID
                        NAME:任务名称，来自bmp文件，也就是节点的NAME
                        ASSIGNEE：任务执行人
                        START_TIME：开始时间
                        END_TIME：结束时间
                # 身份联系历史表 
                    act_hi_identitylink
                        ID：自动生成 
                        TYPE：类型
                        USER_ID：用户ID，来自bmp文件
                        PROC_INST_ID：流程实例的ID
        # 结束流程实例（也就是结束最后一个任务）涉及到的表
            # 运行时相关表：表数据全部清空
            # 历史相关表：表数据修改（增加了结束时间）或者增加了数据（节点实例增加了个结束节点）
        
