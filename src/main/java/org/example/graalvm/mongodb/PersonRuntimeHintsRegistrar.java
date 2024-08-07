//package org.example.graalvm.mongodb;
//
//import org.springframework.aot.hint.RuntimeHints;
//import org.springframework.aot.hint.RuntimeHintsRegistrar;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.ImportRuntimeHints;
//import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
//
//@ImportRuntimeHints(PersonRuntimeHintsRegistrar.BindingRuntimeHints.class)
//@Configuration
//public class PersonRuntimeHintsRegistrar {
//    static class BindingRuntimeHints implements RuntimeHintsRegistrar {
//        @Override
//        public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
//            hints.reflection().registerType(AggregationOperation.class);
//        }
//    }
//}
