// pages/shop/shop.js
//获取应用实例
var WxSearch = require('../../wxSearch/wxSearch.js')
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
      z_index_value: 0,
      hot_product: [],
      new_product: []
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
      console.log('onLoad')
      var that = this
      //初始化的时候渲染wxSearchdata
      WxSearch.init(that, 43, ['weappdev', '小程序', 'wxParse', 'wxSearch', 'wxNotification']);
      WxSearch.initMindKeys(['weappdev.com', '微信小程序开发', '微信开发', '微信小程序']);
      wx.request({
          url: 'http://127.0.0.1:8080/hot_product',
          method: 'get',
          header: {
              'content-type': 'application/x-www-form-urlencoded' // 默认值
          },
          success: res => {
              console.log(res.data)
              this.setData({
                  hot_product: res.data   
              })
          }
      })
      wx.request({
          url: 'http://127.0.0.1:8080/new_product',
          method: 'get',
          header: {
              'content-type': 'application/x-www-form-urlencoded' // 默认值
          },
          success: res => {
              console.log(res.data)
              this.setData({
                  new_product: res.data
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
      console.log(this.data.new_product)

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
  wxSearchFn: function (e) {
      var that = this
      WxSearch.wxSearchAddHisKey(that);
      console.log("wxSearchFn");
      wx.navigateTo({
          url: '/pages/product_list/product_list?title=搜索结果',
      })
  },
  wxSearchInput: function (e) {
      var that = this
      WxSearch.wxSearchInput(e, that);
      console.log("wxSearchInput");

  },
  wxSerchFocus: function (e) {
      var that = this
      WxSearch.wxSearchFocus(e, that);
      console.log("wxSerchFocus");
      this.setData({"z_index_value": -1})

  },
  wxSearchBlur: function (e) {
      var that = this
      WxSearch.wxSearchBlur(e, that);
      console.log("wxSearchBlur");
      this.setData({ "z_index_value": 0 })

  },
  wxSearchKeyTap: function (e) {
      var that = this
      WxSearch.wxSearchKeyTap(e, that);
      console.log("wxSearchKeyTap");

  },
  wxSearchDeleteKey: function (e) {
      var that = this
      WxSearch.wxSearchDeleteKey(e, that);
      console.log("wxSearchDeleteKey");

  },
  wxSearchDeleteAll: function (e) {
      var that = this;
      WxSearch.wxSearchDeleteAll(that);
  },
  wxSearchTap: function (e) {
      var that = this
      WxSearch.wxSearchHiddenPancel(that);
      console.log("wxSearchTap");

  }
})