### 技术背景
* 基于微信小程序开发
* Spring Boot开发框架
* Mybatis持久层框架
* Postgresql

### 完成的功能
* 在线商城（收货、付款、地址、订单、搜索…）
* 患者讨论区（发布、回复、删除…）
* 医生和患者的沟通（在线微信聊天）
* 分析仪分析与传输数据
* 数据记录、分析、图标展示


### demo
![](demo/demo.gif)

* doLogin
打开小程序时注册用户，已存在：返回用户个人信息，不存在插入数据库


* cart_detail
`@RequestParam("openid")`，传入openid，返回对应用户的购物车列表
```
[
    {
        "openId": "oVL684iOhwDmAR70giu2EgCjBWrE",
        "productId": "aaaa",
        "counts": 1,
        "product_name": "aaaa",
        "simple_img_url": "askjxnxajksd",
        "price": 10
    }
]
```

* all_product
所有产品
```json
[
    {
        "productId": "aaaa",
        "productName": "aaaa",
        "price": 10,
        "product_intro_images": [
            {
                "productId": "aaaa",
                "url": "asxas"
            },
            {
                "productId": "aaaa",
                "url": "qwkxs"
            }
        ],
        "product_simple_images": [
            {
                "productId": "aaaa",
                "url": "askjxnxajksd"
            }
        ]
    }
]
```
* hot_product
所有热门产品
```json
[
    {
        "productId": "aaaa",
        "productName": "aaaa",
        "price": 10,
        "product_intro_images": [
            {
                "productId": "aaaa",
                "url": "asxas"
            },
            {
                "productId": "aaaa",
                "url": "qwkxs"
            }
        ],
        "product_simple_images": [
            {
                "productId": "aaaa",
                "url": "askjxnxajksd"
            }
        ]
    }
]
```

* new_product
所有新产品

```json
[
    {
        "productId": "aaaa",
        "productName": "aaaa",
        "price": 10,
        "product_intro_images": [
            {
                "productId": "aaaa",
                "url": "asxas"
            },
            {
                "productId": "aaaa",
                "url": "qwkxs"
            }
        ],
        "product_simple_images": [
            {
                "productId": "aaaa",
                "url": "askjxnxajksd"
            }
        ]
    }
]
```

* product_info

`@RequestParam("productid")`
产品详细信息
```json
{
    "productId": "aaaa",
    "productName": "aaaa",
    "price": 10,
    "product_intro_images": [
        {
            "productId": "aaaa",
            "url": "asxas"
        },
        {
            "productId": "aaaa",
            "url": "qwkxs"
        }
    ],
    "product_simple_images": [
        {
            "productId": "aaaa",
            "url": "askjxnxajksd"
        }
    ]
}
```

* edit_cart
```java
@RequestParam("openid") String openid, @RequestParam("productid") String productid, @RequestParam("action") Integer action, @RequestParam("counts") Integer counts```
修改购物车数量和删除购物车
