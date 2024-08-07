package org.example.graalvm.mongodb;

import com.mongodb.WriteConcern;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.domain.EntityScanner;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.core.MongoExceptionTranslator;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.convert.*;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableConfigurationProperties(MultipleMongoProperties.class)
public class MongoConfig {

    private final MultipleMongoProperties mongoProperties;

    public MongoConfig(MultipleMongoProperties mongoProperties) {
        this.mongoProperties = mongoProperties;
    }

    @Bean(name = "liveMongoTemplate")
    public MongoTemplate liveMongoTemplate() {
        MongoDatabaseFactory factory = liveFactory();
        MongoTemplate mongoTemplate = new MongoTemplate(factory);
        mongoTemplate.setWriteConcern(WriteConcern.UNACKNOWLEDGED);
        return mongoTemplate;
    }

    @Bean(name = "liveFactory")
    public MongoDatabaseFactory liveFactory() {
        return new SimpleMongoClientDatabaseFactory(mongoProperties.getLive().getUri());
    }

    @Bean(name = "liveTransactionManager")
    public MongoTransactionManager liveTransactionManager(@Qualifier("liveFactory") MongoDatabaseFactory liveFactory) throws Exception {
        return new MongoTransactionManager(liveFactory);
    }

    @Bean(name = "liveMongoExceptionTranslator")
    public MongoExceptionTranslator liveMongoExceptionTranslator() {
        return new MongoExceptionTranslator();
    }

    @Bean(name = "liveMappingMongoConverter")
    @ConditionalOnMissingBean({MongoConverter.class})
    public MappingMongoConverter liveMappingMongoConverter(@Qualifier("liveFactory") MongoDatabaseFactory factory,
                                                           @Qualifier("liveMongoMappingContext") MongoMappingContext context,
                                                           @Qualifier("customConversions") MongoCustomConversions conversions) {
        DbRefResolver dbRefResolver = new DefaultDbRefResolver(factory);
        MappingMongoConverter mappingConverter = new MappingMongoConverter(dbRefResolver, context);
        mappingConverter.setCustomConversions(conversions);
        return mappingConverter;
    }

    @Bean(name = "liveTransactionTemplate")
    TransactionTemplate liveTransactionTemplate(@Qualifier("liveTransactionManager") PlatformTransactionManager platformTransactionManager) {
        return new TransactionTemplate(platformTransactionManager);
    }

    @Bean(name = "liveMongoMappingContext")
    public MongoMappingContext liveMongoMappingContext(@Qualifier("customConversions") MongoCustomConversions conversions) {
        MongoMappingContext context = new MongoMappingContext();
        context.setSimpleTypeHolder(conversions.getSimpleTypeHolder());
        return context;
    }

    @Bean(name = "customConversions")
    public MongoCustomConversions customConversions() {
        List<Object> converters = new ArrayList<>();
        return new MongoCustomConversions(converters);
    }

}
