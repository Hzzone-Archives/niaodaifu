//logs.js
const util = require('../../utils/util.js')

Page({
  data: {
    logs: [],
    device: [],
    device_name: []
  },
  onLoad: function () {
      var that = this
      function ab2hex(buffer) {
          var hexArr = Array.prototype.map.call(
              new Uint8Array(buffer),
              function (bit) {
                  return ('00' + bit.toString(16)).slice(-2)
              }
          )
          return hexArr.join('');
      }
      wx.startBluetoothDevicesDiscovery({
          success: function (res) {
              console.log(res)
              that.setData({
                  logs: JSON.stringify(res)
                })

              wx.getBluetoothDevices({
                  success: function (res) {
                      console.log(res)
                      var devices = res.devices
                      var names = []
                      for(var index in devices) {

                          if(devices[index].name=='WTXHC05') {
                              that.setData({
                                  device: JSON.stringify(devices[index])
                      })
                              console.log(devices[index].name)
                          }
                          console.log(devices[index].name)
                          names.unshift(devices[index].name)
                      }
                      that.setData({
                          device_name: names
                      })
                  }
              })
          },
          fail: function (res){
              that.setData({
                  logs: JSON.stringify(res),
              })

          }
          
      })
    
  }
})
