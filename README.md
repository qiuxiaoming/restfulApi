# restfulApi
use springboot implements restfulApi

## 1.用IDEA搭建SpringBoot  

## 2.添加fastjson依赖  
在pom.xml中添加
```
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
            <version>1.2.35</version>
        </dependency>
```

## 3.写Controller
数据存储在JSONArray中，Controller主要通过JSONArray和JSONObject实现
