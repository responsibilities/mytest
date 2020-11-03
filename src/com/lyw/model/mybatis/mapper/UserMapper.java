package com.lyw.model.mybatis.mapper;

import com.lyw.model.mybatis.annotation.Param;
import com.lyw.model.mybatis.annotation.Select;

public interface UserMapper {

    @Select("select * form table_name where id = #{id}")
    void getById(@Param("id") int id);

//    @Select("select * form table_name")
    @Select("select * form table_name where id = #{id}")
//    @Select("select * form table_name where id = #{id} and username = #{userName}")
    void getPart(@Param("id") int id, @Param("userName") String userName);

    void getList();
}
