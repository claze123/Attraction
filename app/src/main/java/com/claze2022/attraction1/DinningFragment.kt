package com.claze2022.attraction1

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.claze2022.attraction1.databinding.FragmentDinningBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import kotlin.math.log

class DinningFragment : Fragment() {

    var gu : String =  "중구"

    val binding: FragmentDinningBinding by lazy {
        FragmentDinningBinding.inflate(layoutInflater)
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.spinnerGu.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                var dinninggu:Array<String>? = activity?.resources?.getStringArray(R.array.dinninggu)
                gu = dinninggu!![p2]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

        binding.btnDinning.setOnClickListener {
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("http://openapi.seoul.go.kr:8088")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val retrofitService = retrofit.create(DinningRetrofitService::class.java)

            retrofitService.dinningData().enqueue(object : Callback<DinningAttraction> {
                override fun onResponse(
                    call: Call<DinningAttraction>,
                    response: Response<DinningAttraction>
                ) {
                    val dinningResponse: DinningAttraction? = response.body()

                    val items: MutableList<DinningItem> = mutableListOf()
                    dinningResponse?.TbVwRestaurants?.row?.forEach {
                        if (it.LANG_CODE_ID == "ko"&& it.NEW_ADDRESS.contains(gu)) items.add(it)

                    }


                    binding.recyclerviewDinning.adapter = DinningAdapter(requireContext(), items)

                }


                override fun onFailure(call: Call<DinningAttraction>, t: Throwable) {

                }

            })

        }

    }


}

