package cn.yjz.group.test.domain;

import cn.yjz.group.domain.activity.model.entity.MarketProductEntity;
import cn.yjz.group.domain.activity.model.entity.TrialBalanceEntity;
import cn.yjz.group.domain.activity.service.IIndexGroupBuyMarketService;
import cn.yjz.group.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import cn.yjz.group.types.design.framework.tree.StrategyHandler;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author 李白
 * @date 2024-12-15
 * @description
 */

@SpringBootTest
@Slf4j
@RunWith(SpringRunner.class)
public class TrialTest {


    @Resource
    IIndexGroupBuyMarketService service;

    @Test
    public void testNode() {


        MarketProductEntity marketProductEntity = MarketProductEntity.builder().userId("1").goodsId("2").source("3").channel("4").build();



        try {
            service.indexMarketTrial(marketProductEntity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
