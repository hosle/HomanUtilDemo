package com.hosle.tools.lib_utils

import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

/**
 * Created by tanjiahao on 2018/8/2
 * Original Project HomanUtilFactory
 */
class MeasureUtilTest {
    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun parseKiloMeter() {
        assertEquals("1km",MeasureUtil().parseKiloQuantity(1000.0))
        assertEquals("33m",MeasureUtil().parseKiloQuantity(33.0))
        assertEquals("0m",MeasureUtil().parseKiloQuantity(0.0))
        assertEquals("3.5m",MeasureUtil().parseKiloQuantity(3.5))
        assertEquals("0m",MeasureUtil().parseKiloQuantity(-1.0))
        assertEquals("1.03km",MeasureUtil().parseKiloQuantity(1033.0))
        assertEquals("1.29km",MeasureUtil().parseKiloQuantity(1289.0))
        assertEquals("1.26km",MeasureUtil().parseKiloQuantity(1255.0))
        assertEquals("1.2km",MeasureUtil().parseKiloQuantity(1199.0))

    }

    @Test
    fun parseKilogram() {
        assertEquals("44g",MeasureUtil().parseKiloQuantity(44.0,"kg","g"))
        assertEquals("0g",MeasureUtil().parseKiloQuantity(0.0,"kg","g"))
        assertEquals("0g",MeasureUtil().parseKiloQuantity(-1.0,"kg","g"))
        assertEquals("3.5g",MeasureUtil().parseKiloQuantity(3.5,"kg","g"))
        assertEquals("1kg",MeasureUtil().parseKiloQuantity(1000.0,"kg","g"))
        assertEquals("1.1kg",MeasureUtil().parseKiloQuantity(1099.0,"kg","g"))
        assertEquals("1.02kg",MeasureUtil().parseKiloQuantity(1022.0,"kg","g"))
        assertEquals("1.26kg",MeasureUtil().parseKiloQuantity(1255.0,"kg","g"))
    }


}