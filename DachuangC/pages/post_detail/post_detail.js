// pages/post_detail/post_detail.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
        author : {
            author_head_img: 'http://tuchuang-1252747889.cosgz.myqcloud.com/2018-03-23-01.png',
            user_name: 'Hzzone111',
            time: '1886666',
            title: '我爱小熊',
            content: 'hhhhhhhhhhhhhh',
            isSupport: true,
            comment_counts: 10,
        },
        comments: [
            {
                head_img: "http://tuchuang-1252747889.cosgz.myqcloud.com/2018-03-23-01.png",
                user_name: "Hzzone",
                comment_index: 1,
                time: "2017年八月八日",
                content: "这是测试回复",
                to_user_id: "1111",
                to_user_name: "Hzzone",
                isSupport: false,

            },
            
        ]
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
        console.log(options)
        this.setData(options)
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
        this.data.comments[$index]["isSupport"] = !this.data.comments[$index]["isSupport"]
        this.setData({
            comments: this.data.comments,
        })
    },
    post_change_color: function (e) {
        this.data.author.isSupport = !this.data.author.isSupport
        this.setData({
            author: this.data.author,
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
})