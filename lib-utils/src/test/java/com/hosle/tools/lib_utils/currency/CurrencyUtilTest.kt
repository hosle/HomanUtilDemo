package com.hosle.tools.lib_utils.currency

import org.junit.Test

import org.junit.Assert.*

/**
 * Created by tanjiahao on 2018/8/2
 * Original Project HomanUtilFactory
 */
class CurrencyUtilTest {
    @Test
    fun fen2yuan() {
        assertEquals("1", CurrencyUtil().fen2yuan("100"))
        assertEquals("-1", CurrencyUtil().fen2yuan("-100"))
        assertEquals("-1.1", CurrencyUtil().fen2yuan("-110"))
        assertEquals("-1.53", CurrencyUtil().fen2yuan("-153"))
        assertEquals(null, CurrencyUtil().fen2yuan(""))
        assertEquals("0", CurrencyUtil().fen2yuan("0"))
        assertEquals(null, CurrencyUtil().fen2yuan(null))
        assertEquals(null, CurrencyUtil().fen2yuan("345.5"))
    }

}