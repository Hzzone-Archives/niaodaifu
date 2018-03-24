//index.js
//获取应用实例
const app = getApp()

Page({
    data: {
        total_time: 0,
        top_content: [
            {
                title: '连接仪器检测',
                pic: '/images/similar-product.png',
                deal_function: 'camera_deal'
            },
            {
                title: '拍照检测',
                pic: '/images/相机.png',
                deal_function: 'firmware_deal'
            }

        ],
        discussion_area_items: [
            {
                title: '病友圈',
                content: '和处境相同的好友一起交流经验',
                icon: '/images/account.png',
                url: '../../pages/address/address'
            },
            {
                title: '疑难解答',
                content: '请教专家关于你的身体状况',
                icon: '/images/service.png',
                url: '../../pages/address/address'
            },
        ],
        indicatorDots: false,
        autoplay: false,
        interval: 5000,
        duration: 1000
    },
  onLoad: function () {
  },
  
  camera_deal: function () {
      wx.showToast({
          title: '待开发',
      })
  }, 


  firmware_deal: function () {
      wx.showToast({
          title: '待开发',
      })
  }
})
