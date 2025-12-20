# Javaweb入门实现CRM系统





项目结构

```bash
tlias-web-management
├─ pom.xml                          # Maven 构建配置文件，包含项目的依赖和构建配置
├─ target                           # Maven 构建输出目录，存放编译后的文件
│  └─ classes
│     ├─ application.yml            # 应用配置文件，Spring Boot 配置项
│     ├─ logback.xml                # 日志配置文件，配置日志记录方式
│     ├─ static
│     │  └─ upload.html             # 存放静态资源，如 HTML 文件
│     └─ com
│        └─ laiiiii
│           ├─ utils                # 工具类目录
│           ├─ service              # 业务逻辑服务类目录
│           ├─ mapper               # MyBatis 或类似框架的映射类目录
│           ├─ exception            # 异常处理类目录
│           ├─ domain               # 领域模型类目录，通常表示数据库中的实体
│           └─ controller           # 控制器类目录，处理 HTTP 请求
└─ src
   ├─ test
   │  └─ java
   │     └─ com
   │        └─ laiiiii              # 测试代码目录，包含单元测试和集成测试
   └─ main
      ├─ resources
      │  ├─ application.yml         # 应用配置文件
      │  ├─ logback.xml             # 日志配置文件
      │  ├─ static
      │  │  └─ upload.html          # 静态 HTML 页面文件
      │  └─ com
      │     └─ laiiiii
      │        └─ mapper            # MyBatis 映射文件目录
      └─ java
         └─ com
            └─ laiiiii
               ├─ utils             # 工具类文件目录
               ├─ service           # 业务服务类目录
               ├─ mapper            # 数据库映射接口目录
               ├─ exception         # 异常处理类目录
               ├─ domain            # 领域对象类目录
               └─ controller        # 控制器类目录，负责接收和处理用户请求
```

