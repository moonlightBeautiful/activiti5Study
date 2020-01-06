package com.ims;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

/**
 * @author gaoxu
 * @date 2019-07-18 10:31
 * @description ... 类
 */
public class App {
    public static void main(String[] args) throws IOException {
        /**
         * 流程模板ACT_RE_PROCDEF
         *  1.流程模板(定义)部署：
         *      2种方式，1.bpmn和png方式。2.zip方式。
         *  2.流程模板(定义)查询：
         *      1.查询出来所有流程模板：不加条件就OK
         *      2.根据流程模板key查询
         *      3.根据流程模板id查询
         *      4.还有其他各种条件
         *      5.查询某个流程定义的设计图片
         *      6.查询最新版本流程模板
         *  3.流程模板(定义)删除：一般都是级联删除的
         *      1.删除某个流程模板的所有版本
         *      2.删除某个流程模板的指定版本
         */
        /**
         *  1.流程模板部署：1.bpmn和png方式
         */
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        /*Deployment deployment = processEngine.getRepositoryService()
                .createDeployment()
                .addClasspathResource("diagrams/hello.bpmn")
                .addClasspathResource("diagrams/hello.png")
                .name("Hello流程")
                .deploy();
        System.out.println("流程部署ID:" + deployment.getId());
        System.out.println("流程部署Name:" + deployment.getName());*/
        /**
         *  1.流程模板部署：2.bpmn和png文件的zip文件
         */
       /* InputStream inputStream = App.class // 取得当前class对象
                .getClassLoader() // 获取类加载器
                .getResourceAsStream("diagrams/Hello.zip"); // 获取指定文件资源流
        ZipInputStream zipInputStream = new ZipInputStream(inputStream); // 实例化zip输入流
        Deployment deployment = processEngine.getRepositoryService() // 获取部署相关Service
                .createDeployment() // 创建部署
                .addZipInputStream(zipInputStream) // 添加zip输入流
                .name("HelloWorld流程") // 流程名称
                .deploy(); // 部署
        System.out.println("流程部署ID:" + deployment.getId());
        System.out.println("流程部署Name:" + deployment.getName());*/

        //查询流程定义：查询Key（流程设计图的id）的所有版本的流程定义，返回流程定义集合，对应表 act_re_procdef
        /**
         * 2.流程模板(定义)查询：1.查询出来所有流程模板：不加条件就OK
         */
        /*List<ProcessDefinition> pdList = processEngine.getRepositoryService() // 获取service
                .createProcessDefinitionQuery() // 创建流程定义查询
                .list();  // 返回一个集合
        for (ProcessDefinition pd : pdList) {
            System.out.println("ID_" + pd.getId());
            System.out.println("NAME_" + pd.getName());
            System.out.println("KEY_" + pd.getKey());
            System.out.println("VERSION_" + pd.getVersion());
            System.out.println("===========================================");
        }*/
        /**
         * 2.流程模板(定义)查询 ：2.根据流程模板key查询
         */
       /* String processDefinitionKey = "MyFirstProcess";
        List<ProcessDefinition> pdList = processEngine.getRepositoryService() // 获取service
                .createProcessDefinitionQuery() // 创建流程定义查询
                .processDefinitionKey(processDefinitionKey) // 通过key查询
                .list();  // 返回一个集合
        for (ProcessDefinition pd : pdList) {
            System.out.println("ID_" + pd.getId());
            System.out.println("NAME_" + pd.getName());
            System.out.println("KEY_" + pd.getKey());
            System.out.println("VERSION_" + pd.getVersion());
            System.out.println("=============================================================");
        }*/
        /**
         * 2.流程模板(定义)查询 ：3.根据流程模板id查询
         */
        /*String processDefinitionId = "MyFirstProcess:2:7504";
        ProcessDefinition pd = processEngine.getRepositoryService() // 获取service
                .createProcessDefinitionQuery() // 创建流程定义查询
                .processDefinitionId(processDefinitionId) // 通过id查询
                .singleResult();
        System.out.println("ID_" + pd.getId());
        System.out.println("NAME_" + pd.getName());
        System.out.println("KEY_" + pd.getKey());
        System.out.println("VERSION_" + pd.getVersion());*/


        /**
         * 2.流程模板(定义)查询 ：5.查询某个流程定义的设计图片（先从数据库中找到部署id+资源全路径）
         */
        //根据流程部署id和资源文件名称来查询流程图片
       /* InputStream inputStream = processEngine.getRepositoryService() // 获取sevice
                .getResourceAsStream("2501", "diagrams/hello.png");
        FileUtils.copyInputStreamToFile(inputStream, new File("c:/hello.png"));*/

        /**
         * 2.流程模板(定义)查询 ：6.查询所有的最新版本流程模板
         */
        /*List<ProcessDefinition> listAll = processEngine.getRepositoryService() // 获取service
                .createProcessDefinitionQuery() // 创建流程定义查询
                .orderByProcessDefinitionVersion().asc() // 根据流程定义版本升序
                .list();  // 返回一个集合
        Map<String, ProcessDefinition> map = new LinkedHashMap<String, ProcessDefinition>();
        //key相同会覆盖，按照版本排序，则从老到新版本排序
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
        /**
         * 3.流程模板(定义)删除：1.删除某个流程模板的所有版本（先查询出来所有的流程定义，然后一个一个的删除）
         */
       /* String processDefinitionKey = "helloWorld2";
        List<ProcessDefinition> pdList = processEngine.getRepositoryService() // 获取service
                .createProcessDefinitionQuery() // 创建流程定义查询
                .processDefinitionKey(processDefinitionKey) // 根据key查询
                .list();  // 返回一个集合
        for (ProcessDefinition pd : pdList) {
            processEngine.getRepositoryService()
                    .deleteDeployment(pd.getDeploymentId(), true);
        }*/
        /**
         * 3.流程模板(定义)删除：2.删除某个流程模板的指定版本（先查询出来所有的流程定义，然后找到指定版本删除）
         */
    }
}
