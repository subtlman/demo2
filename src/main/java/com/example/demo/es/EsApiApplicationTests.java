package com.example.demo.es;

import com.example.demo.atools.config.AutoBean;
import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

/**
 * @Create: IntelliJ IDEA.
 * @Author: subtlman_ljx
 * @Date: 2022/08/30/11:35
 * @Description:
 */
@Component
public class EsApiApplicationTests {

//    @Resource
//    private RestHighLevelClient client;
    @Resource
    private ElasticsearchRestTemplate restTemplate;

    private ElasticsearchRestTemplate es;

    @Resource
    public void setJavaMailSender(ElasticsearchRestTemplate es) {
        this.es = es;
    }

//    private ElasticsearchTemplate client1 = AutoBean.getBean(ElasticsearchTemplate.class);;

    //创建索引 client.indices().create
    @Test
    void testCreatedIndex() throws IOException {
        //创建索引请求
//        CreateIndexRequest request = new CreateIndexRequest("caw_index");
//        //客户端执行请求 IndicesClient，请求获得响应
//        CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);
//        System.out.println(createIndexResponse);
    }
    //输出
    //org.elasticsearch.client.indices.CreateIndexResponse@825209df

    //判断索引是否存在 client.indices().exists
    @Test
    void textExistIndex() throws IOException {
//        boolean exists = restTemplate.search("1", User.class);
        final RestHighLevelClient client = RestClientConfig.restHighLevelClient();
        System.out.println("client "+client);
        ElasticsearchRestTemplate es = new ElasticsearchRestTemplate(client);
        System.out.println("es "+es);
        System.out.println(es.exists("1", User.class));



        //client org.elasticsearch.client.RestHighLevelClient@596df867
        //es org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate@7bef452c
    }

    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    public RestHighLevelClient restHighLevelClient;


    @Test
    public void testInsert() {
        List<String> list = new ArrayList<>();
        list.add("teacher");
        list.add("student");
        list.add("admin");
        list.add("leader");
        for (int i = 0; i < 10; i++) {
            int toIndex = new Random(1).nextInt(4);
            SysUser build = SysUser.builder()
                    .password("123456")
                    .username("AI码师")
                    .level(i)
                    .roles(list.subList(0, toIndex))
                    .build();
            sysUserDao.save(build);
        }
        System.out.printf("结束");
    }
    @Test
    public void testFindAll(){
        Iterable<SysUser> all = sysUserDao.findAll();
        all.forEach((sysUser)->{
            System.out.printf(sysUser.getId());
        });
    }


    public final static String ES_COLLECTION_NAME="first";

    @Test
    public void saveDocument() throws IOException {
        //连接数据库
        RestHighLevelClient esClient=RestClientConfig.restHighLevelClient();
        Map<String,Object> jsonMap=new HashMap(2);
        jsonMap.put("name","han");
        jsonMap.put("age","19");
        jsonMap.put("sex","男");
        jsonMap.put("numberId","11XXXXXXX1213x");
        IndexRequest in=new IndexRequest(ES_COLLECTION_NAME).source(jsonMap, XContentType.JSON);
        IndexResponse indexResponse=esClient.index(in, RequestOptions.DEFAULT);
        //用完，之后一定养成关闭数据库的好习惯。
        RestClientConfig.close(esClient);
//        System.out.println(indexResponse);
    }


}
