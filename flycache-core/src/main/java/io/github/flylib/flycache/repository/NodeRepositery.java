package io.github.flylib.flycache.repository;

import io.github.flylib.flycache.entity.NodeGroupEntity;
import io.github.flylib.flycache.postgre.JSONTypeHandler;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * @author liushaoming
 * @Package io.github.flylib.flycache.repository
 * @Description:
 * @date 2018-1-23 15:07
 */
@Mapper

public interface NodeRepositery {
    //    @Select("select * from node_group;")
//    @Results({
//            @Result(id = true, property = "id", column = "id"),
//            @Result(property = "creater", column = "creater"),
//            @Result(property = "node", column = "node", javaType = Object.class, jdbcType = JdbcType.OTHER,
//                    typeHandler = JSONTypeHandler.class),
//            @Result(property = "time", column = "time", javaType = String.class)
//    })
    @Select("select * from node_group;")
    public List<NodeGroupEntity> all();
}
