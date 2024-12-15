package cn.yjz.group.test.infrastructure.persistent;

import cn.yjz.group.infrastructure.persistent.dao.GroupBuyActivityDao;
import cn.yjz.group.infrastructure.persistent.po.GroupBuyActivityPO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author 李白
 * @date 2024-12-11
 * @description
 */

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupBuyActivityTest {

    @Resource
    private GroupBuyActivityDao groupBuyActivityDao;

    @Test
    public void add() {

        GroupBuyActivityPO groupBuyActivityPO = new GroupBuyActivityPO();
        groupBuyActivityPO.setActivityId(1001L); // 活动ID
        groupBuyActivityPO.setSource("sourceA"); // 来源
        groupBuyActivityPO.setChannel("channelB"); // 渠道
        groupBuyActivityPO.setGoodsId("goods123"); // 商品ID
        groupBuyActivityPO.setDiscountId("123"); // 折扣ID
        groupBuyActivityPO.setGroupType(1); // 拼团方式【0自动成团、1达成目标成团】
        groupBuyActivityPO.setTakeLimitCount(3); // 参与次数限制
        groupBuyActivityPO.setTarget(5); // 达成目标【3人单、5人单】
        groupBuyActivityPO.setValidTime(new Date(System.currentTimeMillis() + 10 * 60 * 1000)); // 拼团时长【有效时间、10分钟、30分钟】
        groupBuyActivityPO.setStatus(0); // 活动状态【0 开始 1 未开始】
        groupBuyActivityPO.setStartTime(new Date(System.currentTimeMillis())); // 开始时间
        groupBuyActivityPO.setEndTime(new Date(System.currentTimeMillis() + 2 * 60 * 60 * 1000)); // 结束时间
        groupBuyActivityPO.setTagId("tag789"); // 人群标签规则标识
        groupBuyActivityPO.setTagScope("visible,participate"); // 人群标签规则范围【多选、可见、参与】


        Long id = groupBuyActivityDao.insertGroupBuyActivity(groupBuyActivityPO);

        log.info("新增拼团活动，活动ID：{}", id);

    }

    @Test
    public void select() {
        GroupBuyActivityPO groupBuyActivityPO = groupBuyActivityDao.selectGroupBuyActivityById(1001L);
        log.info("查询拼团活动，活动信息：{}", groupBuyActivityPO);

    }

    @Test
    public void update() {

        GroupBuyActivityPO groupBuyActivityPO = new GroupBuyActivityPO();
        groupBuyActivityPO.setActivityId(1001L); // 活动ID
        groupBuyActivityPO.setSource("sourceA"); // 来源
        groupBuyActivityPO.setChannel("channelB"); // 渠道
        groupBuyActivityPO.setGoodsId("goods123"); // 商品ID
        groupBuyActivityPO.setDiscountId("1234"); // 折扣ID
        groupBuyActivityPO.setGroupType(1); // 拼团方式【0自动成团、1达成目标成团】
        groupBuyActivityPO.setTakeLimitCount(3); // 参与次数限制
        groupBuyActivityPO.setTarget(5); // 达成目标【3人单、5人单】
        groupBuyActivityPO.setValidTime(new Date(System.currentTimeMillis() + 10 * 60 * 1000)); // 拼团时长【有效时间、10分钟、30分钟】
        groupBuyActivityPO.setStatus(1); // 活动状态【0 开始 1 未开始】
        groupBuyActivityPO.setStartTime(new Date(System.currentTimeMillis())); // 开始时间
        groupBuyActivityPO.setEndTime(new Date(System.currentTimeMillis() + 2 * 60 * 60 * 1000)); // 结束时间
        groupBuyActivityPO.setTagId("tag789"); // 人群标签规则标识
        groupBuyActivityPO.setTagScope("visible,participate"); // 人群标签规则范围【多选、可见、参与】


        int i = groupBuyActivityDao.updateGroupBuyActivity(groupBuyActivityPO);
        log.info("更新拼团活动，影响行数：{}", i);

    }

    @Test
    public void delete() {
        int i = groupBuyActivityDao.deleteGroupBuyActivityById(1001L);
        log.info("删除拼团活动，影响行数：{}", i);
    }

    @Test
    public void selectAll() {

        for (GroupBuyActivityPO groupBuyActivityPO : groupBuyActivityDao.selectAllGroupBuyActivities()) {
            log.info("查询拼团活动，活动信息：{}", groupBuyActivityPO);
        }

    }


}
