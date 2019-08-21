package com.java1234.c06taskassign.sec02multiUserAssign;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class MyTaskListener implements TaskListener {


    private static final long serialVersionUID = 1L;

    @Override
    public void notify(DelegateTask delegateTask) {
        // TODO Auto-generated method stub
        delegateTask.addCandidateUser("张三");
        delegateTask.addCandidateUser("李四");
        delegateTask.addCandidateUser("王五");

    }

}
