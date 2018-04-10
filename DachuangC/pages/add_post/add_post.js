// pages/add_post/add_post.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
      title: "",
      content: "",
      openid: "",
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options)
    this.setData({
        openid: options.openid
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

  bindTitleInput(e) {
      this.setData({
          title: e.detail.value
      })
  },

  bindContentInput(e) {
      this.setData({
          content: e.detail.value
      })
  },

  add_post() {
      var title = this.data.title
      var content = this.data.content
      if(title==''||content==''){
          wx.showModal({
              content: '标题或内容不能为空',
              showCancel: false,
              success: function (res) {
                  if (res.confirm) {
                      console.log('用户点击确定')
                  }
              }
          });
      } else {
          wx.request({
              url: 'http://127.0.0.1:8080/add_post',
              data: {
                  content: content,
                  title: title,
                  openid: this.data.openid,
              },
              method: 'post',
              header: {
                  'content-type': 'application/x-www-form-urlencoded' // 默认值
              },
              success: res => {
                  console.log(res.data)
                  wx.showToast({
                      title: '发布成功',
                  })
                  wx.navigateBack()
              }
          })
      }
      
  }

  
})