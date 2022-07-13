小米
redis哪里处理hash槽映射
短链长链 zset结构  多路复用原理netty的优势（0拷贝，多路复用）
hash槽会消失吗，节点挂了 
spring-boot内置tomcat加载原理  https://blog.csdn.net/weixin_38937840/article/details/107773717
https://blog.csdn.net/qq_45366515/article/details/108288634
可重复读能完全解决幻读吗  https://www.cnblogs.com/liyus/p/10556563.html

联调研究院
分组取排名前几
分库分表需要解决的问题 https://blog.csdn.net/samyang1/article/details/80517711
分布式锁有哪些 https://www.php.cn/faq/466231.html
es写和删的原理，为啥是准实时？    检索原理：倒排索引 https://blog.csdn.net/qq_36535538/article/details/108294635

hashmap扩容 https://www.cnblogs.com/dretrtg/p/12654630.html

麦当劳
sychornized锁原理和优化
1.8升级了什么 hashMap红黑树的目的是啥  https://cloud.tencent.com/developer/article/1571903  
 提高查询效率
 扩容后，元素要么是在原位置，要么是在原位置再移动2次幂的位置，且链表顺序不变，不需要重新计算hash，只需要根据原来hash值新增的bit是1还是0分别放进两个链表lo和hi（非红黑树的情况）里，0的话索引没变，1的话索引变为原索引加原来的数组长度。
                                        因为用的尾插法所以新数组链表不会倒置
                                        
高并发怎么设计 http://t.zoukankan.com/yaopengfei-p-12418229.html   限流、降级、缓存（预加载、watch、lua），消息队列削峰，类似限流，也解耦，消费方按照自己系统的处理能力去队列拉取消费数据                                      
springCloud：提供快速构建分布式系统的一些工具，服务发现注册、配置中心、网关、负载均衡、降级限流                              
 
延迟队列原理
https://www.cnblogs.com/zby9527/p/13359812.html
current包下有哪些类 为什么阿里不建议创建线程池的方法
netty拆包粘包怎么做的
pigeon、dubbo区别
