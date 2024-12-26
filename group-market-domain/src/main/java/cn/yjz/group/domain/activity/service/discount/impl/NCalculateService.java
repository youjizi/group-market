package cn.yjz.group.domain.activity.service.discount.impl;

import cn.yjz.group.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import cn.yjz.group.domain.activity.service.discount.AbstractDiscountCalculateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author 李白
 * @date 2024-12-26
 * @description N元购计算
 */

@Slf4j
@Service("N")
public class NCalculateService extends AbstractDiscountCalculateService {


    @Override
    protected BigDecimal doCalculate(BigDecimal originalPrice, GroupBuyActivityDiscountVO.GroupBuyDiscount groupBuyDiscount) {
        log.info("优惠策略折扣计算类型:{} 编号：{}", groupBuyDiscount.getDiscountType().getInfo(), groupBuyDiscount.getDiscountType().getCode());

        // 折扣表达式 - 直接为优惠后的金额
        String marketExpr = groupBuyDiscount.getMarketExpr();
        // n元购
        return new BigDecimal(marketExpr);
    }
}
