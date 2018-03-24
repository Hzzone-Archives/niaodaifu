// pages/notifications/notifications.js
import { $wuxRefresher } from '../../dist/components/wux'

Page({
    data: {
        items: [
            {
                user_name: 'Hzzone',
                pic_url: 'http://tuchuang-1252747889.cosgz.myqcloud.com/2018-03-23-01.png',
                time: new Date().toLocaleString(),
                content: '由各种物质组成的巨型球状天体，叫做星球。星球有一定的形状，有自己的运行轨道。由各种物质组成的巨型球状天体，叫做星球。星球有一定的形状，有自己的运行轨道。',
            },
            {

                user_name: 'Hzzone',
                pic_url: 'http://tuchuang-1252747889.cosgz.myqcloud.com/2018-03-23-01.png',
                time: new Date().toLocaleString(),
                content: '由各种物质组成的巨型球状天体，叫做星球。星球有一定的形状，有自己的运行轨道。由各种物质组成的巨型球状天体，叫做星球。星球有一定的形状，有自己的运行轨道。',
            }
        ],
    },
    onLoad() {
        this.refresher = new $wuxRefresher({
            onPulling() {
                console.log('onPulling')
            },
            onRefresh() {
                console.log('onRefresh')
                // 刷新时调用
                setTimeout(() => {
                    const items = this.scope.data.items

                    items.unshift({

                        user_name: 'Hzzone',
                        pic_url: 'http://tuchuang-1252747889.cosgz.myqcloud.com/2018-03-23-01.png',
                        time: new Date().toLocaleString(),
                        content: '由各种物质组成的巨型球状天体，叫做星球。星球有一定的形状，有自己的运行轨道。由各种物质组成的巨型球状天体，叫做星球。星球有一定的形状，有自己的运行轨道。',
                    })

                    this.scope.setData({
                        items: items,
                    })

                    this.events.emit(`scroll.refreshComplete`)
                }, 1000)
            }
        })
        console.log(this.refresher)
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