# native-poc-mongodb-error

If you follow the steps below in order, you will encounter the error.
1. mvn clean install
2. mvn spring-boot:build-image -P native
3. docker network create db-network
4. docker run --network=db-network --name mongodb -p 27017:27017 mongo:7.0.13-rc0
5. docker run --network=db-network docker.io/library/native-poc-mongodb-error:0.0.1-SNAPSHOT

Error :

```
2024-08-07T12:48:07.223Z  WARN 1 --- [           main] o.s.c.support.GenericApplicationContext  : Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'basicCrudOperation': Unsatisfied dependency expressed through field 'mongoTemplate': Error creating bean with name 'liveMongoTemplate': Type org.springframework.data.mongodb.core.aggregation.AggregationOperation not present
Application run failed
org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'basicCrudOperation': Unsatisfied dependency expressed through field 'mongoTemplate': Error creating bean with name 'liveMongoTemplate': Type org.springframework.data.mongodb.core.aggregation.AggregationOperation not present
        at org.springframework.beans.factory.aot.AutowiredFieldValueResolver.resolveValue(AutowiredFieldValueResolver.java:194)
        at org.springframework.beans.factory.aot.AutowiredFieldValueResolver.resolveAndSet(AutowiredFieldValueResolver.java:167)
        at org.example.graalvm.mongodb.BasicCrudOperation__Autowiring.apply(BasicCrudOperation__Autowiring.java:17)
        at org.springframework.beans.factory.support.InstanceSupplier$1.get(InstanceSupplier.java:83)
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.obtainInstanceFromSupplier(DefaultListableBeanFactory.java:949)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.obtainFromSupplier(AbstractAutowireCapableBeanFactory.java:1237)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1180)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:562)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:522)
        at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:337)
        at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
        at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:335)
        at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:200)
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:975)
        at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:971)
        at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:625)
        at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:754)
        at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:456)
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:335)
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1363)
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1352)
        at org.example.graalvm.mongodb.GraalVMMongoErrorApplication.main(GraalVMMongoErrorApplication.java:10)
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'liveMongoTemplate': Type org.springframework.data.mongodb.core.aggregation.AggregationOperation not present
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:607)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:522)
        at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:337)
        at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
        at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:335)
        at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:200)
        at org.springframework.beans.factory.config.DependencyDescriptor.resolveCandidate(DependencyDescriptor.java:254)
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1443)
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1353)
        at org.springframework.beans.factory.aot.AutowiredFieldValueResolver.resolveValue(AutowiredFieldValueResolver.java:188)
        ... 21 more
Caused by: java.lang.TypeNotPresentException: Type org.springframework.data.mongodb.core.aggregation.AggregationOperation not present
        at java.base@17.0.10/sun.reflect.generics.factory.CoreReflectionFactory.makeNamedType(CoreReflectionFactory.java:117)
        at java.base@17.0.10/sun.reflect.generics.visitor.Reifier.visitClassTypeSignature(Reifier.java:125)
        at java.base@17.0.10/sun.reflect.generics.tree.ClassTypeSignature.accept(ClassTypeSignature.java:49)
        at java.base@17.0.10/sun.reflect.generics.visitor.Reifier.visitArrayTypeSignature(Reifier.java:159)
        at java.base@17.0.10/sun.reflect.generics.tree.ArrayTypeSignature.accept(ArrayTypeSignature.java:42)
        at java.base@17.0.10/sun.reflect.generics.repository.ConstructorRepository.computeParameterTypes(ConstructorRepository.java:111)
        at java.base@17.0.10/sun.reflect.generics.repository.ConstructorRepository.getParameterTypes(ConstructorRepository.java:87)
        at java.base@17.0.10/java.lang.reflect.Executable.getGenericParameterTypes(Executable.java:298)
        at java.base@17.0.10/java.lang.reflect.Method.getGenericParameterTypes(Method.java:333)
        at org.springframework.core.BridgeMethodResolver.isResolvedTypeMatch(BridgeMethodResolver.java:190)
        at org.springframework.core.BridgeMethodResolver.isBridgeMethodFor(BridgeMethodResolver.java:180)
        at org.springframework.core.BridgeMethodResolver.searchCandidates(BridgeMethodResolver.java:159)
        at org.springframework.core.BridgeMethodResolver.resolveBridgeMethod(BridgeMethodResolver.java:121)
        at org.springframework.core.BridgeMethodResolver.getMostSpecificMethod(BridgeMethodResolver.java:98)
        at org.springframework.aop.support.AopUtils.getMostSpecificMethod(AopUtils.java:209)
        at org.springframework.transaction.interceptor.AbstractFallbackTransactionAttributeSource.computeTransactionAttribute(AbstractFallbackTransactionAttributeSource.java:158)
        at org.springframework.transaction.interceptor.AbstractFallbackTransactionAttributeSource.getTransactionAttribute(AbstractFallbackTransactionAttributeSource.java:111)
        at org.springframework.transaction.interceptor.TransactionAttributeSourcePointcut.matches(TransactionAttributeSourcePointcut.java:56)
        at org.springframework.aop.support.AopUtils.canApply(AopUtils.java:262)
        at org.springframework.aop.support.AopUtils.canApply(AopUtils.java:298)
        at org.springframework.aop.support.AopUtils.findAdvisorsThatCanApply(AopUtils.java:330)
        at org.springframework.aop.framework.autoproxy.AbstractAdvisorAutoProxyCreator.findAdvisorsThatCanApply(AbstractAdvisorAutoProxyCreator.java:136)
        at org.springframework.aop.framework.autoproxy.AbstractAdvisorAutoProxyCreator.findEligibleAdvisors(AbstractAdvisorAutoProxyCreator.java:99)
        at org.springframework.aop.framework.autoproxy.AbstractAdvisorAutoProxyCreator.getAdvicesAndAdvisorsForBean(AbstractAdvisorAutoProxyCreator.java:80)
        at org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator.wrapIfNecessary(AbstractAutoProxyCreator.java:368)
        at org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator.postProcessAfterInitialization(AbstractAutoProxyCreator.java:320)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsAfterInitialization(AbstractAutowireCapableBeanFactory.java:438)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1809)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:600)
        ... 30 more
Caused by: java.lang.ClassNotFoundException: org.springframework.data.mongodb.core.aggregation.AggregationOperation
        at org.graalvm.nativeimage.builder/com.oracle.svm.core.hub.ClassForNameSupport.forName(ClassForNameSupport.java:123)
        at org.graalvm.nativeimage.builder/com.oracle.svm.core.hub.ClassForNameSupport.forName(ClassForNameSupport.java:87)
        at java.base@17.0.10/java.lang.Class.forName(DynamicHub.java:1324)
        at java.base@17.0.10/java.lang.Class.forName(DynamicHub.java:1313)
        at java.base@17.0.10/sun.reflect.generics.factory.CoreReflectionFactory.makeNamedType(CoreReflectionFactory.java:114)
        ... 58 more


```
