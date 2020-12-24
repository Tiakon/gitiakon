Spring Boot 学习笔记
================


**maven配置的中央仓库阿里云镜像**

`setting.xml`

```
.
.
 <mirrors>
    <mirror>
      <id>alimaven</id>
      <name>aliyun maven</name>
      <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
      <mirrorOf>central</mirrorOf>        
    </mirror>
  </mirrors>
  .
  .
```



**SpringBoot的三种启动方式？**

1. 使用 IDEA 启动
2. 使用 maven 来启动
3. 打成 jar 包使用 java 命令` java -jar `来启动

**注解**

| 属性注解                  | 作用                                                                     |
|:-------------------------|:-------------------------------------------------------------------------|
| @Value                   | 从配置文件中读取单个属性值`@Value("${name}")`                              |
| @Component               | 用于配置bean                                                              |
| @ConfigurationProperties | 把配置文件写到一个类里面并用`configurationProperties(prefix="person")`注解 |

**多环境配置**

`spring.profiles.active`

**Controller的使用**

| 属性注解         | 作用                                                                |
|:----------------|:--------------------------------------------------------------------|
| @Controller     | 处理http的请求(直接使用返回的是视图名),返回值为void会一直报错。        |
| @ResponseBody   | 返回json格式的字符串                                                 |
| @RestController | Spring4之后新加的注解，原来返回json需要`@ResponseBody配合@Controller` |
| @RequestMapping | 用来处理请求地址映射的注解.                                            |

**如何获取参数？**

| 属性注解       | 作用                   |
|:--------------|:-----------------------|
| @PathVariable | 获取URL路径中的数据     |
| @RequestParam | 获取带有？后面参数的值  |
| @GetMapping   | 使用get方法时的组合注解 |


