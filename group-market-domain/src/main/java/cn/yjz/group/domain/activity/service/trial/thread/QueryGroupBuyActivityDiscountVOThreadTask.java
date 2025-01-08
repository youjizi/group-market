package cn.yjz.group.domain.activity.service.trial.thread;


import cn.yjz.group.domain.activity.adapter.repository.IActivityRepository;
import cn.yjz.group.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import cn.yjz.group.domain.activity.model.valobj.SCSkuActivityVO;

import java.util.concurrent.Callable;

/**
 * @author 李白
 * @description 查询营销配置任务
 * @create 2024-12-21 09:46
 */
public class QueryGroupBuyActivityDiscountVOThreadTask implements Callable<GroupBuyActivityDiscountVO> {

    /**
     * 来源
     */
    private final String source;

    /**
     * 渠道
     */
    private final String channel;

    /**
     * 商品id
     */
    private final String goodsId;

    /**
     * 活动仓储
     */
    private final IActivityRepository activityRepository;

    public QueryGroupBuyActivityDiscountVOThreadTask(String source, String channel, String goodsId,IActivityRepository activityRepository) {
        this.source = source;
        this.channel = channel;
        this.goodsId = goodsId;
        this.activityRepository = activityRepository;
    }

    @Override
    public GroupBuyActivityDiscountVO call() throws Exception {
        // 查询渠道商品活动配置关联配置
        SCSkuActivityVO scSkuActivityVO = activityRepository.querySCSkuActivityBySCGoodsId(source, channel, goodsId);
        if (null == scSkuActivityVO) return null;
        // 查询活动配置
        return activityRepository.queryGroupBuyActivityDiscountVO(scSkuActivityVO.getActivityId());
    }

}
