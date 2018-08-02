package com.hosle.tools.utildemo

import android.app.Activity
import android.content.Intent

/**
 * Created by tanjiahao on 2018/8/2
 * Original Project HomanUtilFactory
 */

fun navigateToCurrencyEditor(activity: Activity){
    activity.startActivity(Intent(activity,CurrencyEditorFilterActivity::class.java))
}