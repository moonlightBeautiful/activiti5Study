package com.ims;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * @author gaoxu
 * @date 2019-07-18 10:31
 * @description ... ��
 * 1.
 */
public class App {
    public static void main(String[] args) {
        /**
         * 1.�����������棬���������ļ������25�ű��������ٴ���������������´�����
         * 2.��������ģ��[Ҳ��������]��RepositoryService���ֿ̲���񣩣���ʵ���ǰ�bpmn��png�ļ���Ϣд�뵽�����ݿ����̶�����С�
         * 3.��������ʵ����RuntimeService�������з��񣩣���ʵ���Ǵ�����ģ����ʵ������һ�����������
         * 4.�鿴�û�����TaskService��
         * 5.�����û�����TaskService����Ŀǰֻ�����
         */

        /**
         * 1.���������ļ������������棨���25�ű��������ٴ���������������´�����
         */
        /**
         * ��ʽ1�� ��ʹ�������ļ����ɹ�����������25�ű���
         */
        /*  // ��������
        ProcessEngineConfiguration pec = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
        pec.setJdbcDriver("com.mysql.jdbc.Driver");
        pec.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/db_activiti?useUnicode=true&characterEncoding=UTF-8");
        pec.setJdbcUsername("root");
        pec.setJdbcPassword("root");
        // ����ģʽ��DB_SCHEMA_UPDATE_CREATE_DROP��ɾ�����ٴ������� DB_SCHEMA_UPDATE_TRUE����������ڣ��Զ���������DB_SCHEMA_UPDATE_FALSE�����Զ�����������Ҫ������
        pec.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        // ��ȡ����������󣬲�����25�ű�
        ProcessEngine processEngine = pec.buildProcessEngine();*/
        /**
         * ��ʽ2�� ʹ�������ļ����ɹ�����������25�ű���
         *      1.createProcessEngineConfigurationFromResource
         *      2.buildProcessEngine
         */
        // �������ö�ȡxml����ʽ1,ָ��xml�ļ�
        /*ProcessEngineConfiguration processEngineConfiguration =
                ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        // ��ȡ�����������
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();*/
        // �������ö�ȡxml����ʽ2��Ĭ��xml�ļ�ȫ·����class·���£�����Ĭ��Ϊactiviti.cfg.xml
         ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        /**
         * 2.�������̶���[Ҳ����ģ��]��RepositoryService���ֿ̲���񣩣���ʵ���ǰ�bpmn��png�ļ���Ϣд�뵽�����ݿ����̶�����С�
         */
        /*Deployment deployment = processEngine.getRepositoryService()
                .createDeployment()
                .addClasspathResource("diagrams/Hello.bpmn") //������Դ�ļ�
                .addClasspathResource("diagrams/Hello.png")//������Դ�ļ�
                .name("Hello����")
                .category("���1")
                .deploy();
        System.out.println("�����ǳ�������ģ��������ģ�塣ÿ�β�������ģ�壬��¼��εĲ���");
        System.out.println("����ֻ��¼��һЩ������Ϣ��ͨ���������ֻ�ܻ�ȡһЩ������ϵ���Ϣ��");
        System.out.println("����ID:" + deployment.getId());
        System.out.println("����Name:" + deployment.getName());
        System.out.println("�������:" + deployment.getDeploymentTime());
        System.out.println("����ʱ��:" + deployment.getDeploymentTime());*/

        /**
         * 3. ��������ʵ����RuntimeService�������з��񣩣���ʵ���Ǵ�����ģ����ʵ������һ�����������
         */
        /*ProcessInstance processInstance = processEngine.getRuntimeService()
                .startProcessInstanceByKey("myProcess_1"); //��������ģ��key(����ͼ��id)��������ʵ��
        System.out.println("����ʵ����������ģ��ID:" + processInstance.getProcessDefinitionId());
        System.out.println("����ʵ��ID:" + processInstance.getId());
        System.out.println("����ʵ��name:" + processInstance.getName());*/

        /**
         * 4. �鿴�û�����TaskService����
         */
        /*List<Task> taskList = processEngine.getTaskService()
                .createTaskQuery()
                .processInstanceId("12501")
               .taskAssignee("java1234")
                .list();
        for (Task task : taskList) {
            System.out.println("����ID:" + task.getId());
            System.out.println("��������:" + task.getName());
            System.out.println("���񴴽�ʱ��:" + task.getCreateTime());
            System.out.println("����ί����:" + task.getAssignee());
            System.out.println("����ʵ��ID:" + task.getProcessInstanceId());
        }*/
        /**
         * 4. ����û�����TaskService����
         */
       /*processEngine.getTaskService().complete("12504");*/

    }
}