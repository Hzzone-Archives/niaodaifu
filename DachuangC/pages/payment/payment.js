// pages/payment/payment.js
const app = getApp()

Page({
    data: {
        address: {
            address_id: '111',
            name: "黄智忠",
            phone: "17721876903",
            detail: "四川大学"
        },
        hasAddress: false,
        total: 0,
        orders: [
            { id: 1, title: '新鲜芹菜 半斤', image: 'http://tuchuang-1252747889.cosgz.myqcloud.com/2018-03-23-1.jpg', num: 4, price: 0.01 },
            { id: 2, title: '素米 500g', image: 'http://tuchuang-1252747889.cosgz.myqcloud.com/2018-03-23-1.jpg', num: 1, price: 0.03 }
        ]
    },
    onLoad: function (options) {
        console.log(JSON.parse(options.carts))
        this.setData({
            orders: JSON.parse(options.carts)
        })
    },
    onReady() {
        this.getTotalPrice();
    },

    onShow: function () {
        
    },

    /**
     * 计算总价
     */
    getTotalPrice() {
        let orders = this.data.orders;
        let total = 0;
        for (let i = 0; i < orders.length; i++) {
            total += orders[i].num * orders[i].price;
        }
        this.setData({
            total: total
        })
    },

    toPay() {
        if (!this.data.hasAddress) {
            wx.showModal({
                content: '请选择收获地址',
                showCancel: false,
                success: function (res) {
                    if (res.confirm) {
                        console.log('用户点击确定')
                    }
                }
            });
        } else {
            var that = this
            wx.showModal({
                title: '提示',
                content: '本系统只做演示，支付系统已屏蔽',
                text: 'center',
                success: function (res) {
                    if (res.confirm) {
                        console.log('用户点击确定')
                        wx.request({
                            url: 'http://127.0.0.1:8080/add_order',
                            data: {
                                address_id: that.data.address.address_id,
                                openid: app.globalData.userInfo.openId,
                            },
                            method: 'post',
                            header: {
                                'content-type': 'application/x-www-form-urlencoded' // 默认值
                            },
                            success: res => {
                                console.log(res.data)
                                var order_id = res.data.data
                                var orders = that.data.orders
                                for (var index in orders) {
                                    orders[index].order_id = order_id
                                }
                                console.log(orders)
                                wx.request({
                                    url: 'http://127.0.0.1:8080/add_order_items',
                                    data: JSON.stringify(orders),
                                    method: 'post',
                                    header: {
                                        'content-type': 'application/json' // 默认值
                                    },
                                    success: res => {
                                        console.log(res.data)
                                        for (var index in orders){
                                            wx.request({
                                                url: 'http://127.0.0.1:8080/edit_cart',
                                                data: {
                                                    openid: app.globalData.userInfo.openId,
                                                    productid: orders[index].id,
                                                    action: 0,
                                                    counts: 0,
                                                },
                                                method: 'post',
                                                header: {
                                                    'content-type': 'application/x-www-form-urlencoded' // 默认值
                                                },
                                                success: res => {
                                                    console.log(res.data)

                                                }
                                            })
                                        }
                                        
                                        wx.redirectTo({
                                            url: '/pages/msg_success/msg_success',
                                        })
                                    }
                                })

                            }
                        })
                    } else if (res.cancel) {
                        console.log('用户点击取消')
                    }
                }
            })
        }
        
    }
})