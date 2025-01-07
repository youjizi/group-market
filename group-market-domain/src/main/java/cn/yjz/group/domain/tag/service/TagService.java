package cn.yjz.group.domain.tag.service;

import cn.yjz.group.domain.tag.model.entity.CrowdTagsJobEntity;
import cn.yjz.group.domain.tag.repository.ITagRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 李白
 * @date 2025-01-07
 * @description
 */

@Slf4j
@Service
public class TagService implements ITagService{

    @Resource
    private ITagRepository repository;

    @Override
    public void executeTagJob(String tagId, String batchId) {
        log.info("人群标签批次任务 tagId:{} batchId:{}", tagId, batchId);

        // 1. 查询批次任务
        CrowdTagsJobEntity crowdTagsJobEntity = repository.queryCrowdTagsJobEntity(tagId, batchId);

        // 2. 采集用户数据 - 这部分需要采集用户的消费类数据，后续有用户发起拼单后再处理。

        // 3. 数据写入记录
        List<String> userIdList = new ArrayList<String>() {{
            add("黧黑");
            add("王德法");
            add("李黑哦");
        }};
        int size = userIdList.size();
        // 4. 一般人群标签的处理在公司中，会有专门的数据数仓团队通过脚本方式写入到数据库，就不用这样一个个或者批次来写。
        for (String userId : userIdList) {
            try {
                repository.addCrowdTagsUserId(tagId, userId);
            } catch (Exception e) {
                size--;
            }
        }

        // 5. 更新人群标签统计量
        repository.updateCrowdTagsStatistics(tagId, size);


    }
}
