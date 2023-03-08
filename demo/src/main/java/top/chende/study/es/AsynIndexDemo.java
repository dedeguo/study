package top.chende.study.es;

import java.io.IOException;
import java.util.logging.Logger;
import org.apache.http.HttpHost;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Cancellable;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

public class AsynIndexDemo {
    public static void main(String[] args) throws IOException, InterruptedException {

       Logger log = Logger.getLogger(AsynIndexDemo.class.getName());

        RestHighLevelClient client = new RestHighLevelClient(
            RestClient.builder(
                new HttpHost("192.168.31.254", 9200, "http")
            ));
        ActionListener listener = new ActionListener<IndexResponse>() {
            @Override
            public void onResponse(IndexResponse indexResponse) {
                log.severe("on response");
                log.info("indexRespon:"+indexResponse.toString());
            }

            @Override
            public void onFailure(Exception e) {
                log.severe(" onFailure");

            }
        };
        IndexRequest request =new IndexRequest("posts").id("3").source("demo","1999");
        Cancellable cancellable = client.indexAsync(request,RequestOptions.DEFAULT,listener);
        Thread.sleep(5*1000);
        client.close();
    }
}
