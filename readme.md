# 天喵商城服务端

------

## 项目说明

商城链接 [天喵商城](http://mall.wiblog.cn/)

天喵商城前端页面参见 [这里](https://github.com/weimin96/mallWeb)

天喵商城后台管理页参见 [这里](https://github.com/weimin96/mallAdmin)

基于 Spring4.X + Spring MVC + Mybatis3

- 用户模块

  横向越权、纵向越权、MD5 明文加密、guava 缓存高复用服务响应对象的设计思想和封装

- 分类模块

  递归算法复杂对象排重无限层级树结构设计

- 商品模块

  POJO、BO、VO 抽象模型高效分页及动态排序 FTP 服务对接、富文本上传

- 购物车模块

  商品总价计算复用封装高复用的逻辑方法封装思想解决商业运算丢失精度的坑

- 订单模块

  安全漏洞解决方案订单号生成规则强大的常量、枚举设计

- 收货地址

  同步获取自增主键数据绑定的对象绑定越权问题升级巩固

- 支付模块

  集成支付宝 SDK 二维码生成，扫码支付

------

## 项目结构

├─common	——相关常量、状态码、数据端响应结构体、token 缓存

├─controller	——控制层 负责具体的业务模块流程控制

│ ├─backend	————后台业务

│ └─portal	————前台业务

├─dao	——dao 层 mapper 数据持久化

├─pojo	——数据库表实体类

├─service	——业务层 负责业务模块的逻辑应用设计

│ └─impl	————业务层的接口实现

├─util	——一些工具类

└─vo	——对实体类的再封装

------

## 接口说明

### 前台业务

#### 用户模块

**用户登录** */user/login.do* `post`

```
请求参数
String username, String password
响应结果
{
  "msg": "登录成功",
  "status": 0,
  "data":{
  "id": 1,
  "username": "adminadmin",
  "password": "",
  "email": "admin@admin.com",
  "phone": "13800138000",
  "question": "问题1",
  "answer": "答案1",
  "role": 1,
  "createTime": 1478422605000,
  "updateTime": 1491305256000
  }
}

```

**用户登出** *logout.do* `post`

```
请求参数
无
响应结果
{
	"status": 0
}

```

**用户注册** */user/register.do* `post`

```
请求参数
User user
响应结果
{
  "msg": "注册成功",
  "status": 0
}

```

**获取用户信息** */user/get_user_info.do* `post`

```
请求参数
无
响应结果
{
  "status": 0,
  "data":{
  "id": 1,
  "username": "adminadmin",
  "password": "",
  "email": "admin@admin.com",
  "phone": "13800138000",
  "question": "问题1",
  "answer": "答案1",
  "role": 1,
  "createTime": 1478422605000,
  "updateTime": 1491305256000
  }
}

```

**忘记密码输入问题** */user/forget_get_question.do* `post`

```
请求参数
String username
响应结果
{
  "status": 0,
  "data": "问题"
}

```

**忘记密码输入答案** */user/forget_check_answer.do* `post`

```
请求参数
String username, String question, String answer
响应结果
{
  "msg": "问题的答案正确",
  "status": 1
}

```

#### 产品模块

#### 购物车模块

#### 收货地址模块

#### 订单模块

### 后台业务

#### 用户模块

#### 产品模块

#### 购物车

#### 订单模块