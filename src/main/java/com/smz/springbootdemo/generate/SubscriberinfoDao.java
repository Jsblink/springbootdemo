package com.smz.springbootdemo.generate;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubscriberinfoDao {
    int deleteByPrimaryKey(Integer usersn);

    int insert(Subscriberinfo record);

    int insertSelective(Subscriberinfo record);

    Subscriberinfo selectByPrimaryKey(Integer usersn);

    int updateByPrimaryKeySelective(Subscriberinfo record);

    int updateByPrimaryKey(Subscriberinfo record);
}