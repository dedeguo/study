package top.chende.study.es;

import java.io.IOException;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

public class Demo1 {

    public static void main(String[] args) {
        RestHighLevelClient client = new RestHighLevelClient(
            RestClient.builder(
                new HttpHost("192.168.31.254", 9200, "http")
                ));
        try {
            IndexRequest request =new IndexRequest("posts").id("4").source("demo","1999");
            IndexResponse response=client.index(request, RequestOptions.DEFAULT);
            System.out.println(response.toString());
            client.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
