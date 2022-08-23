## 一个SpringBoot web mini project
技术：
```
Spring
SpringBoot
SpringMVC
Thymeleaf
SpringSecurity
Mybatis
slf4j
mysql
html
js
```

### 1.整合web相关框架
内置`tomcat`，直接启动服务 

controller中返回对象时直接转变为json

通过`application.properties`或者`application.yml`配置端口、数据库接口。。。

### 2.整合Mybatis
通过`application.yml`配置相应的数据库
### 3.整合Thymeleaf框架
1.通过`Thymeleaf`的视图解析器来进行controller返回index.html页面

2.index.html页面的api与controller的服务绑定

3.在`application.yml`中设置静态数据的位置

### 4.整合spring-security
登录、用户角色、权限管理、csrf、rememberMe
### 5.日志系统
- 日志门面：Slf4j
- 日志实现：log4j、logback、...

SpringBoot使用的是Slf4j作为日志门面，Logback（Logback 是log4j 框架的作者开发的新一代日志框架，它效率更高、能够适应诸多的运行环境，同时天然支持SLF4J）作为日志实现。

使用：在需要打印日志的类上加`@Slf4j`注解，然后在具体的方法里使用:`log.info("xxx")`

配置logback日志系统：
```
logback-spring.xml
```
注：添加这个文件，就会将默认的springboot的日志配置给覆盖掉了

可以自定义:
- 保存日志文件
- 输出某些自定义变量
- 自定义banner
- 输出日志的颜色

### 6.多环境配置
1. 开发环境与生产环境端口以及其他配置：
```
spring.profiles.active=dev
application-dev.yml   # 开发环境
application-prod.yml  # 生产环境
```

2. logback-spring.xml 配置多环境

3. pom.xml配置多环境
- 可以在maven直接切换，比较方便
- 可以配置生产环境只打包生产环境的yml配置，防止开发环境的yml配置泄露


### 7.打包运行
直接maven管理器->`package`:
```
target/s06_springbootweb-0.0.1-SNAPSHOT.jar
```
可以复制到任何位置如：`部署jar/s06_springbootweb-0.0.1-SNAPSHOT.jar`
然后运行：
```
java -jar s06_springbootweb-0.0.1-SNAPSHOT.jar
```

# 运行
### 1.配置maven
maven版本：3.8.1

maven的.m2/settings.xml文件配置阿里源
```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                          https://maven.apache.org/xsd/settings-1.0.0.xsd">
      
      <mirrors>
    	<mirror>  
      		<id>alimaven</id>  
      		<name>aliyun maven</name>  
      		<url>http://maven.aliyun.com/nexus/content/groups/public/</url>  
      		<mirrorOf>central</mirrorOf>          
    	</mirror>  
      </mirrors>
</settings>
```

### 2.配置sql
使用本地mysql打开`study.sql`文件

### 3.运行
[可选] idea-`编辑配置`->`修改选项`->`启动前`->`添加启动前任务`->`启动web浏览器`
中添加：
```
http://localhost:8011/index
```
[可选]maven管理器->配置文件->选择：dev/prod

- dev:端口为8011，直接输出日志，同时产生日志文件
- prod:端口为80，不输出日志，同时产生日志文件

然后直接运行`S06SpringbootwebApplication`就行了
