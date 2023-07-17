# demo

#### 1、git项目到本地

#### 2、 开发环境配置
编辑src/main/resources目录下的中application.yml 文件。修改对应数据库url，username，password
默认是dev环境，可以配置多个环境的数据库。


#### 3、 启动及验证
启动SwakBootApplication.java 出现如下图表示启动成功

打开浏览器，输入：http://localhost:8010/api/system/user/list
```json
{
    "code": 0,
    "msg": "请求成功~",
    "data": {
        "list": [
            {
                "deptId": 103,
                "loginName": "admin",
                "userName": "swak",
                "userType": "00",
                "email": "swak@swak.com",
                "phone": "15888888888",
                "sex": "1",
                "avatar": ""
            }
        ],
        "page": {
            "currentPage": 1,
            "pageSize": 10,
            "totalSize": 1,
            "orders": [],
            "totalPage": 1,
            "offset": 0
        }
    },
    "success": true
}
```

#### 
开发时严格遵守gitflow的流程，gitflow可以参照下用链接：
https://www.jianshu.com/p/41910dc6ef29