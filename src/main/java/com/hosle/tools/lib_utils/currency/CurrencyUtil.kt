package com.hosle.tools.lib_utils.currency

import java.math.BigDecimal

/**
 * Created by tanjiahao on 2018/8/2
 * Original Project HomanUtilFactory
 */
class CurrencyUtil {

    /**
     * 货币数量 单位分统一换算成单位元，支持负数
     *
     * e.g.
     *
     * 1000,单位分 -> 10,单位元
     *
     */
    fun fen2yuan(num: String?): String? {
        if (num == null || num.isEmpty())
            return null

        if (num.contains('.'))
            return null

        val divider = BigDecimal("100")
        val floatAmountBigD = BigDecimal(num)

        if (floatAmountBigD == BigDecimal.ZERO) {
            return "0"
        }

        return floatAmountBigD.divide(divider).toString()
    }
}