// pages/edit_address/edit_address.js
import { $wuxPicker, $wuxPickerCity } from '../../dist/components/wux'
import { $wuxDialog } from '../../dist/components/wux'

Page({

  /**
   * 页面的初始数据
   */
  data: {
    address_id: null,
    user_name: "黄智忠",
    area: "吉州区",
    city: "吉安",
    province: "江西",
    address_detail: "四川大学江安校区西南门",
    phone_number: "17721876903",
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options)
    this.data.address_id = options.address_id
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
  onTapCity() {
      console.log(this.data)
      $wuxPickerCity.init('city', {
          title: '请选择城市',
          value: [8, 0, 11],
          onChange(p) {
            console.log(p)
            this.setData({
                province: p.value[0],
                city: p.value[1],
                area: p.value[2],
            })
          },
      })
  },
  save_address: function() {
      $wuxDialog.confirm({
          title: '保存地址',
          content: '你确定要保存地址吗？',
          onConfirm(e) {
              console.log('保存地址')
          },
          onCancel(e) {
              console.log('不保存')
          },
      })
  }
})