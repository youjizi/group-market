package cn.yjz.group.domain.activity.service.trial.node;

import cn.yjz.group.domain.activity.model.entity.MarketProductEntity;
import cn.yjz.group.domain.activity.model.entity.TrialBalanceEntity;
import cn.yjz.group.domain.activity.service.trial.AbstractGroupBuyMarketSupport;
import cn.yjz.group.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import cn.yjz.group.types.design.framework.tree.StrategyHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 李白
 * @date 2024-12-15
 * @description 开关节点
 */

@Slf4j
@Service
public class SwitchNode extends AbstractGroupBuyMarketSupport<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> {


    @Resource
    private MarketNode marketNode;

    @Override
    public TrialBalanceEntity doApply(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        return route(requestParameter, dynamicContext);
    }

    @Override
    public StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> get(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        return marketNode;
    }


}
