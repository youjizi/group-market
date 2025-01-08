package cn.yjz.group.test.infrastructure.persistent;

import cn.yjz.group.infrastructure.persistent.dao.IGroupBuyActivityDao;
import cn.yjz.group.infrastructure.persistent.po.GroupBuyActivity;
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
    private IGroupBuyActivityDao IGroupBuyActivityDao;

    @Test
    public void add() {

        GroupBuyActivity groupBuyActivity = new GroupBuyActivity();
        groupBuyActivity.setActivityId(1001L); // 活动ID
        groupBuyActivity.setDiscountId("123"); // 折扣ID
        groupBuyActivity.setGroupType(1); // 拼团方式【0自动成团、1达成目标成团】
        groupBuyActivity.setTakeLimitCount(3); // 参与次数限制
        groupBuyActivity.setTarget(5); // 达成目标【3人单、5人单】
        groupBuyActivity.setValidTime(3); // 拼团时长【有效时间、10分钟、30分钟】
        groupBuyActivity.setStatus(0); // 活动状态【0 开始 1 未开始】
        groupBuyActivity.setStartTime(new Date(System.currentTimeMillis())); // 开始时间
        groupBuyActivity.setEndTime(new Date(System.currentTimeMillis() + 2 * 60 * 60 * 1000)); // 结束时间
        groupBuyActivity.setTagId("tag789"); // 人群标签规则标识
        groupBuyActivity.setTagScope("visible,participate"); // 人群标签规则范围【多选、可见、参与】


        Long id = IGroupBuyActivityDao.insertGroupBuyActivity(groupBuyActivity);

        log.info("新增拼团活动，活动ID：{}", id);

    }

    @Test
    public void select() {
        GroupBuyActivity groupBuyActivity = IGroupBuyActivityDao.selectGroupBuyActivityById(1001L);
        log.info("查询拼团活动，活动信息：{}", groupBuyActivity);

    }

    @Test
    public void update() {

        GroupBuyActivity groupBuyActivity = new GroupBuyActivity();
        groupBuyActivity.setActivityId(1001L); // 活动ID
        groupBuyActivity.setDiscountId("1234"); // 折扣ID
        groupBuyActivity.setGroupType(1); // 拼团方式【0自动成团、1达成目标成团】
        groupBuyActivity.setTakeLimitCount(3); // 参与次数限制
        groupBuyActivity.setTarget(5); // 达成目标【3人单、5人单】
        groupBuyActivity.setValidTime(3); // 拼团时长【有效时间、10分钟、30分钟】
        groupBuyActivity.setStatus(1); // 活动状态【0 开始 1 未开始】
        groupBuyActivity.setStartTime(new Date(System.currentTimeMillis())); // 开始时间
        groupBuyActivity.setEndTime(new Date(System.currentTimeMillis() + 2 * 60 * 60 * 1000)); // 结束时间
        groupBuyActivity.setTagId("tag789"); // 人群标签规则标识
        groupBuyActivity.setTagScope("visible,participate"); // 人群标签规则范围【多选、可见、参与】


        int i = IGroupBuyActivityDao.updateGroupBuyActivity(groupBuyActivity);
        log.info("更新拼团活动，影响行数：{}", i);

    }

    @Test
    public void delete() {
        int i = IGroupBuyActivityDao.deleteGroupBuyActivityById(1001L);
        log.info("删除拼团活动，影响行数：{}", i);
    }

    @Test
    public void selectAll() {

        for (GroupBuyActivity groupBuyActivity : IGroupBuyActivityDao.selectAllGroupBuyActivities()) {
            log.info("查询拼团活动，活动信息：{}", groupBuyActivity);
        }

    }


}
