// pages/product_list/product_list.js

Page({

  /**
   * 页面的初始数据
   */
    data: {
        items: [{
            type: 'radio',
            label: 'Updated',
            value: 'updated',
            children: [{
                label: 'Recently updated',
                value: 'desc',
            },
            {
                label: 'Least recently updated',
                value: 'asc',
            },
            ],
            groups: ['001'],
        }]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options.title)
    wx.setNavigationBarTitle({
        title: options.title,
    })
    if (options.title=="所有产品") {
        console.log("从所有产品进入")
    } else if (options.title == "搜索结果") {
        console.log("从搜索结果进入")
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
})