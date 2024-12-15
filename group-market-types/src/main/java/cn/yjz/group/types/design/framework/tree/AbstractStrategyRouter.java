package cn.yjz.group.types.design.framework.tree;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 李白
 * @date 2024-12-15
 * @description 抽象路由器，通过调用策略映射器get方法，控制节点流程的走向。
 */
public abstract class AbstractStrategyRouter<T,D,R> implements StrategyMapper<T,D,R>, StrategyHandler<T,D,R> {


    @Getter
    @Setter
    protected StrategyHandler<T, D, R> defaultStrategyHandler = StrategyHandler.DEFAULT;

    public R route(T requestParameter, D dynamicContext) throws Exception {

        StrategyHandler<T, D, R> handler = get(requestParameter, dynamicContext);
        if(handler != null) return handler.apply(requestParameter, dynamicContext);
        return defaultStrategyHandler.apply(requestParameter, dynamicContext);
    }

}
