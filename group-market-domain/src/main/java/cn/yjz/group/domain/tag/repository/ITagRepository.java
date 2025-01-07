package cn.yjz.group.domain.tag.repository;

import cn.yjz.group.domain.tag.model.entity.CrowdTagsJobEntity;

/**
 * @author 李白
 * @date 2025-01-07
 * @description 标签仓储接口
 */
public interface ITagRepository {



    CrowdTagsJobEntity queryCrowdTagsJobEntity(String tagId, String batchId);

    void addCrowdTagsUserId(String tagId, String userId);

    void updateCrowdTagsStatistics(String tagId, int size);
}
