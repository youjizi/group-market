package cn.yjz.group.infrastructure.persistent.dao;

import cn.yjz.group.infrastructure.persistent.po.Sku;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 李白
 * @description 商品查询
 * @create 2024-12-07 10:10
 */
@Mapper
public interface ISkuDao {

    Sku querySkuByGoodsId(String goodsId);

}
