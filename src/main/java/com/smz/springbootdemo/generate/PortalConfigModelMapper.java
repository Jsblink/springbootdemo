package com.smz.springbootdemo.generate;

import com.smz.springbootdemo.domain.PortalConfigModel;
import com.smz.springbootdemo.domain.PortalConfigModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PortalConfigModelMapper {
    long countByExample(PortalConfigModelExample example);

    int deleteByExample(PortalConfigModelExample example);

    int insert(PortalConfigModel record);

    int insertSelective(PortalConfigModel record);

    List<PortalConfigModel> selectByExample(PortalConfigModelExample example);

    int updateByExampleSelective(@Param("record") PortalConfigModel record, @Param("example") PortalConfigModelExample example);

    int updateByExample(@Param("record") PortalConfigModel record, @Param("example") PortalConfigModelExample example);
}