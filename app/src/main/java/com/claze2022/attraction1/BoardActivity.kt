package com.claze2022.attraction1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.claze2022.attraction1.databinding.ActivityBoardBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class BoardActivity : AppCompatActivity() {

    val binding:ActivityBoardBinding by lazy {
        ActivityBoardBinding.inflate(layoutInflater)
    }

    lateinit var post_sj:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        post_sj= intent.getStringExtra("POST_SJ").toString()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://sjflkj.dothome.co.kr/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofitService = retrofit.create(Dothome2Interface::class.java)

        retrofitService.dothome2Data(post_sj).enqueue(object:Callback<MutableList<BoardItem>>{
            override fun onResponse(
                call: Call<MutableList<BoardItem>>,
                response: Response<MutableList<BoardItem>>
            ) {
                binding.recyclerviewBoard.adapter = BoardAdapter(this@BoardActivity, response.body()!!)
            }

            override fun onFailure(call: Call<MutableList<BoardItem>>, t: Throwable) {

            }

        })
    }

}