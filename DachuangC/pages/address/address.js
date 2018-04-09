// pages/address/address.js
const app = getApp()
import { $wuxDialog } from '../../dist/components/wux'
Page({

  /**
   * 页面的初始数据
   */
  data: {
      items: [
          {
              address_id: '1111',
              user_name: '黄智忠',
              phone_number: '17721876903',
              address_detail: '四川大学四川大学四川大学四川大学四川大学四川大学四川大学四川大学四川大学四川大学',
              province: '四川省',
              city: '成都市',
              area: '双流县',
              openid: 'oVL684iOhwDmAR70giu2EgCjBWrE'
          },
      ]
  
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
      console.log(app.globalData)
      
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
      wx.request({
          url: 'http://127.0.0.1:8080/address',
          data: {
              openid: app.globalData.userInfo.openId,
              //   openid: ''

          },
          method: 'post',
          header: {
              'content-type': 'application/x-www-form-urlencoded' // 默认值
          },
          success: res => {
              console.log(res.data)
              this.setData({
                  items: res.data,
              })
          }
      })
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
  delete_address: function (e) {
      var that = this
      var $index = e.currentTarget.dataset.index
      $wuxDialog.confirm({
          title: '删除地址',
          content: '是否确认删除地址？',
          onConfirm(e) {
            console.log('删除地址')
            var address_id = that.data.items[$index].address_id
            wx.request({
                url: 'http://127.0.0.1:8080/delete_address',
                data: {
                    address_id: address_id,
                    //   openid: ''

                },
                method: 'post',
                header: {
                    'content-type': 'application/x-www-form-urlencoded' // 默认值
                },
                success: res => {
                    console.log(res.data)
                }
            })
            that.data.items.splice($index, 1)
            // console.log(that.data)
            // console.log()
            that.setData({
                items: that.data.items
            })
          },
          onCancel(e) {
              console.log('取消删除')
          },
      })

      console.log(this.data.items.length)

  },
  chooseAddress(e) {
      const index = e.currentTarget.dataset.index
      var pages = getCurrentPages()
      var currPage = pages[pages.length - 1]
      var prevPage = pages[pages.length - 2]
      var address = this.data.items[index]
      prevPage.setData({
          address: {
              address_id: address.address_id,
              name: address.user_name,
              phone: address.phone_number,
              detail: address.province + address.city + address.area + address.address_detail
          },
          hasAddress: true,
      })
      wx.navigateBack();
  }
})