package cn.yjz.group.domain.activity.service.discount;

import cn.yjz.group.domain.activity.model.valobj.DiscountTypeEnum;
import cn.yjz.group.domain.activity.model.valobj.GroupBuyActivityDiscountVO;

import java.math.BigDecimal;

/**
 * @author 李白
 * @date 2024-12-26
 * @description 抽象折扣计算服务
 */
public abstract class AbstractDiscountCalculateService implements IDiscountCalculateService{

    @Override
    public BigDecimal calculate(String userId, BigDecimal originalPrice, GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount) {

        // 1. 人群标签过滤
        if (DiscountTypeEnum.TAG.equals(groupBuyDiscount.getDiscountType())){
            boolean isCrowdRange = filterTagId(userId, groupBuyDiscount.getTagId());
            if (!isCrowdRange) return originalPrice;
        }

        // 2. 折扣优惠计算
        return doCalculate(originalPrice, groupBuyDiscount);
    }

    // 人群过滤 - 限定人群优惠
    private boolean filterTagId(String userId, String tagId) {
        // todo  后续开发这部分
        return true;
    }

    protected abstract BigDecimal doCalculate(BigDecimal originalPrice, GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount);

    /**
     * 满减优惠价格比较
     * @param deductionPrice  优惠后的价格
     * @param thresholdPrice  阈值价格
     * @return true: 优惠后的价格小于等于
     */
    protected boolean deductionPriceCompareTo(BigDecimal deductionPrice, BigDecimal thresholdPrice) {
        return deductionPrice.compareTo(thresholdPrice) <= 0;
    }

}
