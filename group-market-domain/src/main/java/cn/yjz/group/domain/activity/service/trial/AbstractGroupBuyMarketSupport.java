package cn.yjz.group.domain.activity.service.trial;


import cn.yjz.group.domain.activity.adapter.repository.IActivityRepository;
import cn.yjz.group.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import cn.yjz.group.types.design.framework.tree.AbstractMultiThreadStrategyRouter;
import cn.yjz.group.types.design.framework.tree.AbstractStrategyRouter;
import cn.yjz.group.types.design.framework.tree.StrategyHandler;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * @author 李白
 * @date 2024-12-15
 * @description 抽象的拼团营销支撑类
 */
public abstract class AbstractGroupBuyMarketSupport<MarketProductEntity, DynamicContext, TrialBalanceEntity> extends AbstractMultiThreadStrategyRouter<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> {


    protected long timeout = 500;
    @Resource
    protected IActivityRepository repository;

    @Override
    protected void multiThread(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws ExecutionException, InterruptedException, TimeoutException {}
}




