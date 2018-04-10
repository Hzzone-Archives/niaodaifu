// pages/post_detail/post_detail.js
const app = getApp()
Page({

    /**
     * 页面的初始数据
     */
    data: {
        post: {},
        comments: [],
        input_content: '',
        reply_user: {}
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
        console.log(options)
        this.setData({
            post: JSON.parse(options.post)
        })
        /**
         * 获取所有的评论
         */
        wx.request({
            url: 'http://127.0.0.1:8080/all_comments',
            data: {
                postid: this.data.post.postId,
                openid: app.globalData.userInfo.openId
            },
            method: 'post',
            header: {
                'content-type': 'application/x-www-form-urlencoded' // 默认值
            },
            success: res => {
                console.log(res.data)
                var comments = res.data
                for(var index in comments) {
                    comments[index].commentTime = new Date(comments[index].commentTime).toLocaleString()
                }
                this.setData({
                    comments: res.data   
                })
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
        var support = this.data.comments[$index].support
        this.data.comments[$index].support = !support
        this.setData({
            comments: this.data.comments,
        })

        /**
       * 服务器取消点赞
       */
        if (support) {
            wx.request({
                url: 'http://127.0.0.1:8080/delete_support',
                data: {
                    supportid: this.data.comments[$index].commentId,
                    openid: app.globalData.userInfo.openId,
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
                    supportid: this.data.comments[$index].commentId,
                    openid: app.globalData.userInfo.openId,
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

    post_change_color: function (e) {
        var support = this.data.post.support
        this.data.post.support = !support
        this.setData({
            post: this.data.post,
        })
        if (support) {
            wx.request({
                url: 'http://127.0.0.1:8080/delete_support',
                data: {
                    supportid: this.data.post.postId,
                    openid: this.data.post.openId,
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
                    supportid: this.data.post.postId,
                    openid: this.data.post.openId,
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

    /**
     * 点击添加回复
     */
    add_comment: function (e) {
        console.log("添加回复")
        console.log(this.data.input_content)
        var nstr = this.data.input_content.replace(/\@[^\)]*\:\n/g, "")
        var to_openid = this.data.reply_user.openId
        console.log(to_openid)
        wx.request({
            url: 'http://127.0.0.1:8080/add_comment',
            data: {
                content: nstr,
                from_openid: app.globalData.userInfo.openId,
                to_openid: to_openid,
                postid: this.data.post.postId
            },
            method: 'post',
            header: {
                'content-type': 'application/x-www-form-urlencoded' // 默认值
            },
            success: res => {
                console.log(res.data)
                var comment = res.data
                comment.commentTime = new Date(comment.commentTime).toLocaleString()
                this.data.comments.unshift(comment)
                this.setData({
                    comments: this.data.comments
                })
                wx.showToast("回复成功")
                this.setData({
                    input_content: ''
                })
            }
        })

    },

    /**
     * 点击回复按钮
     */
    addNewComments: function (e) {
        var $index = e.currentTarget.dataset.index
        var user = this.data.comments[$index].from_user
        this.setData({
            reply_user: user,
            input_content: '@' + user.userName + ':\n'
        })
        console.log(user)
    },

    bindTextAreaBlur: function(e) {
        this.setData({
            input_content: e.detail.value
        })
    }
})