# activiti5Study 流程变量
   流程控制网关的概念：
        连线：
            就是连接节点的线，name属性是备注。
            可以给连线内置表达式，main config 的condition：用el表达式 ${msg=='特殊情况}
        排他网关：exclusiveGateway
            执行到该网关，根据条件只能走一条连接线，不满足条件就走没有设置条件的路线。
        并行网关：成对出现parallelGateway
            多条连接线同时并行执行，当都执行完才可以执行下面的连接线。
            note：会出现1个主干支和对应的几条分干支（并行执行对象）