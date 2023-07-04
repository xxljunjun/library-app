### IDEA新建项目java Enterprise
```js
// 首先电脑里面解压了TOMCAT服务器，IDEA里面集成了TOMCAT

// javaweb项目内可以直接启动

// javaweb三大组件分别是：Servlet 程序、Filter 过滤器、Listener 监听器。

```

### 导入类包
+ 文件上传与下载
```js
//文件上传与下载
commons-fileupload-1.2.1
commons-io-1.4

//mysql
mysql-connector-java-5.1.7-bin

//JavaBean 处理工具类
commons-beanutils-1.8.0

//用于操作数据库的工具包
commons-dbutils-1.3

//记录程序运行时的活动的日志记录
commons-logging-1.1.1

// Druid 是阿里巴巴开源平台上一个数据库连接池实现
druid-1.1.9

//序列化/反序列化
gson-2.2.4

//测试
hamcrest-core-1.3
junit-4.12

//图文验证码
kaptcha-2.3.2

//java标签库的实现
taglibs-standard-impl-1.2.1
taglibs-standard-spec-1.2.1
```

### javaweb的CRUD
```java
// web层  ==> service层 ==>  dao层
dao  //dao层，操作数据库
pojo  //javabean
service  //service层，分发调用
web  //web层，接受参数
utils
test
```

### jdbcUtils  封装连接数据库的方法


### 连接数据库的版本问题：jdbc.properties
```yml
username=root
password=root
url=jdbc:mysql://localhost:3306/book?useUnicode=true&characterEncoding=UTF-8
driverClassName=com.mysql.jdbc.Driver
initialSize=5
maxActive=10
```
