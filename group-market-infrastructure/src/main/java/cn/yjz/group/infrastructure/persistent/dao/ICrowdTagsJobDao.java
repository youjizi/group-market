package cn.yjz.group.infrastructure.persistent.dao;

import cn.yjz.group.infrastructure.persistent.po.CrowdTagsJob;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 李白
 * @date 2025-01-07
 * @description 人群标签任务
 */

@Mapper
public interface ICrowdTagsJobDao {
    CrowdTagsJob queryCrowdTagsJob(CrowdTagsJob crowdTagsJobReq);
}
