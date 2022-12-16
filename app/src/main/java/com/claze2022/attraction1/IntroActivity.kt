package com.claze2022.attraction1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.claze2022.attraction1.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {

    val binding : ActivityIntroBinding by lazy{
        ActivityIntroBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed(object : Runnable{
            override fun run() {
                var intent : Intent = Intent(this@IntroActivity, MainActivity::class.java)
                startActivity(intent)
            }
        },3000)






    }
}