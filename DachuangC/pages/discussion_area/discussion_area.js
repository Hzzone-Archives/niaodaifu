// pages/discussion_area/discussion_area.js
import { $wuxRefresher } from '../../dist/components/wux'

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
      this.setData({
          posts: [
              {
                  post_id: '1',
                  user_id: '2',
                  user_head_img: 'http://tuchuang-1252747889.cosgz.myqcloud.com/2018-03-23-01.png',
                  user_name: 'Hzzone',
                  time: '2018/3/25 下午8:10:10',
                  title: '这是一个测试标题，我身体很健康',
                  content: '我健康的很健康的很呢我擦擦擦擦擦擦擦擦擦我擦擦擦擦擦擦擦擦擦我擦擦擦擦擦擦擦擦擦我擦擦擦擦擦擦擦擦擦我擦擦擦擦擦擦擦擦擦我擦擦擦擦擦擦擦擦擦我擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦',
                  comment_counts: 10,
                  isSupport: true,
              },
              {
                  post_id: '2',
                  user_id: '2',
                  user_head_img: 'http://tuchuang-1252747889.cosgz.myqcloud.com/2018-03-23-01.png',
                  user_name: 'Hzzone',
                  time: '2018/3/25 下午8:10:10',
                  title: '这是一个测试标题，我身体很健康',
                  content: '我健康的很健康的很呢我擦擦擦擦擦擦擦擦擦我擦擦擦擦擦擦擦擦擦我擦擦擦擦擦擦擦擦擦我擦擦擦擦擦擦擦擦擦我擦擦擦擦擦擦擦擦擦我擦擦擦擦擦擦擦擦擦我擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦',
                  comment_counts: 10,
                  isSupport: false,
              }
          ]
      })
      this.refresher = new $wuxRefresher({
          onPulling() {
              console.log('onPulling')
          },
          onRefresh() {
              console.log('onRefresh')
              // 刷新时调用
              setTimeout(() => {
                  const items = this.scope.data.posts
                  items.unshift({
                      post_id: '3',
                      user_id: '2',
                      user_head_img: 'http://tuchuang-1252747889.cosgz.myqcloud.com/2018-03-23-01.png',
                      user_name: 'Hzzone',
                      time: '2018/3/25 下午8:10:10',
                      title: '这是一个测试标题，我身体很健康',
                      content: '我健康的很健康的很呢我擦擦擦擦擦擦擦擦擦我擦擦擦擦擦擦擦擦擦我擦擦擦擦擦擦擦擦擦我擦擦擦擦擦擦擦擦擦我擦擦擦擦擦擦擦擦擦我擦擦擦擦擦擦擦擦擦我擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦擦',
                      comment_counts: 10,
                      isSupport: true,
                  })

                  this.scope.setData({
                      posts: items,
                  })

                  this.events.emit(`scroll.refreshComplete`)
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
      this.data.posts[$indnewex]["isSupport"] = !this.data.posts[$index]["isSupport"]
      this.setData({
          posts: this.data.posts,
      })
  },
  
  /**
   * 发送服务器取消点赞
   */
  cancel_support: function (e) {
      console.log("取消点赞")
  },

  /**
   * 发送服务器增加
   */
  support: function (e) {
      console.log("增加点赞")
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

})