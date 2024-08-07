package org.example.graalvm.mongodb;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.data.mongodb")
public class MultipleMongoProperties {
    private MongoProperties live = new MongoProperties();
    private MongoProperties exercise = new MongoProperties();
    private MongoProperties local = new MongoProperties();
    private MongoProperties training = new MongoProperties();

    public MultipleMongoProperties() {

    }

    public MongoProperties getLive() {
        return live;
    }

    public void setLive(MongoProperties live) {
        this.live = live;
    }

    public MongoProperties getExercise() {
        return exercise;
    }

    public void setExercise(MongoProperties exercise) {
        this.exercise = exercise;
    }

    public MongoProperties getLocal() {
        return local;
    }

    public void setLocal(MongoProperties local) {
        this.local = local;
    }

    public MongoProperties getTraining() {
        return training;
    }

    public void setTraining(MongoProperties training) {
        this.training = training;
    }
}