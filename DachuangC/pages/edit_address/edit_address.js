// pages/edit_address/edit_address.js

const app = getApp()
import { $wuxPicker, $wuxPickerCity } from '../../dist/components/wux'
import { $wuxDialog } from '../../dist/components/wux'

Page({

  /**
   * 页面的初始数据
   */
  data: {
          address_id: null,
          user_name: "",
          area: "",
          city: "",
          province: "",
          address_detail: "",
          phone_number: "",
          openid: "",
          url: ""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options)
    console.log(app.globalData)
    this.setData({
        openid: app.globalData.userInfo.openId
    })
    // this.data.address_id = options.address_id
    if (options.address_id==''){
        console.log("新建地址")
        this.setData({
            url: "http://127.0.0.1:8080/add_address"
        })
    } else {
        this.setData({
            url: "http://127.0.0.1:8080/update_address"
        })
        wx.request({
            url: 'http://127.0.0.1:8080/address_detail',
            data: {
                address_id: options.address_id,

            },
            method: 'post',
            header: {
                'content-type': 'application/x-www-form-urlencoded' // 默认值
            },
            success: res => {
                console.log(res.data)
                var address = res.data
                this.setData({
                    address_id: address.address_id,
                    user_name: address.user_name,
                    area: address.area,
                    city: address.city,
                    province: address.province,
                    address_detail: address.address_detail,
                    phone_number: address.phone_number,
                    openid: app.globalData.userInfo.openId
                })
            }
        })
    }
    
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
      var that = this
      $wuxDialog.confirm({
          title: '保存地址',
          content: '你确定要保存地址吗？',
          onConfirm(e) {
              console.log('保存地址')
              that.setData({
                  user_name: that.data.user_name,
                  area: that.data.area,
                  city: that.data.city,
                  province: that.data.province,
                  address_detail: that.data.address_detail,
                  phone_number: that.data.phone_number,
              })
            //   console.log("111" + that.data.address_id)
              wx.request({
                  url: that.data.url,
                  data: that.data,
                  method: 'post',
                  header: {
                      'content-type': 'application/x-www-form-urlencoded' // 默认值
                  },
                  success: res => {
                      console.log(res.data)
                      console.log("保存成功")
                      wx.showToast({
                          title: '保存成功',
                      })
                  }
              })
          },
          onCancel(e) {
              console.log('不保存')
          },
      })
  },
  bindKeyInput1: function(e){
      this.setData({
          user_name: e.detail.value
      })
  },
  bindKeyInput2: function (e) {
      this.setData({
          phone_number: e.detail.value
      })
  },
  bindKeyInput3: function (e) {
      this.setData({
          address_detail: e.detail.value
      })
  }
})