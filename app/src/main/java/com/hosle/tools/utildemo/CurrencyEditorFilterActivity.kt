package com.hosle.tools.utildemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hosle.tools.lib_utils.currency.CurrencyEditorFilter
import kotlinx.android.synthetic.main.activity_currency_editor_filter.*

class CurrencyEditorFilterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency_editor_filter)

        currency_editor.filters = arrayOf(CurrencyEditorFilter())
    }
}
