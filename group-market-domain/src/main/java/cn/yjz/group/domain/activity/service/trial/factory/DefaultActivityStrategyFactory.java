package cn.yjz.group.domain.activity.service.trial.factory;

import cn.yjz.group.domain.activity.model.entity.MarketProductEntity;
import cn.yjz.group.domain.activity.model.entity.TrialBalanceEntity;
import cn.yjz.group.domain.activity.service.INode;
import cn.yjz.group.domain.activity.service.trial.AbstractGroupBuyMarketSupport;
import cn.yjz.group.domain.activity.service.trial.node.RootNode;
import cn.yjz.group.types.common.Constants;
import cn.yjz.group.types.design.framework.tree.StrategyHandler;
import cn.yjz.group.types.exception.AppException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 李白
 * @date 2024-12-15
 * @description 活动策略工厂
 */

@Service
public class DefaultActivityStrategyFactory {


    private final RootNode rootNode;

    private static final ConcurrentHashMap<String,  INode> strategyHandlerMap  = new ConcurrentHashMap<>() ;

    public DefaultActivityStrategyFactory(Map<String, INode> map) {
        try {
            for (String key : map.keySet()) {

                strategyHandlerMap.put(key, map.get(key));
            }
            rootNode = (RootNode) strategyHandlerMap.get("rootNode");
        } catch (Exception e) {
            throw new AppException(Constants.ResponseCode.ACTIVITY_NODE_ERROR.getCode(), Constants.ResponseCode.ACTIVITY_NODE_ERROR.getInfo(), e);
        }

    }

    public StrategyHandler<MarketProductEntity, DynamicContext, TrialBalanceEntity>  startStrategyHandler() {
        return rootNode;
    }
    public static StrategyHandler<MarketProductEntity, DynamicContext, TrialBalanceEntity>  nextStrategyHandler(String nextNode) {
        return (StrategyHandler<MarketProductEntity, DynamicContext, TrialBalanceEntity>) strategyHandlerMap.get(nextNode);
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DynamicContext {

        private String nextNode;
    }

}
