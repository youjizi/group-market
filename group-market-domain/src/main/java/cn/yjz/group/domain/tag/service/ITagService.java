package cn.yjz.group.domain.tag.service;

import cn.yjz.group.domain.tag.model.entity.CrowdTagsJobEntity;

/**
 * @author 李白
 * @date 2025-01-07
 * @description 人群标签服务
 */
public interface ITagService {

    /**
     * 执行人群标签批次任务
     *
     * @param tagId   人群ID
     * @param batchId 批次ID
     */
    void executeTagJob(String tagId, String batchId);
}
