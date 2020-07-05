## 建议命名规范

* 数据库表名：纯小写字母无连接符号
* 数据库字段名：纯小写字母，连接符号只能用‘_’
  * 例如：user_name
  * 不建议驼峰，因为与mybatis字段映射容易出问题
* java pojo字段名：与数据库一摸一样

## MVC规范

Model

​	Bean：数据模型

​	mapper：model层的业务代码

Service

​	逻辑层，复杂的逻辑卸载这一层，让controller层起交付数据和尽量少处理逻辑

Controller

​	尽量仅传送用户的请求给service，返回数据。不要堆大量逻辑进来

WebSocketController

​	跟controller作用一致

Util

​	一些常用工具放这里面

## githu使用建议

尽量关注上游项目，watch按钮，便于得到项目的邮件通知

## 下面是各个成员的建议

