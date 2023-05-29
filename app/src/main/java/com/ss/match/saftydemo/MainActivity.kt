package com.ss.match.saftydemo

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import com.ss.match.saftydemo.databinding.ActivityMainBinding

class MainActivity : BaseAppCompatActivity<ActivityMainBinding>() {
    override val layoutId: Int
        get() = R.layout.activity_main

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            recordBtn.setOnTouchListener { _, event ->
                if (event.action == MotionEvent.ACTION_DOWN) {
                    fileText.visibility = View.GONE
                    fileEdit.visibility = View.GONE
                    targetText.visibility = View.GONE
                    targetEdit.visibility = View.GONE
                    recordText.visibility = View.VISIBLE
                } else if (event.action == MotionEvent.ACTION_UP) {
                    fileText.visibility = View.VISIBLE
                    fileEdit.visibility = View.VISIBLE
                    targetText.visibility = View.VISIBLE
                    targetEdit.visibility = View.VISIBLE
                    recordText.visibility = View.GONE
                }
                false
            }
            encryptBtn.setOnClickListener {
                "文件已被加密".showToast()
            }
            sendBtn.setOnClickListener {
                "文件已发送".showToast()
            }
        }
    }

    fun String.showToast(time: Int = Toast.LENGTH_SHORT) = Toast.makeText(applicationContext, this, time).show()
}

