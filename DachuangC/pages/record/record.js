// pages/record/record.js
import { $wuxCalendar } from '../../dist/components/wux'
var wxCharts = require('../../utils/wxcharts-min.js');

Page({

  /**
   * 页面的初始数据
   */
  data: {
      records: [
          {
              records_id: '1111',
              record_type: '尿检',
              time: "2018-7-18 上午三点",
              data: [15, 20, 45, 37, 15, 20, 45, 37],
              categories: ['2012', '2013', '2014', '2015', '2012', '2013', '2014', '2015'],
              isNormal: true,
          },
          {
              records_id: '1111',
              record_type: '尿检',
              time: "2018-7-18 上午三点",
              data: [15, 20, 45, 37, 15, 20, 45, 37, 45, 37],
              categories: ['2012', '2013', '2014', '2015', '2012', '2013', '2014', '2015', '2013', '2014'],
              isNormal: true,
          }
      ],
      post_item_display: true,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(this.data.records)
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function (e) {
    this.paint()
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
  select_all_record: function() {
    this.setData({
        post_item_display: false,
    })
  },
  openCalendar() {
      if (this.birthday) {
          return this.birthday.show()
      }

      this.birthday = $wuxCalendar.init('birthday', {
          value: ['2017-04-15'],
          onChange(p, v, d) {
            //   console.log(p, v, d)
            console.log(d)
            //   this.setData({
            //       birthday: d.join(', ')
            //   })
          }
      })
  },

  test: function() {
    this.data.records = []
    this.data.records = this.data.records.concat([{
            records_id: '1111',
            record_type: '尿检',
            time: "2018-7-18 上午三点",
            data: [15, 20, 45, 37, 15, 20, 45, 37],
            categories: ['2012', '2013', '2014', '2015', '2012', '2013', '2014', '2015'],
            isNormal: true,
        },
        {
            records_id: '1111',
            record_type: '尿检',
            time: "2018-7-18 上午三点",
            data: [15, 20, 45, 37, 15, 20, 45, 37],
            categories: ['2012', '2013', '2014', '2015', '2012', '2013', '2014', '2015'],
            isNormal: false,
        }])

    this.setData({
        records: this.data.records
    })
    //   this.setData({
    //       records: []
    //   })
    this.paint()
    console.log(this.data.records.length)
    console.log(this.data.records)
  },
  paint: function () {
        var windowWidth = 320;
        try {
            var res = wx.getSystemInfoSync();
            windowWidth = res.windowWidth;
        } catch (e) {
            console.error('getSystemInfoSync failed!');
        }
    console.log(windowWidth)
    for (var i = 0; i< this.data.records.length; i++) {

    var columnChart = new wxCharts({
        canvasId: 'columnCanvas-' + i,
        type: 'column',
        animation: true,
        categories: this.data.records[i].categories,
        series: [{
            name: '成交量',
            data: this.data.records[i].data,
            format: function (val, name) {
                return val.toFixed(2) + '万';
            }
        }],
        yAxis: {
            format: function (val) {
                return val + '万';
            },
            title: 'hello',
            min: 0
        },
        xAxis: {
            disableGrid: false,
            type: 'calibration'
        },
        extra: {
            column: {
                width: 10
            }
        },
        width: windowWidth,
        height: 200,
        });
        }
    },
})