package cn.yjz.group.types.design.framework.tree;

/**
 * @author 李白
 * @date 2024-12-15
 * @description  策略处理器接口
 */
public interface StrategyHandler<T, D, R> {

    StrategyHandler DEFAULT = (T, D) -> null;

    /**
     * 受理执行的业务流程。
     * 每个业务流程执行时，如果有数据是从前面节点到后面节点要使用的，
     * 那么可以填充到 dynamicContext 上下文中。
     * @param requestParameter 请求参数
     * @param dynamicContext 动态上下文
     * @return 结果
     * @throws Exception 异常
     */
    R apply(T requestParameter, D dynamicContext) throws Exception;
}
