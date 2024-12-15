package cn.yjz.group.domain.activity.service.trial;


import cn.yjz.group.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import cn.yjz.group.types.design.framework.tree.AbstractStrategyRouter;
import cn.yjz.group.types.design.framework.tree.StrategyHandler;

import javax.annotation.Resource;

/**
 * @author 李白
 * @date 2024-12-15
 * @description 抽象的拼团营销支撑类
 */
public abstract class AbstractGroupBuyMarketSupport<MarketProductEntity, DynamicContext, TrialBalanceEntity> extends AbstractStrategyRouter<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> {


    @Override
    public StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> get(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {

        return (StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity>) DefaultActivityStrategyFactory.nextStrategyHandler(dynamicContext.getNextNode());
    }
}




