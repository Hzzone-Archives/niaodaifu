// pages/discussion_area/discussion_area.js
import { $wuxRefresher } from '../../dist/components/wux'

const app = getApp()

Page({

  /**
   * 页面的初始数据
   */
  data: {
      posts: []
  
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
      var that = this
      this.refresher = new $wuxRefresher({
          onPulling() {
              console.log('onPulling')
          },
          onRefresh() {
              console.log('onRefresh')
              // 刷新时调用
              setTimeout(() => {
                
                  wx.request({
                      url: 'http://127.0.0.1:8080/all_posts',
                      method: 'get',
                      header: {
                          'content-type': 'application/x-www-form-urlencoded' // 默认值
                      },
                      success: res => {
                          console.log(res.data)
                          var posts = res.data
                          for (var index in posts) {
                              posts[index].postTime = new Date(posts[index].postTime).toLocaleString()

                          }
                          that.setData({
                              posts: res.data,
                          })
                          this.events.emit(`scroll.refreshComplete`)
                      }
                  })
                  
              }, 1000)
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
      wx.request({
          url: 'http://127.0.0.1:8080/all_posts',
          method: 'get',
          header: {
              'content-type': 'application/x-www-form-urlencoded' // 默认值
          },
          success: res => {
              console.log(res.data)
              var posts = res.data
              for (var index in posts) {
                  posts[index].postTime = new Date(posts[index].postTime).toLocaleString()

              }
              this.setData({
                  posts: res.data,
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

  /**
   * 改变颜色
   */
  change_color: function (e) {
      var $index = e.currentTarget.dataset.index
      console.log($index)
      var support = this.data.posts[$index].support
      this.data.posts[$index].support = !support
      this.setData({
          posts: this.data.posts,
      })
      /**
       * 服务器取消点赞
       */
      if(support) {
          wx.request({
              url: 'http://127.0.0.1:8080/delete_support',
              data: {
                  supportid: this.data.posts[$index].postId,
                  openid: this.data.posts[$index].openId,
              },
              method: 'post',
              header: {
                  'content-type': 'application/x-www-form-urlencoded' // 默认值
              },
              success: res => {
                  console.log(res.data)
              }
          })
      } else {
          /**
           * 服务器点赞
           */
          wx.request({
              url: 'http://127.0.0.1:8080/add_support',
              data: {
                  supportid: this.data.posts[$index].postId,
                  openid: this.data.posts[$index].openId,
              },
              method: 'post',
              header: {
                  'content-type': 'application/x-www-form-urlencoded' // 默认值
              },
              success: res => {
                  console.log(res.data)
              }
          })
      }
  },
    touchstart(e) {
        this.refresher.touchstart(e)
    },
    touchmove(e) {
        this.refresher.touchmove(e)
    },
    touchend(e) {
        this.refresher.touchend(e)
    },
    naviToDetail: function(e) {
        var $index = e.currentTarget.dataset.index
        console.log($index)
        wx.navigateTo({
            url: '/pages/post_detail/post_detail?post=' + JSON.stringify(this.data.posts[$index]),
        })
    },
    addNewPost: function() {
        wx.navigateTo({
            url: '/pages/add_post/add_post?openid=' + app.globalData.userInfo.openId,
        })
    }
})