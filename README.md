# examples-of-spring-hibernate-tutorial
Contains examples of test code based on<sup id="a1">[1](#f1)</sup> https://www.udemy.com/spring-hibernate-tutorial

(*NOTE*) 
- At least Java Development Kit 1.8
- **Different** examples - **Java projects** are located at **different branches**:


#### spring-xml-configuration :
   Starting, project showing how to configure **Spring with a xml file**.
   Dependency Injection is presented with *SupportService* interface as well as shows when
   init-method, destroy-method and Object finalize() are called.

#### spring-annotation-configuration :
   Spring configuration with annotation @Component with @Autowired, @Qualifier("someName") or @Resource(name = "someName").
   One can test order of Injection (Constructor, Field, factory method and setter).

#### spring-java-configuration :
   Spring configuration with Java class annotated @Configuration, loaded with 
   AnnotationConfigApplicationContext(ConfigurationClass.class) in main function.
   One can test order of Injection (Constructor, Field, factory method and setter).

___
1. <small id="f1"> Additionaly I use maven to download libraries as well as some code variations.  </small> [↩](#a1)
