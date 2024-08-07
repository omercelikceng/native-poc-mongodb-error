package org.example.graalvm.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.SmartLifecycle;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicCrudOperation implements SmartLifecycle {

    @Autowired
    @Qualifier("liveMongoTemplate")
    private MongoTemplate mongoTemplate;

    public void findAllPersonList() {
        mongoTemplate.save(new PersonDocument("Omer", "Celik"));
        List<PersonDocument> personDocumentList = mongoTemplate.findAll(PersonDocument.class);
        System.out.println("Person Document Size : " + personDocumentList.size());
        for (PersonDocument personDocument : personDocumentList) {
            System.out.println("Person : " + personDocument);
        }
    }

    @Override
    public void start() {
        findAllPersonList();
    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public int getPhase() {
        return SmartLifecycle.super.getPhase();
    }
}
