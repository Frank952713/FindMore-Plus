# FindMore-Plus
## 项目介绍
FindMore-Plus是一个校园活动赛事平台，它提供了发布赛事或活动，参加赛事或活动，赛事活动检索，让学生用户足不出户也能全方位了解到校园最新、最全的赛事活动信息服务。本项目是[FindMore](https://gitee.com/weir13/rs) 的二次开发版本。
## 技术选型
  - SpringBoot 
  - Sa-Token
  - ElasticSearch
  - Redis
  - RocketMQ
  - MyBatis-Plus
  - XXL-JOB
  - Swagger+Knife4j
## 项目目录结构
```
├─.idea
├─out
│  └─production
│      └─FindMore-Plus
│          ├─com
│          │  └─findmoreplus
│          │      ├─common
│          │      │  ├─config
│          │      │  ├─enums
│          │      │  ├─exception
│          │      │  └─result
│          │      ├─config
│          │      ├─controller
│          │      ├─dbsubscribe
│          │      ├─domain
│          │      │  ├─bean
│          │      │  ├─bo
│          │      │  └─dto
│          │      ├─mapper
│          │      ├─service
│          │      │  └─impl
│          │      ├─utils
│          │      └─xxljob
│          │          ├─config
│          │          └─jobHandler
│          └─generated
└─src
    └─main
        ├─java
        │  └─com
        │      └─findmoreplus
        │          ├─common
        │          │  ├─enums
        │          │  ├─exception
        │          │  └─result
        │          ├─config
        │          ├─controller
        │          ├─dbsubscribe
        │          ├─domain
        │          │  ├─bean
        │          │  ├─bo
        │          │  └─dto
        │          ├─mapper
        │          ├─service
        │          │  └─impl
        │          ├─utils
        │          └─xxljob
        │              ├─config
        │              └─jobHandler
        └─resources
            ├─mapper
            └─META-INF
```
