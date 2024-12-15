package cn.yjz.group.domain.activity.service;

import cn.yjz.group.domain.activity.model.entity.MarketProductEntity;
import cn.yjz.group.domain.activity.model.entity.TrialBalanceEntity;

/**
 * @author 李白
 * @date 2024-12-15
 * @description 首页营销服务接口
 */
public interface IIndexGroupBuyMarketService {

    TrialBalanceEntity indexMarketTrial(MarketProductEntity marketProductEntity) throws Exception;

}
