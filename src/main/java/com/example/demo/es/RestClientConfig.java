//package com.example.demo.es;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.http.HttpHost;
//import org.elasticsearch.client.RestClient;
//import org.elasticsearch.client.RestHighLevelClient;
//import org.springframework.context.annotation.Configuration;
//
//import java.io.IOException;
//
///**
// * @Create: IntelliJ IDEA.
// * @Author: subtlman_ljx
// * @Date: 2022/08/30/15:51
// * @Description:
// */
//@Configuration
//@Slf4j
//public class RestClientConfig {
//
//    public static RestHighLevelClient restHighLevelClient() {
//        RestHighLevelClient client = new RestHighLevelClient(
//                RestClient.builder(new HttpHost("127.0.0.1", 9200, "http")));
//        //如果是集群
////        RestHighLevelClient client = new RestHighLevelClient(
////                RestClient.builder(new HttpHost("127.0.0.1", 9200, "http")
////                        , new HttpHost("127.0.0.1", 9201, "http")
////                        , new HttpHost("127.0.0.1", 9202, "http")));
//        return client;
//    }
//
//    /**
//     * 关闭es连接
//     *
//     * @param client es客户端
//     * @throws IOException io异常
//     */
//    public static void close(RestHighLevelClient client) {
//        try {
//            client.close();
//        } catch (IOException e) {
//        }
//    }
//}
