package com.java1234.c06taskassign.sec01assignee;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class MyTaskListener implements TaskListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void notify(DelegateTask delegateTask) {
        // TODO Auto-generated method stub
        delegateTask.setAssignee("茜茜");
    }

}
