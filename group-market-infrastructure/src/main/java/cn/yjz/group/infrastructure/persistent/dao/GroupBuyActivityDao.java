package cn.yjz.group.infrastructure.persistent.dao;

import cn.yjz.group.infrastructure.persistent.po.GroupBuyActivityPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 李白
 * @date 2024-12-10
 * @description
 */

@Mapper
public interface GroupBuyActivityDao {


    /**
     * 添加一个新的拼团活动
     * @param groupBuyActivity 拼团活动对象
     * @return 插入的记录ID
     */
    Long insertGroupBuyActivity(GroupBuyActivityPO groupBuyActivity);

    /**
     * 根据ID删除一个拼团活动
     * @param activityId 要删除的拼团活动ID
     * @return 影响的行数
     */
    int deleteGroupBuyActivityById(Long activityId);

    /**
     * 更新一个拼团活动的信息
     * @param groupBuyActivity 要更新的拼团活动对象
     * @return 影响的行数
     */
    int updateGroupBuyActivity(GroupBuyActivityPO groupBuyActivity);

    /**
     * 根据ID查询一个拼团活动
     * @param activityId 拼团活动ID
     * @return 拼团活动对象
     */
    GroupBuyActivityPO selectGroupBuyActivityById(Long activityId);

    /**
     * 查询所有拼团活动
     * @return 拼团活动列表
     */
    List<GroupBuyActivityPO> selectAllGroupBuyActivities();

    /**
     * 根据活动状态查询拼团活动
     * @param status 活动状态
     * @return 符合条件的拼团活动列表
     */
    List<GroupBuyActivityPO> selectGroupBuyActivitiesByStatus(Integer status);


}
