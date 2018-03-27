// pages/address/address.js
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
              phone: '17721876903',
              detail: '四川大学四川大学四川大学四川大学四川大学四川大学四川大学四川大学四川大学四川大学',
          },
          {
              address_id: '2',
              user_name: '黄智忠',
              phone: '17721876903',
              detail: '四川大学四川大学四川大学四川大学四川大学四川大学四川大学四川大学四川大学四川大学',
          },
          {
              address_id: '3',
              user_name: '黄智忠',
              phone: '17721876903',
              detail: '四川大学四川大学四川大学四川大学四川大学四川大学四川大学四川大学四川大学四川大学',
          },
          {
              address_id: '4',
              user_name: '黄智忠',
              phone: '17721876903',
              detail: '四川大学四川大学四川大学四川大学四川大学四川大学四川大学四川大学四川大学四川大学',
          },
          {
              address_id: '5',
              user_name: '黄智忠',
              phone: '17721876903',
              detail: '四川大学四川大学四川大学四川大学四川大学四川大学四川大学四川大学四川大学四川大学',
          },
          {
              address_id: '6',
              user_name: '黄智忠',
              phone: '17721876903',
              detail: '四川大学四川大学四川大学四川大学四川大学四川大学四川大学四川大学四川大学四川大学',
          }
      ]
  
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  
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
  delete_address: function (e) {
      var that = this
      var $index = e.currentTarget.dataset.index
      $wuxDialog.confirm({
          title: '删除地址',
          content: '是否确认删除地址？',
          onConfirm(e) {
            console.log('删除地址')
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

  }
})