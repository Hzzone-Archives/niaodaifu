package cn.hzzone.dachuang.dao;

import cn.hzzone.dachuang.model.Notification;

public interface NotificationMapper {
    int deleteByPrimaryKey(String notificationId);

    int insert(Notification record);

    int insertSelective(Notification record);

    Notification selectByPrimaryKey(String notificationId);

    int updateByPrimaryKeySelective(Notification record);

    int updateByPrimaryKey(Notification record);
}