package top.chende.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "person")
public class Person {
    @Id
    String id;
    String firstname;
    String lastname;
}
