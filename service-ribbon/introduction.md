* 在service-ribbon中使用断路器,断路打开后,可避免连锁故障,
fallback方法可以直接返回一个固定值
* 此时关闭 service-hi 工程，当我们再访问http://localhost:8764/hi?name=forezp:hi ,forezp,orry,error!; 
这就说明当 service-hi 工程不可用的时候，service-ribbon调用 service-hi的API接口时，会执行快速失败，直接返回一组字符串，而不是等待响应超时，这很好的控制了容器的线程阻塞。
* Hystrix Dashboard (断路器：Hystrix 仪表盘)：基于service-ribbon改造，service-feign改造和这是一样的  
首先在pom.xml引入spring-cloud-starter-hystrix-dashboard的起步依赖