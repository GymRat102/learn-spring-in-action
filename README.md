### Chapter 1. Getting started with spring
- Spring的核心是Spring容器，也就是Spring Application Context，它来创建和管理Spring应用的各个部分。这些不同的部分，也就是beans，在Spring容器中被装配在一起共同构成一个完整的应用。
- 装配不同的bean通过依赖注入完成。不需要自己创建和管理不同bean的生命周期，Spring容器作为一个可以依赖注入的应用，能够创建、管理并对bean完成依赖注入。
- 定义Spring如何装配bean可以通过XML文件或者Java代码配置的方式
  - Java代码配置依赖于`@Configuration`和`@Bean`注解
  - 定义好之后就能够自动装配 (automatic configuration) 是通过autowiring和component scanning
  - Springboot出现之后，配置的过程就可以省去，autoconfiguration特性可以推断出如何装配bean，极大地简化了配置代码的书写
- mvnw和mvnw.cmd是Maven的wrapper脚本，让用户可以在没安装maven的情况下通过脚本构建项目
- pom.xml文件中声明将应用构建为一个可执行的Jar文件，即便这是一个web应用，是为了适配Java cloud platform
- <parent>标签中定义的spring-boot-starter-parent提供了常见依赖版本的集中管理，通过声明的Springboot版本统一定义
- Springboot自动提供了test的依赖
- Springboot的starter式依赖不直接包含依赖库，而是打包其他不同的依赖库，这样统一的方式有诸多好处
- `spring-boot-maven-plugin`提供：
  - 程序可以用Maven运行
  - 所有的依赖都在可执行的Jar中
  - 提供了manifest file来声明bootstrap class为可执行Jar文件的main class
- `@SpringBootApplication` is a composite application that combines three other annotations:
  - `@SpringBootConfiguration`
  - `@EnableAutoConfiguration`
  - `@ComponentScan`
- For simple applications, you might find it convenient to configure one or two other components in the bootstrap class, but for most applications, **_you’re better off creating a separate configuration class_** for anything that isn’t autoconfigured.

- `@RunWith` is a JUnit annotation, providing a test runner that guides JUnit in running a test. Think of it as applying a plugin to JUnit to provide custom testing behavior. In this case, JUnit is given **_SpringRunner, a Spring-provided test runner_** that provides for the creation of a Spring application context that the test will run against.
  - SpringRunner is an alias for SpringJUnit4ClassRunner, and was introduced in Spring 4.3 to remove the association with a specific version of JUnit (for example, JUnit 4). And there’s no denying that the alias is easier to read and type.

- `@SpringBootTest` tells JUnit to bootstrap the test with Spring Boot capabilities.

- How that view is implemented depends on a few factors, but because Thymeleaf is in your classpath, you can define that template with Thymeleaf.

  - You may be wondering why you chose Thymeleaf for a template engine. Why not JSP? Why not FreeMarker? Why not one of several other options?

  - The only notable line of code is the one with the <img> tag to display the Taco Cloud logo. It uses a Thymeleaf th:src attribute and an @{...} expression to reference the image with a context-relative path.
  - The template name is derived from the logical view name by prefixing it with /templates/ and postfixing it with .html. The resulting path for the template is /templates/home.html. Therefore, you’ll need to place the template in your project at /src/main/resources/templates/home.html

- `@WebMvcTest`. This is a special test annotation provided by Spring Boot that arranges for the test to run in the context of a Spring MVC application. More specifically, in this case, it arranges for HomeController to be registered in Spring MVC so that you can throw requests against it.

  - `@WebMvcTest` also sets up Spring support for testing Spring MVC.

- If you like, you can flip over to the appendix to read about some of the more common ways to run a Spring Boot application.

- Tomcat is a part of your application!

- When a change is detected, DevTools reloads only the class loader containing your project code and restarts the Spring application context, but leaves the other class loader and the JVM intact. Although subtle, this strategy affords a small reduction in the time it takes to start the application.

- DevTools addresses automatic browser refresh by automatically disabling all template caching. Make as many changes as you want to your templates and know that you’re only a browser refresh away from seeing the results.

- When DevTools is in play, it automatically enables a LiveReload (http://livereload.com/) server along with your application. By itself, the LiveReload server isn’t very useful. But when coupled with a corresponding LiveReload browser plugin, it causes your browser to automatically refresh when changes are made to templates, images, stylesheets, JavaScript, and so on—in fact, almost anything that ends up being served to your browser.

- DevTools will also automatically enable an H2 Console that you can access from your web browser.

- That’s an important benefit of developing with Spring. You can focus on the code that meets the requirements of an application rather than on satisfying the demands of a framework. Although you’ll no doubt need to write some framework-specific code from time to time, it’ll usually be only a small fraction of your codebase. As I said before, Spring (with Spring Boot) can be considered the frameworkless framework.

- In the pom.xml file, you declared a dependency on the Web and Thymeleaf starters. These two dependencies transitively brought in a handful of other dependencies, including
  - Spring’s MVC framework 
  - Embedded Tomcat 
  - Thymeleaf and the Thymeleaf layout dialect
  - It also brought Spring Boot’s autoconfiguration library along for the ride. When the application starts, Spring Boot autoconfiguration detects those libraries and automatically
    - Configures the beans in the Spring application context to enable Spring MVC 
    - Configures the embedded Tomcat server in the Spring application context 
    - Configures a Thymeleaf view resolver for rendering Spring MVC views with Thymeleaf templates 
    - In short, autoconfiguration does all the grunt work, leaving you to focus on writing code that implements your application functionality. That’s a pretty sweet arrangement, if you ask me!

- But in addition to starter dependencies and autoconfiguration, Spring Boot also offers a handful of other useful features:
  - The Actuator provides runtime insight into the inner workings of an application, including metrics, thread dump information, application health, and environment properties available to the application. 
  - Flexible specification of environment properties. 
  - Additional testing support on top of the testing assistance found in the core framework.

- Spring Data provides something quite amazing: the ability to define your application’s data repositories as simple Java interfaces, using a naming convention when defining methods to drive how data is stored and retrieved.
