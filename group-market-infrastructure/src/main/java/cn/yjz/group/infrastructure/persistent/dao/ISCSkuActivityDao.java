package cn.yjz.group.infrastructure.persistent.dao;

import cn.yjz.group.infrastructure.persistent.po.SCSkuActivity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 李白
 * @date 2025-01-07
 * @description 渠道商品活动配置关联表Dao
 */

@Mapper
public interface ISCSkuActivityDao {

    SCSkuActivity querySCSkuActivityBySCGoodsId(SCSkuActivity scSkuActivity);

}