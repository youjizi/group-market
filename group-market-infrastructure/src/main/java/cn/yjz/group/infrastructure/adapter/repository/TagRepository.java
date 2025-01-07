package cn.yjz.group.infrastructure.adapter.repository;

import cn.yjz.group.domain.tag.model.entity.CrowdTagsJobEntity;
import cn.yjz.group.domain.tag.repository.ITagRepository;
import cn.yjz.group.infrastructure.persistent.dao.ICrowdTagsDao;
import cn.yjz.group.infrastructure.persistent.dao.ICrowdTagsDetailDao;
import cn.yjz.group.infrastructure.persistent.dao.ICrowdTagsJobDao;
import cn.yjz.group.infrastructure.persistent.po.CrowdTags;
import cn.yjz.group.infrastructure.persistent.po.CrowdTagsDetail;
import cn.yjz.group.infrastructure.persistent.po.CrowdTagsJob;
import cn.yjz.group.infrastructure.redis.IRedisService;
import cn.yjz.group.types.exception.AppException;
import org.redisson.api.RBitSet;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author 李白
 * @date 2025-01-07
 * @description 标签仓库
 */

@Repository
public class TagRepository implements ITagRepository {


    @Resource
    private ICrowdTagsDao crowdTagsDao;
    @Resource
    private ICrowdTagsDetailDao crowdTagsDetailDao;
    @Resource
    private ICrowdTagsJobDao crowdTagsJobDao;

    @Resource
    private IRedisService redisService;

    @Override
    public CrowdTagsJobEntity queryCrowdTagsJobEntity(String tagId, String batchId) {

        CrowdTagsJob crowdTagsJobReq = new CrowdTagsJob();
        crowdTagsJobReq.setTagId(tagId);
        crowdTagsJobReq.setBatchId(batchId);

        CrowdTagsJob crowdTagsJobRes = crowdTagsJobDao.queryCrowdTagsJob(crowdTagsJobReq);
        if (null == crowdTagsJobRes) return null;


        return CrowdTagsJobEntity.builder()
                .tagType(crowdTagsJobRes.getTagType())
                .tagRule(crowdTagsJobRes.getTagRule())
                .statStartTime(crowdTagsJobRes.getStatStartTime())
                .statEndTime(crowdTagsJobRes.getStatEndTime())
                .build();
    }

    @Override
    public void addCrowdTagsUserId(String tagId, String userId) {
        CrowdTagsDetail crowdTagsDetailReq = new CrowdTagsDetail();
        crowdTagsDetailReq.setUserId(userId);
        crowdTagsDetailReq.setTagId(tagId);
        try {
            crowdTagsDetailDao.addCrowdTagsUserId(crowdTagsDetailReq);

            // 写入位图中 set 成1
            RBitSet bitSet = redisService.getBitSet(tagId);
            bitSet.set(redisService.getIndexFromUserId(userId), true);

        } catch (DuplicateKeyException e) {
            throw new AppException("用户已经存在");
        }
    }

    @Override
    public void updateCrowdTagsStatistics(String tagId, int size) {
        CrowdTags crowdTagsReq = new CrowdTags();
        crowdTagsReq.setTagId(tagId);
        crowdTagsReq.setStatistics(size);

        crowdTagsDao.updateCrowdTagsStatistics(crowdTagsReq);
    }
}
