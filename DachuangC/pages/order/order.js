import { $wuxPrompt } from '../../dist/components/wux'
const sliderWidth = 96
const app = getApp();
Page({
    data: {
        tabs: ['全部', '待收货', '已完成'],
        activeIndex: '0',
        sliderOffset: 0,
        sliderLeft: 0,
        all_orders: [
        ],
        completed_order: [

        ],
        tocomplete_order: [

        ]
    },
    onLoad() {
        $wuxPrompt.init('msg1', {
            title: '空空如也',
            text: '暂时没有相关数据',
        }).show()

        $wuxPrompt.init('msg2', {
            icon: '../../images/iconfont-order.png',
            title: '您还没有相关的订单',
            text: '可以去看看有哪些想买',
            buttons: [
                {
                    text: '随便逛逛'
                }
            ],
            buttonClicked(index, item) {
                console.log(index, item)
                wx.navigateBack({
                    
                })
            },
        }).show()

        $wuxPrompt.init('msg3', {
            icon: '../../images/iconfont-empty.png',
            title: '暂无待评价订单',
        }).show()

        this.getSystemInfo()

        
    },
    getSystemInfo() {
        const that = this
        wx.getSystemInfo({
            success(res) {
                that.setData({
                    sliderLeft: (res.windowWidth / that.data.tabs.length - sliderWidth) / 2,
                })
            }
        })
    },
    tabClick(e) {
        this.setData({
            sliderOffset: e.currentTarget.offsetLeft,
            activeIndex: e.currentTarget.id,
        })
    },
    onShow() {
        wx.request({
            url: 'http://127.0.0.1:8080/all_order',
            data: {
                // address_id: address_id,
                openid: app.globalData.userInfo.openId,

            },
            method: 'post',
            header: {
                'content-type': 'application/x-www-form-urlencoded' // 默认值
            },
            success: res => {
                console.log(res.data)
                var orders = res.data
                
                for(var index in orders) {
                    orders[index].orderTime = new Date(orders[index].orderTime).toLocaleString()
                    var totals = 0.0
                    for (var jndex in orders[index].order_items) {
                        var tmp = orders[index].order_items[jndex]
                        totals += tmp.counts * tmp.price
                    }
                    orders[index].totals = totals
                    orders[index].status = true
                }
                this.setData({
                    all_orders: orders
                })
                wx.request({
                    url: 'http://127.0.0.1:8080/completed_order',
                    data: {
                        // address_id: address_id,
                        openid: app.globalData.userInfo.openId,

                    },
                    method: 'post',
                    header: {
                        'content-type': 'application/x-www-form-urlencoded' // 默认值
                    },
                    success: res => {
                        console.log(res.data)
                        var completed_orders = res.data
                        var new_orders = []
                        for (var index in orders) {

                            var x = completed_orders.indexOf(orders[index].orderId)
                            
                            if (x>=0){
                                orders[index].status = true
                                new_orders.unshift(orders[index])
                                console.log("inde"+index)
                                
                            }
                        }
                        console.log(new_orders)
                        this.setData({
                            completed_order: new_orders,
                            all_orders: orders
                        })
                        console.log("this.data.completed_order: " + this.data.completed_order)
                    }
                })
                wx.request({
                    url: 'http://127.0.0.1:8080/tocomplete_order',
                    data: {
                        // address_id: address_id,
                        openid: app.globalData.userInfo.openId,

                    },
                    method: 'post',
                    header: {
                        'content-type': 'application/x-www-form-urlencoded' // 默认值
                    },
                    success: res => {
                        console.log(res.data)
                        var tocomplete_orders = res.data
                        var new_orders = []
                        for (var index in orders) {

                            var x = tocomplete_orders.indexOf(orders[index].orderId)
                            if (x >= 0) {
                                orders[index].status = false
                                new_orders.unshift(orders[index])
                                console.log("inde" + index)
                            }
                        }
                        console.log(new_orders)
                        this.setData({
                            tocomplete_order: new_orders,
                            all_orders: orders
                        })
                        console.log("this.data.tocomplete_order: " + this.data.tocomplete_order)
                    }
                })
            }
        })
    },
    goToOrderDetail: function(e) {
        var $index = e.currentTarget.dataset.index
        switch (this.data.activeIndex) {
            case '0':
                wx.navigateTo({
                    url: '/pages/order_detail/order_detail?order=' + JSON.stringify(this.data.all_orders[$index]),
                })
                break
            case '1':
                wx.navigateTo({
                    url: '/pages/order_detail/order_detail?order=' + JSON.stringify(this.data.tocomplete_order[$index]),
                })
                break
            case '2':
                wx.navigateTo({
                    url: '/pages/order_detail/order_detail?order=' + JSON.stringify(this.data.completed_order[$index]),
                })
                break
        }
    }
})