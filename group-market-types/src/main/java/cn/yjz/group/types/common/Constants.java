package cn.yjz.group.types.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class Constants {

    public final static String SPLIT = ",";

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public enum ResponseCode {

        SUCCESS("0000", "成功"),
        UN_ERROR("0001", "未知失败"),
        ILLEGAL_PARAMETER("0002", "非法参数"),
        ACTIVITY_NODE_ERROR("0003", "活动节点异常"),
        E0001("E0001", "不存在对应的折扣计算服务"),
        ;

        private String code;
        private String info;

    }

}
