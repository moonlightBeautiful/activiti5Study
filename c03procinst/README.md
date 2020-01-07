# activiti5Study 流程实例
   构建学生请假审批流程
        开始-学生任务-班长任务-班主任任务-结束
   执行对象概念
        工作流程的核心表。执行到哪个节点，哪个节点就是执行对象。
        有多个并行分支可能就有多个执行对象，同一个流程，执行对象id不一样但是流程id一样。
        单分支中，执行对象id和流程实例id是一样的，。
   判断流程实例状态
        
   历史流程实例查询：
        就是把流程模板信息写到数据库中。重复部署相同流程（流程图的id相同），流程版本会升级(act_re_procdef表的version字段)。
        有2种方式
            bmpn+png文件classPath方式
            bmpn+png的压缩文件zip方式
   

   启动流程实例涉及到的表：
       # 执行对象表：工作流程的核心表，流程执行干支，干支上有执行个节点，干支id不变节点会变化，有多个分支可能就有多个执行对象，执行对象id不一样但是流程id一样。
            act_ru_execution
                 ID：自动生成，单分支的话和PROC_INST_ID相同
                 PROC_INST_ID：流程实例ID，一个流程实例可能有多个执行实例。
                 PROC_DEF_ID：指向流程定义表的ID。
                 ACT_ID：流程运行到的节点的ID，也就是执行对象。
                 IS_ACTIVE：激活状态，1激活，0非激活状态。
       # 身份联系执行表：执行对象的身份联系，以前执行过的对象也保留在里面
             act_ru_identitylink
                  ID：自动生成
                  TYPE：类型
                  UER_ID：用户id，来自bmp文件
                  PROC_INST_ID：流程实例的ID
       # 任务执行表
              act_ru_task 
                  ID：自动生成
                  EXECUTION_ID：执行对象表的ID
                  PROC_INST_ID：流程实例的ID
                  PROC_DEF_ID：指向流程定义表的ID  
                  NAME：任务名称，来自bmp文件，也就是节点的NAME
                  TASK_DEF_KE：节点的ID，来自bmp文件
                  SSIGNEE：任务执行人  
                  CREATE_TIME：任务生成时间
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
      