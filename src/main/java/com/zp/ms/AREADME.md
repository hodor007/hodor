面试复习
一.Java基础
  1.基础知识
  2.数据结构和算法
  3.集合
  4.jvm，类加载
  5.设计模式 
  6.锁，线程
二.数据库
  1.数据库优化
  2.底层实现
  
三、spring

四.缓存  

五.rpc  

六.消息中间件

七.分布式和集群的意义区别和联系 https://blog.csdn.net/ljj_9/article/details/79156255
    集群拥有以下两个特点：
        1.   可扩展性：集群的性能不限制于单一的服务实体，新的服务实体可以动态的添加到集群，从而增强集群的性能。
        2.   高可用性：集群当其中一个节点发生故障时，这台节点上面所运行的应用程序将在另一台节点被自动接管，消除单点故障对于增强数据可用性、可达性和可靠性是非常重要的。
    集群必须拥有以下两大能力：
        1.   负载均衡：负载均衡把任务比较均匀的分布到集群环境下的计算和网络资源，以提高数据吞吐量。
        2.   错误恢复：如果集群中的某一台服务器由于故障或者维护需要无法使用，资源和应用程序将转移到可用的集群节点上。这种由于某个节点的资源不能工作，另一个可用节点中的资源能够透明的接管并继续完成任务的过程，叫做错误恢复。
    分布式是指将不同的业务分布在不同的地方。 而集群指的是将几台服务器集中在一起，实现同一业务。分布式中的每一个节点，都可以做集群。 而集群并不一定就是分布式的。
    
    高并发：
        集群与分布式
        
八、soa和微服务区别 https://zhuanlan.zhihu.com/p/76378370
    1. 微服务去中心化，去掉ESB企业总线。微服务不再强调传统SOA架构里面比较重的ESB企业服务总线，同时SOA的思想进入到单个业务系统内部实现真正的组件化
    2. Docker容器技术的出现，为微服务提供了更便利的条件，比如更小的部署单元，每个服务可以通过类似Node或者Spring Boot等技术跑在自己的进程中。
    3. SOA注重的是系统集成方面，而微服务关注的是完全分离
    
九、稳定性

10、业务中台
    

