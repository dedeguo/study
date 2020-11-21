package top.chende.mongodb;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class DemoDaoImpl implements DemoDao{

    @Resource
    private MongoTemplate mongoTemplate;
    @Override
    public void saveDemo(DemoEntity demoEntity) {
        mongoTemplate.save(demoEntity);
    }

    @Override
    public void removeDemo(Long id) {

    }

    @Override
    public void update(DemoEntity demoEntity) {

    }

    @Override
    public DemoEntity findDemoEntityById(Long id) {
        Query query=new Query(Criteria.where("id").is(id));
        DemoEntity demoEntity= mongoTemplate.findOne(query,DemoEntity.class);
        return null;
    }

    public List<DemoEntity> textQuery(String text){
        TextQuery textQuery = TextQuery.queryText(new TextCriteria().matchingAny(text)).sortByScore();
        List<DemoEntity> result = mongoTemplate.find(textQuery, DemoEntity.class, "demo_collection");
        return result;
    }
}
