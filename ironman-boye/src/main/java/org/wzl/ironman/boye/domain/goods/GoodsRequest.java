package org.wzl.ironman.boye.domain.goods;

import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商品
 *
 * @author wangzhilei@tinman.cn
 * @date 2022/08/20
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoodsRequest {

    /**
     * 成本
     */
    @NotNull(message = "成本不能为空")
    private String cost;

    /**
     * 最长尺寸
     */
    @NotNull(message = "商品最长尺寸必填哦,亲!")
    private Integer longestSize;

    /**
     * 跳蚤标记 1是  0否
     */
    @NotNull(message = "是否跳蚤标记必填哦,亲!")
    private Integer fleaFlag;

    /**
     * 是否易碎品 1是  0否
     */
    @NotNull(message = "是否易碎品必填哦,亲!")
    private Integer fragile;

    private String price;

    /**
     * 易碎品类型
     */
    private String breakablesType;

    public GoodsEntity convertGoodsEntity() {
        return GoodsEntity.builder()
            .cost(new BigDecimal(this.cost))
            .longestSize(this.longestSize)
            .fleaFlag(this.fleaFlag)
            .breakablesType(this.breakablesType)
            .fragile(this.fragile)
            .build();
    }

}
