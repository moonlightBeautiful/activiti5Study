# activiti5Study procdef
   流程模板(定义)部署：
        就是把流程模板信息写到数据库中。重复部署相同流程（流程图的id相同），流程版本会升级(act_re_procdef表的version字段)。
        有2种方式
            bmpn+png文件classPath方式
            bmpn+png的压缩文件zip方式
   流程模板(定义)查询：ACT_RE_PROCDEF
        查询Key版本的所有流程定义
        查询指定id的流程定义
        查询某个流程定义的设计图片（先从数据库中找到部署id+资源全路径）：资源表ACT_GE_BYTEARRAY
            ACT_RE_PROCDEF：部署id和资源名称
            ACT_GE_BYTEARRAY：部署id和名称（资源名称）和bytes(资源存放在这里)
            用到commons-io插件
        查询最新版本的全部流程定义：同id下流程的最新版本
            1.查询流程定义，按照版本升序
            2.使用Map筛选掉旧的流程版本：key是流程定义id，不选最新覆盖旧的。
   流程定义删除：
        删除key（即流程bmpn图中的id）相同的所有流程定义
            1.查询指定key的所有的流程定义
            2.然后再根据流程定义的部署id，级联删除true（会把流程部署和流程定义和流程实例都删除）
            级联影响到了：流程部署表（ACT_RE_DEPLOYMENT）、流程定义表（ACT_RE_PROCDEF）其他相关的表（实例、资源）中数据都删除了
        也可以删除某一个版本的，查找到指定版本的流程的流程部署id
   流程定义修改：
        不允许直接修改指定版本，可以重新部署，升版本。
   note:
        向数据库传递数据，中文乱码，解决：
            数据库地址后+?useUnicode=true&amp;characterEncoding=UTF-8
      