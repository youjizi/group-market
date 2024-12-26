package cn.yjz.group.types.design.framework.tree;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * @author 李白
 * @date 2024-12-25
 * @description 异步资源加载策略
 */
public abstract class AbstractMultiThreadStrategyRouter<T, D, R> extends AbstractStrategyRouter<T, D, R> {
    @Override
    public R apply(T requestParameter, D dynamicContext) throws Exception {
        // 异步加载数据
        multiThread(requestParameter, dynamicContext);
        // 业务流程受理
        return doApply(requestParameter, dynamicContext);
    }


    /**
     * 异步加载数据
     */
    protected abstract void multiThread(T requestParameter, D dynamicContext) throws ExecutionException, InterruptedException, TimeoutException;

    /**
     * 业务流程受理
     */
    protected abstract R doApply(T requestParameter, D dynamicContext) throws Exception;

}
