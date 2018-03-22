//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
  },
  onLoad: function () {
    if (app.globalData.userInfo) {
        console.log(app.globalData.userInfo)
    } else {
      // 在没有 open-type=getUserInfo 版本的兼容处理
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo
        }
      })
    }
  },
  bubbbbb: function(){
      wx.navigateTo({ url: "/pages/shop_detail/shop_detail" })
  }
})
