package com.ims;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 * 流程任务监听器，分配人
 */
public class MyTaskListener implements TaskListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void notify(DelegateTask delegateTask) {
        // TODO Auto-generated method stub
        //单人
        //delegateTask.setAssignee("茜茜");

        //候选人   多人
        delegateTask.addCandidateUser("张三");
        delegateTask.addCandidateUser("李四");
        delegateTask.addCandidateUser("王五");

        //候选组   多人
        delegateTask.addCandidateGroup("");
    }

}
