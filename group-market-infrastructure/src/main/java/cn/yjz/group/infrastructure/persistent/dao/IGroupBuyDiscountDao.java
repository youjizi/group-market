package cn.yjz.group.infrastructure.persistent.dao;

import cn.yjz.group.infrastructure.persistent.po.GroupBuyDiscount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @author 李白
 * @description 折扣配置Dao
 * @create 2024-12-07 10:10
 */
@Mapper
public interface IGroupBuyDiscountDao {

    List<GroupBuyDiscount> queryGroupBuyDiscountList();

    GroupBuyDiscount queryGroupBuyActivityDiscountByDiscountId(String discountId);

}
