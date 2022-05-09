package com.example.tip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView



private const val MAC_DINH = 15
class MainActivity : AppCompatActivity() {
    private  lateinit var etBaseAmount: EditText
    private  lateinit var seekBar: SeekBar
    private  lateinit var tvTipPercent: TextView
    private  lateinit var tvTipAmount: TextView
    private  lateinit var tvTotalAmount: TextView
    private  lateinit var tvTipD: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        seekBar = findViewById(R.id.seekBar)
        tvTipPercent = findViewById(R.id.tvTipPercentLabel)
        tvTipAmount = findViewById(R.id.tvTipAmount)
        tvTotalAmount = findViewById(R.id.tvTotalAmount)
        etBaseAmount = findViewById(R.id.etBaseAmount)
        tvTipD = findViewById(R.id.tvTipD)

        updateDes(MAC_DINH)
        seekBar.progress = MAC_DINH;
        tvTipPercent.text = "$MAC_DINH%"
        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                tvTipPercent.text = "$p1%"
                computeTipAndTotal()
                updateDes(p1)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
        etBaseAmount.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                computeTipAndTotal()
            }

        })
    }

    private fun updateDes(tip : Int) {
        val tipDescription = when (tip) {
            in 0..9 -> "Poor"
            in 10..14 -> "Acceptable"
            in 15..19 -> "Good"
            in 20..24 -> "Great"
            else -> "Amazing"
        }
        tvTipD.text = tipDescription
    }

    private fun computeTipAndTotal() {
        if (etBaseAmount.text.isEmpty()) {
            tvTipAmount.text = ""
            tvTotalAmount.text = ""
            return
        }
        // get the value

        val baseAmount = etBaseAmount.text.toString().toDouble()
        val tipPercent = seekBar.progress

        // compute
        val tipAmount = baseAmount * tipPercent / 100
        val totalAmount = baseAmount + tipAmount

        // update
        tvTipAmount.text = "%.2f".format(tipAmount)
        tvTotalAmount.text =  "%.2f".format(totalAmount)


    }
}