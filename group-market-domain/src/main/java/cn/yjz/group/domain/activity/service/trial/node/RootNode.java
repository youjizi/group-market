package cn.yjz.group.domain.activity.service.trial.node;

import cn.yjz.group.domain.activity.model.entity.MarketProductEntity;
import cn.yjz.group.domain.activity.model.entity.TrialBalanceEntity;
import cn.yjz.group.domain.activity.service.INode;
import cn.yjz.group.domain.activity.service.trial.AbstractGroupBuyMarketSupport;
import cn.yjz.group.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import cn.yjz.group.types.design.framework.tree.StrategyHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author 李白
 * @date 2024-12-15
 * @description 默认根节点
 */

@Slf4j
@Service("rootNode")
public class RootNode extends AbstractGroupBuyMarketSupport<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> implements INode {


    @Override
    public TrialBalanceEntity apply(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        log.info("根节点");
        dynamicContext.setNextNode("switchRoot");
        return route(requestParameter, dynamicContext);
    }



}
