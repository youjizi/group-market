package cn.yjz.group.test.domain;

import cn.yjz.group.domain.tag.service.ITagService;
import cn.yjz.group.infrastructure.redis.IRedisService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RBitSet;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


/**
 * @author 李白
 * @date 2025-01-07
 * @description
 */

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class TagTest {


    @Resource
    ITagService tagService;

    @Resource
    IRedisService redisService;

    @Test
    public void executeTagJob() {
        tagService.executeTagJob("RQ_KJHKL98UU78H66554GFDV", "10001");
    }


    @Test
    public void test_get_tag_bitmap() {
        RBitSet bitSet = redisService.getBitSet("RQ_KJHKL98UU78H66554GFDV");
        // 是否存在
        log.info("xiaofuge 存在，预期结果为 true，测试结果:{}", bitSet.get(redisService.getIndexFromUserId("xiaofuge")));
        log.info("gudebai 不存在，预期结果为 false，测试结果:{}", bitSet.get(redisService.getIndexFromUserId("gudebai")));
    }
}


