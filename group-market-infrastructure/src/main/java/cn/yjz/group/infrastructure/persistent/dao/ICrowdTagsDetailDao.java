package cn.yjz.group.infrastructure.persistent.dao;

import cn.yjz.group.infrastructure.persistent.po.CrowdTagsDetail;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 李白
 * @date 2025-01-07
 * @description 人群标签明细表
 */

@Mapper
public interface ICrowdTagsDetailDao {

    void addCrowdTagsUserId(CrowdTagsDetail crowdTagsDetailReq);

    CrowdTagsDetail queryCrowdTagsByUserId(CrowdTagsDetail crowdTagsDetailReq);
}
