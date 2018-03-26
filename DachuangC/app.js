//app.js
App({
  onLaunch: function () {
    // 展示本地存储能力
    var logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)

    // 登录
    wx.login({
      success: res => {
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
          if (res.code) {
              //发起网络请求
            //   wx.request({
            //       url: 'http://127.0.0.1:8080/doLogin',
            //       data: {
            //             code: res.code,
            //             avatarUrl: "https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ40OxuL7aV0csyVfrgApStaaxicg9Zs0p7YalHuevLkuWfxjTibZ0SbB6LPVKJcCKDuZWVatbSxwyg/0",
	        //             city: "Chengdu",
            //             country: "China",
            //             gender: 1,
            //             language: "zh_CN",
            //             nickName: ".",
            //             province: "Sichuan"
                      
            //       },
            //       method: 'post',
            //       header: {
            //           'content-type': 'application/x-www-form-urlencoded' // 默认值
            //       },
            //   })
          } else {
              console.log('登录失败！' + res.errMsg)
          }
          console.log(res.code)
      }
    })
    // 获取用户信息
    wx.getSetting({
      success: res => {
        if (res.authSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
          wx.getUserInfo({
            success: res => {
              // 可以将 res 发送给后台解码出 unionId
              this.globalData.userInfo = res.userInfo

              // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
              // 所以此处加入 callback 以防止这种情况
              if (this.userInfoReadyCallback) {
                this.userInfoReadyCallback(res)
              }
            }
          })
        }
      }
    })
  },
  globalData: {
    userInfo: null,
    server_url: 'http://localhost'
  }
})