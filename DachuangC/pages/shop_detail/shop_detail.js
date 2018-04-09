// pages/shop_detail/shop_detail.js
const app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    actionSheetHidden: true,
    actionSheetItems: ['直接购买', '加入购物车'],
    product_info: {},

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
      console.log(options)
      wx.request({
          url: 'http://127.0.0.1:8080/product_info',
          data: {
              productid: options.productId
          },
          method: 'post',
          header: {
              'content-type': 'application/x-www-form-urlencoded' // 默认值
          },
          success: res => {
              console.log(res.data)
              this.setData({
                  product_info: res.data
              })
          }
      })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
  
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  },
    actionSheetTap: function () {
        this.setData({
            actionSheetHidden: !this.data.actionSheetHidden
        })
    },
    actionSheetChange: function (e) {
        this.setData({
            actionSheetHidden: !this.data.actionSheetHidden
        })
    },
    bindItemTap:function (e) {
        console.log('tap ' + e.currentTarget.dataset.name)
        console.log('tap ' + e.currentTarget.dataset.index)
        switch (e.currentTarget.dataset.index) {
            case 1:
                this.addCart()
                break
            case 0:
                console.log(this.data.product_info)
                // wx.navigateTo({
                //     url: '/pages/payment',
                // })
                wx.navigateTo({
                    url: '../payment/payment?carts=' + JSON.stringify([{ "id": this.data.product_info.productId, title: this.data.product_info.productName, image: this.data.product_info.product_simple_images[0].url, num: 1, price: this.data.product_info.price, selected: true }]),
                })
                this.setData({
                    actionSheetHidden: !this.data.actionSheetHidden
                })
                break
        }
    },
    addCart: function() {
        wx.request({
            url: 'http://127.0.0.1:8080/edit_cart',
            data: {
                openid: app.globalData.userInfo.openId,
                productid: this.data.product_info.productId,
                action: 2,
                counts: 1
            },
            method: 'post',
            header: {
                'content-type': 'application/x-www-form-urlencoded' // 默认值
            },
            success: res => {
                console.log(res.data)
                this.setData({
                    actionSheetHidden: !this.data.actionSheetHidden
                })

                if (res.data.data===-1){
                    wx.showToast({
                        title: '商品已存在',
                    })
                } else{
                    wx.showToast({
                        title: '添加成功',
                    })
                }
            }
        })
    },
})