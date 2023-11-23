# FindMore-Plus
# 项目介绍
FindMore-Plus是一个校园活动赛事平台，它提供了发布赛事或活动，参加赛事或活动，赛事活动检索，让学生用户足不出户也能全方位了解到校园最新、最全的赛事活动信息服务。本项目是[FindMore](https://gitee.com/weir13/rs) 的二次开发版本，FindMore曾获得校级赛事软件设计大赛的第三名。
- 项目内容：
  - 使用Sa-Token进行用户身份验证和权限管理，区分普通学生用户与赛事负责人的权限；
  - 使用Redis+Session存储用户登录信息；使用Redis实现热门赛事排行榜、点赞功能；
  - 通过使用RocketMQ消息队列，将比赛开始前的提醒、结果通知等由消费者异步发送给参与者，确保消息的及时性和准确性，解耦并提升用户体验；
  - 使用基于MyBatis-Plus框架的LambdaQueryWrapper实现对MySQL数据库的灵活查询，配合MyBatis X插件自动生成后端CURD基础代码，减少重复工作；
  - 使用XXL-JOB实现系统定时任务的需求，如活动报名定时开启、活动的截止等；
  - 使用Swagger+Knife4j自动生成  OpenAPI  规范的接口文档，并通过编写 @ApiOperation 等注解补充接口文档，避免了人工编写维护文档的麻烦；
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
