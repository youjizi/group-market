package cn.yjz.group.infrastructure.persistent.po;


import lombok.*;

import java.util.Date;

/**
 * @author 李白
 * @date 2024-12-10
 * @description 团购活动实体类
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GroupBuyActivity {

    /** 自增ID */
    private Long id;

    /** 活动ID */
    private Long activityId;

    /** 活动名称 */
    private String activityName;

    /** 来源 */
    private String source;

    /** 渠道 */
    private String channel;

    /** 商品ID */
    private String goodsId;

    /** 折扣ID */
    private String discountId;

    /** 拼团方式【0自动成团、1达成目标成团】 */
    private Integer groupType;

    /** 参与次数限制 */
    private Integer takeLimitCount;

    /** 达成目标【3人单、5人单】 */
    private Integer target;

    /** 拼团时长【有效时间、10分钟、30分钟】 */
    private Integer validTime;

    /** 活动状态【0 开始 1 未开始】 */
    private Integer status;

    /** 开始时间 */
    private Date startTime;

    /** 结束时间 */
    private Date endTime;

    /** 人群标签规则标识 */
    private String tagId;

    /** 人群标签规则范围【多选、可见、参与】 */
    private String tagScope;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;


}
