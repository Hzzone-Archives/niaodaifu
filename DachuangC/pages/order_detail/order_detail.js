// pages/order_detail/order_detail.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    order: {},
    product: [],
    address: "",
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
      console.log(options)

      var order = JSON.parse(options.order)
      this.setData({
          order: order,
          address: order.address.province + order.address.city + order.address.area + order.address.address_detail,
      })
      var order_items = order.order_items
      for (var index in order_items) {
          wx.request({
              url: 'http://127.0.0.1:8080/product_info',
              data: {
                  
                  productid: order_items[index].productId,

              },
              method: 'post',
              header: {
                  'content-type': 'application/x-www-form-urlencoded' // 默认值
              },
              success: res => {
                  var product = this.data.product
                  console.log(res.data)
                  product.unshift({ price: order_items[index].price, counts: order_items[index].counts, product_name: res.data.productName, product_id: res.data.productId})
                  console.log("productData:"+JSON.stringify(product))
                  this.setData({
                      product: product
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
  
  }
})