// pages/record/record.js
import { $wuxCalendar } from '../../dist/components/wux'

Page({

  /**
   * 页面的初始数据
   */
  data: {
      date_display: 'none',
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
  select_all_record: function() {
      wx.showToast({
          title: '查看所有记录待开发',
      })
  },
  openCalendar() {
      if (this.birthday) {
          return this.birthday.show()
      }

      this.birthday = $wuxCalendar.init('birthday', {
          value: ['2017-04-15'],
          onChange(p, v, d) {
            //   console.log(p, v, d)
            console.log(d)
            //   this.setData({
            //       birthday: d.join(', ')
            //   })
          }
      })
  },
})