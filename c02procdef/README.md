# activiti5Study procdef
   流程模板(定义)部署：
        重复部署相同流程（流程图的id相同），流程版本会升级(act_re_procdef表的version字段自增1开始)。
        有2种方式
            bmpn+png文件classPath方式
            bmpn+png的压缩文件zip方式
   流程模板(定义)查询：ACT_RE_PROCDEF
        1.查询出来所有流程模板
        2.根据流程模板key查询
        3.根据流程模板id查询
        1-3.还有其他各种条件，条件可以组合
        5.获取某个流程定义的设计图片
        6.查询最新版本流程模板
   流程定义删除：
        删除key（即流程bmpn图中的id）相同的所有流程定义
            1.查询指定key的所有的流程定义
            2.然后再根据流程定义的部署id，级联删除true（会把流程部署和流程定义和流程实例都删除）
            级联影响到了：流程部署表（ACT_RE_DEPLOYMENT）、流程定义表（ACT_RE_PROCDEF）其他相关的表（实例、资源）+历史表中数据都删除了
        也可以删除某一个版本的，查找到指定版本的流程的流程部署id
   流程定义修改：
        不允许直接修改指定版本，可以重新部署，升版本。
   note:
        向数据库传递数据，中文乱码，解决：
            数据库地址后+?useUnicode=true&amp;characterEncoding=UTF-8
      