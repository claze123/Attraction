package com.claze2022.attraction1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.claze2022.attraction1.databinding.ActivityEditBinding
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class EditActivity : AppCompatActivity() {

    val binding: ActivityEditBinding by lazy {
        ActivityEditBinding.inflate(layoutInflater)
    }

    lateinit var post_sj:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent = intent
       post_sj = intent.getStringExtra("POST_SJ").toString()
        val post_sn = intent.getStringExtra("POST_SN")

        binding.btnDone.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                val message = binding.et.text.toString()
                val retrofit: Retrofit = Retrofit.Builder()
                    .baseUrl("http://sjflkj.dothome.co.kr/")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                val retrofitService = retrofit.create(DothomeInterface::class.java)
                Log.d("TAG", "$post_sn, $post_sj")
                retrofitService.dothomeData(message,post_sn!!,post_sj!!,).enqueue(object : Callback<String>{
                    override fun onResponse(
                        call: Call<String>,
                        response: Response<String>
                    ) {
                      val result = response.body()
                        Toast.makeText(this@EditActivity,"응답글자:$result", Toast.LENGTH_SHORT).show()
                    }

                    override fun onFailure(call: Call<String>, t: Throwable) {
                        Toast.makeText(this@EditActivity, t.message, Toast.LENGTH_SHORT).show()
                    }

                })


                val intent = Intent(this@EditActivity, BoardActivity::class.java)
                intent.putExtra("POST_SJ",post_sj)
                startActivity(intent)

            }

        })
    }
}