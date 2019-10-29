package com.fx.site.dao;

import com.fx.site.entity.MetaEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @auther: mabaofeng
 * @date: 2019/10/29 15:17
 * @description:
 */
@Mapper
public interface MetaDao {

    /**
     * 根据类型 查询项目
     * @param parameters
     * @return
     */
    List<MetaEntity> selectFromSql(Map<String, Object> parameters);
}
