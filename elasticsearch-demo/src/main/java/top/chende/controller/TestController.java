package top.chende.controller;

import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.GetQuery;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.web.bind.annotation.*;
import top.chende.entity.Person;

@RestController
@RequestMapping("/")
public class TestController {

    private ElasticsearchOperations elasticsearchOperations;

    public TestController(ElasticsearchOperations elasticsearchOperations) {
        this.elasticsearchOperations = elasticsearchOperations;
    }

    @PostMapping("/person")
    public String save(@RequestBody Person person) {

        IndexQuery indexQuery = new IndexQueryBuilder()
                .withId(person.getId().toString())
                .withObject(person)
                .build();
        String documentId = elasticsearchOperations.index(indexQuery, IndexCoordinates.of("person"));
        return documentId;
    }

    @GetMapping("/person/{id}")
    public Person findById(@PathVariable("id")  Long id) {
        Person person = elasticsearchOperations
                .queryForObject(GetQuery.getById(id.toString()), Person.class);
        return person;
    }
}
