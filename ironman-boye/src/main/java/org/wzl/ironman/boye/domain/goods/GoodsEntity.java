package org.wzl.ironman.boye.domain.goods;

import cn.hutool.core.util.ObjectUtil;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.wzl.ironman.boye.service.GoodsService;

/**
 * 商品
 *
 * @author wangzhilei@tinman.cn
 * @date 2022/08/20
 */
@Slf4j
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoodsEntity {

    /**
     * 成本(单位：欧元)
     */
    private BigDecimal cost;

    /**
     * 成本因子
     */
    private BigDecimal costFactor;

    /**
     * 物流费用
     */
    private BigDecimal logisticsCost;

    /**
     * 物流因子，用以控制物流成本(比如：物流因子1，表示正常保准 800， 因子乘以800即为物流成本)
     */
    private String logisticsFactor;

    /**
     * 最长尺寸
     */
    private Integer longestSize;

    /**
     * 跳蚤标记
     */
    private Integer fleaFlag;


    /**
     * 易碎品类型
     */
    private String breakablesType;

    /**
     * 是否易碎品 1是  0否
     */
    private Integer fragile;

    public String calculatePrice() {
        if (fragile.equals(0)) {
            return cost.multiply(costFactor)
                .add(logisticsCost).toString();
        }
        String breakablesCost = "0";
        // 1 雕塑。 2。 瓷器。 3。 座钟。 4。 水晶
        if ("1".equals(breakablesType)) {
            // 雕塑中件
            if (longestSize.equals(2)) {
                breakablesCost = "1000";
            } else if (longestSize.equals(3)) {
                // 大件  已含货物原本超重附加运费500
                breakablesCost = "2000";
            }
        }
        // 座钟
        else if ("3".equals(breakablesType)) {
            breakablesCost = "1500";
        }
        // 水晶（6件及以上）
        else if ("4".equals(breakablesType)) {
            breakablesCost = "1000";
        }
        // 水晶（6件以下）
        else if ("5".equals(breakablesType)) {
            breakablesCost = "0";
        } else {
            // 瓷器中件
            if (longestSize.equals(2)) {
                breakablesCost = "1000";
            } else if (longestSize.equals(3)) {
                // 大件
                breakablesCost = "1500";
            }
        }

        return cost.multiply(costFactor)
            .add(logisticsCost).add(new BigDecimal(breakablesCost)).toString();
    }


    /**
     * 转换物流费用
     *
     * @return {@link GoodsEntity}
     */
    public GoodsEntity convertLogistics() {
        if (longestSize.equals(1)) {
            this.logisticsCost = new BigDecimal(500);
        } else if (longestSize.equals(2)) {
            this.logisticsCost = new BigDecimal(800);
        } else if (longestSize.equals(3)) {
            this.logisticsCost = new BigDecimal(1000);
        } else {
            this.logisticsCost = BigDecimal.ZERO;
            log.warn("尺寸大于90，需要顾客自己支付运费!");
        }
        return this;
    }

    /**
     * 转换商品因子
     *
     * @return {@link GoodsEntity}
     */
    public GoodsEntity convertGoodsFactor() {
        // 是跳蚤市场
        if (fleaFlag.equals(1)) {
            if (cost.compareTo(BigDecimal.valueOf(100)) < 0) {
                this.costFactor = BigDecimal.TEN;
            } else {
                this.costFactor = BigDecimal.valueOf(12);
            }
        } else {
            if (cost.compareTo(BigDecimal.valueOf(200)) < 0) {
                this.costFactor = BigDecimal.valueOf(15);
            } else if (cost.compareTo(BigDecimal.valueOf(1500)) < 0) {
                this.costFactor = BigDecimal.valueOf(13);
            } else {
                this.costFactor = BigDecimal.valueOf(15);
            }
        }
        costFactor = costFactor.add(new BigDecimal("1"));
        return this;
    }
}
