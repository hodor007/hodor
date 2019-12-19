spring  https://blog.csdn.net/a745233700/article/details/80959716

    aop:
        AOP，一般称为面向切面，作为面向对象的一种补充，用于将那些与业务无关，但却对多个对象产生影响的公共行为和逻辑，抽取并封装为一个可重用的模块，
        这个模块被命名为“切面”（Aspect），减少系统中的重复代码，降低了模块间的耦合度，同时提高了系统的可维护性。可用于权限认证、日志、事务处理。
        AOP实现的关键在于 代理模式，AOP代理主要分为静态代理和动态代理。静态代理的代表为AspectJ；动态代理则以Spring AOP为代表。
        Spring AOP中的动态代理主要有两种方式，JDK动态代理和CGLIB动态代理：
    ioc:
        IOC就是控制反转，是指创建对象的控制权的转移，以前创建对象的主动权和时机是由自己把控的，而现在这种权力转移到Spring容器中，
        并由容器根据配置文件去创建实例和管理各个实例之间的依赖关系，对象与对象之间松散耦合，也利于功能的复用。
    
    Spring容器中的bean可以分为5个范围：
    （1）singleton：默认，每个容器中只有一个bean的实例，单例的模式由BeanFactory自身来维护。
    （2）prototype：为每一个bean请求提供一个实例。
    （3）request：为每一个网络请求创建一个实例，在请求完成以后，bean会失效并被垃圾回收器回收。
    （4）session：与request范围类似，确保每个session中有一个bean的实例，在session过期后，bean会随之失效。
    （5）global-session：全局作用域，global-session和Portlet应用相关。当你的应用部署在Portlet容器中工作时，它包含很多portlet。如果你想要声明让所有的portlet共用全局的存储变量的话，那么这全局变量需要存储在global-session中。全局作用域与Servlet中的session作用域效果相同。
    
    生命周期 https://www.cnblogs.com/wgl-gdyuan/p/9911653.html
     
    
        
    
    