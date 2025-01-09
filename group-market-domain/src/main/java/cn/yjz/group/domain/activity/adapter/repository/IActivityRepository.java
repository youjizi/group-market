package cn.yjz.group.domain.activity.adapter.repository;


import cn.yjz.group.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import cn.yjz.group.domain.activity.model.valobj.SCSkuActivityVO;
import cn.yjz.group.domain.activity.model.valobj.SkuVO;

/**
 * @author 李白
 * @description 活动仓储
 * @create 2024-12-21 10:06
 */
public interface IActivityRepository {

    GroupBuyActivityDiscountVO queryGroupBuyActivityDiscountVO(Long activityId );

    SkuVO querySkuByGoodsId(String goodsId);


    SCSkuActivityVO querySCSkuActivityBySCGoodsId(String source, String channel, String goodsId);

    boolean isTagCrowdRange(String tagId, String userId);
}
