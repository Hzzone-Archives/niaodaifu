package cn.hzzone.dachuang.dao;

import cn.hzzone.dachuang.model.Address;

import java.util.List;

public interface AddressMapper {

    Address selectByPrimaryKey(String address_id);
    List<Address> selectByOpenID(String openid);
    int deleteByPrimaryKey(String address_id);

    int updateByPrimaryKey(Address address);

    int insert(Address address);
}
