# examples-of-spring-hibernate-tutorial
Contains examples of test code based on<sup id="a1">[1](#f1)</sup> https://www.udemy.com/spring-hibernate-tutorial

(*NOTE*) 
- At least Java Development Kit 1.8
- **Different** examples - **Java projects** are located at **different branches**:

### Spring Configuration
#### 01-spring-xml-configuration :
   Starting, project showing how to configure **Spring with a xml file**.
   Dependency Injection is presented with *SupportService* interface as well as shows when
   init-method, destroy-method and Object finalize() are called.

#### 02-spring-annotation-configuration :
   Spring configuration with annotation @Component with @Autowired, @Qualifier("someName") or @Resource(name = "someName").
   One can test order of Injection (Constructor, Field, factory method and setter).

#### 03-spring-java-configuration :
   Spring configuration with Java class annotated @Configuration, loaded with 
   AnnotationConfigApplicationContext(ConfigurationClass.class) in main function.
   One can test order of Injection (Constructor, Field, factory method and setter).
   
### Spring MVC
#### 04-spring-mvc-demo :
   Example of simple MVC web application on embeded Tomcat.
   Forms with validation (also custome one - @StartDate).
   
   To run *launch/Main.java*  ➪  [localhost:8080](http://localhost:8080)

 ### Hibernate
 #### 05-hibernate-crud-programmaticTx
   CRUD with Hibernate with programmatically controlled transactions under JUnit with embedded DB (HSQL, H2 or DERBY).
   
   Also use some of [Mkyong.com](https://www.mkyong.com/spring/spring-embedded-database-examples/)
   
   
___
1. <small id="f1">Additionaly I use maven to download libraries as well as some code variations.  </small> <a id="f1" href="#a1">↺</a>
