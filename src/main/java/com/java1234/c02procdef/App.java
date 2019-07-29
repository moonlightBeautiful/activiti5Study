package com.java1234.c02procdef;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.ProcessDefinition;

import java.io.IOException;
import java.util.List;

/**
 * @author gaoxu
 * @date 2019-07-18 10:31
 * @description ... 类
 */
public class App {
    public static void main(String[] args) throws IOException {
        // 获取默认流程引擎实例，会自动读取activiti.cfg.xml文件
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //RepositoryService流程仓库服务：可以多次部署,升版本。部署完之后，在流程定义表中出现流程模板
        // 部署流程定义方式一，bpmn和png文件：
        /*Deployment deployment = processEngine.getRepositoryService()
                .createDeployment()
                .addClasspathResource("diagrams/Hello.bpmn")
                .addClasspathResource("diagrams/Hello.png")
                .name("Hello流程")
                .deploy();
        System.out.println("流程部署ID:" + deployment.getId());
        System.out.println("流程部署Name:" + deployment.getName());*/
        // 部署流程定义方式二，bpmn和png文件的zip文件：
        /*InputStream inputStream = App.class // 取得当前class对象
                .getClassLoader() // 获取类加载器
                .getResourceAsStream("diagrams/hello.zip"); // 获取指定文件资源流
        ZipInputStream zipInputStream = new ZipInputStream(inputStream); // 实例化zip输入流
        Deployment deployment = processEngine.getRepositoryService() // 获取部署相关Service
                .createDeployment() // 创建部署
                .addZipInputStream(zipInputStream) // 添加zip输入流
                .name("HelloWorld流程") // 流程名称
                .deploy(); // 部署
        System.out.println("流程部署ID:" + deployment.getId());
        System.out.println("流程部署Name:" + deployment.getName());*/

        //查询流程定义：查询Key（流程设计图的id）的所有版本的流程定义，返回流程定义集合，对应表 act_re_procdef
        /*String processDefinitionKey = "MyFirstProcess";
        List<ProcessDefinition> pdList = processEngine.getRepositoryService() // 获取service
                .createProcessDefinitionQuery() // 创建流程定义查询
                .processDefinitionKey(processDefinitionKey) // 通过key查询
                .list();  // 返回一个集合
        for (ProcessDefinition pd : pdList) {
            System.out.println("ID_" + pd.getId());
            System.out.println("NAME_" + pd.getName());
            System.out.println("KEY_" + pd.getKey());
            System.out.println("VERSION_" + pd.getVersion());
            System.out.println("=========");
        }*/

        //查询流程定义：查询ID的某个流程定义,返回流程定义，对应表 act_re_procdef
        /*String processDefinitionId = "MyFirstProcess:2:7504";
        ProcessDefinition pd = processEngine.getRepositoryService() // 获取service
                .createProcessDefinitionQuery() // 创建流程定义查询
                .processDefinitionId(processDefinitionId) // 通过id查询
                .singleResult();
        System.out.println("ID_" + pd.getId());
        System.out.println("NAME_" + pd.getName());
        System.out.println("KEY_" + pd.getKey());
        System.out.println("VERSION_" + pd.getVersion());*/

        //根据流程部署id和资源文件名称来查询流程图片
        /*InputStream inputStream = processEngine.getRepositoryService() // 获取sevice
                .getResourceAsStream("10001", "diagrams/Hello.png");
        FileUtils.copyInputStreamToFile(inputStream, new File("c:/Hello.png"));*/

        // 查询最新版本的流程定义
        /*List<ProcessDefinition> listAll = processEngine.getRepositoryService() // 获取service
                .createProcessDefinitionQuery() // 创建流程定义查询
                .orderByProcessDefinitionVersion().asc() // 根据流程定义版本升序
                .list();  // 返回一个集合
        Map<String, ProcessDefinition> map = new LinkedHashMap<String, ProcessDefinition>();
        for (ProcessDefinition pd : listAll) {
            map.put(pd.getKey(), pd);
        }
        List<ProcessDefinition> pdList = new LinkedList<ProcessDefinition>(map.values());
        for (ProcessDefinition pd : pdList) {
            System.out.println("ID_" + pd.getId());
            System.out.println("NAME_" + pd.getName());
            System.out.println("KEY_" + pd.getKey());
            System.out.println("VERSION_" + pd.getVersion());
            System.out.println("=========");
        }*/

        // 删除所有key相同的流程定义
        String processDefinitionKey = "helloWorld2";
        List<ProcessDefinition> pdList = processEngine.getRepositoryService() // 获取service
                .createProcessDefinitionQuery() // 创建流程定义查询
                .processDefinitionKey(processDefinitionKey) // 根据key查询
                .list();  // 返回一个集合
        for (ProcessDefinition pd : pdList) {
            processEngine.getRepositoryService()
                    .deleteDeployment(pd.getDeploymentId(), true);
        }
    }
}
