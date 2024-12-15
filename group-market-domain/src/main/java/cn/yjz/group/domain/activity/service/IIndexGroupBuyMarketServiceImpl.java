package cn.yjz.group.domain.activity.service;

import cn.yjz.group.domain.activity.model.entity.MarketProductEntity;
import cn.yjz.group.domain.activity.model.entity.TrialBalanceEntity;
import cn.yjz.group.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author 李白
 * @date 2024-12-15
 * @description 首页营销服务
 */

@Slf4j
@Service
public class IIndexGroupBuyMarketServiceImpl implements IIndexGroupBuyMarketService{


    @Resource
    DefaultActivityStrategyFactory defaultActivityStrategyFactory;

    @Override
    public TrialBalanceEntity indexMarketTrial(MarketProductEntity marketProductEntity) throws Exception {

        return defaultActivityStrategyFactory.startStrategyHandler().apply(marketProductEntity, DefaultActivityStrategyFactory.DynamicContext.builder().build());
    }
}
