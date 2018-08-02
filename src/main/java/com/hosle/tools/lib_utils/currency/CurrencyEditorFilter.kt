package com.hosle.tools.lib_utils.currency

import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.method.DigitsKeyListener

/**
 * Created by tanjiahao on 2018/8/2
 * Original Project HomanUtilFactory
 *
 *
 * Edittext 价格过滤器,
 * 限定整数部分位数，限定小数部分精度为百分位
 *
 */
class CurrencyEditorFilter : DigitsKeyListener(false, true) {
    private var digits = 2
    private var integers = 6

    fun setDigits(d: Int): CurrencyEditorFilter {
        digits = d
        return this
    }

    fun setIntegersMaxCount(d:Int): CurrencyEditorFilter {
        integers = d
        return this
    }

    override fun filter(source: CharSequence, start: Int, end: Int,
                        dest: Spanned, dstart: Int, dend: Int): CharSequence {
        var localSource = source
        var localStart = start
        var localEnd = end
        val out = super.filter(localSource, localStart, localEnd, dest, dstart, dend)
        val dlen = dest.length

        if (out != null) {
            localSource = out
            localStart = 0
            localEnd = out.length
        }

        if (isDeleting(start,localEnd)) {
            return localSource
        }

        if (isStartWithDecimalPoint(localSource,dstart)) {
            return "0."
        }

        if (notDecimalPointFollowFirstZero(localSource,dest)) {
            return ""
        }

        if (insertFormerZero(localSource,dest,dstart)){
            return ""
        }

        val decimalPointIndex = findDecimalPointIndex(dest)

        if (insertInteger(dstart, decimalPointIndex)) {
            if (localSource.length + decimalPointIndex > integers && !localSource.startsWith('.')) {
                return ""
            }
        } else {
            if (dlen - decimalPointIndex + localSource.length > digits + 1) {
                return ""
            }
        }

        return SpannableStringBuilder(localSource, localStart, localEnd)
    }

    private fun notDecimalPointFollowFirstZero(source: CharSequence,dest: Spanned):Boolean = source.toString() != "." && dest.toString().equals("0")

    private fun isStartWithDecimalPoint(source: CharSequence,dstart: Int):Boolean = source.toString() == "." && dstart == 0

    private fun isDeleting(start: Int,end: Int):Boolean = end - start == 0

    private fun insertFormerZero(source: CharSequence, dest: Spanned, dstart: Int):Boolean = source.startsWith("0")&& dest.length>0 && dstart == 0

    private fun insertInteger(dstart: Int, decimalPointIndex: Int): Boolean = dstart <= decimalPointIndex

    private fun findDecimalPointIndex(dest: Spanned):Int{
        val dlen = dest.length

        var decimalPointIndex = Int.MAX_VALUE

        for (i in 0 until dlen) {
            if (dest[i] == '.') {
                decimalPointIndex = i
            }
        }

        if (decimalPointIndex == Int.MAX_VALUE) {
            decimalPointIndex = dlen
        }

        return decimalPointIndex
    }
}