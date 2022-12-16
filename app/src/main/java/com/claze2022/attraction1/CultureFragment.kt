package com.claze2022.attraction1

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.claze2022.attraction1.databinding.FragmentCultureBinding
import com.google.android.material.navigation.NavigationBarView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


class CultureFragment : Fragment() {
     var cultureItems: MutableList<CultureItem> = mutableListOf()

    var gu:String="동대문구"

    val binding:FragmentCultureBinding by lazy {
    FragmentCultureBinding.inflate(layoutInflater)
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



        binding.spinnerGu.onItemSelectedListener= object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                var culturegu:Array<String>? = activity?.resources?.getStringArray(R.array.culturegu)
                //Toast.makeText(requireContext(), aaa!![p2], Toast.LENGTH_SHORT).show()
                gu= culturegu!![p2]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

        binding.btnCulture.setOnClickListener {

            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("http://openapi.seoul.go.kr:8088")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val retrofitService = retrofit.create(CultureRetrofitService::class.java)

            retrofitService.cultureData().enqueue(object : Callback<CultureAttraction>{
                override fun onResponse(call: Call<CultureAttraction>, response: Response<CultureAttraction>) {


                    val cultureResponse:CultureAttraction?= response.body()

                    val items:MutableList<CultureItem> = mutableListOf()

                    cultureResponse?.TbVwAttractions?.row?.forEach{
                        if(it.LANG_CODE_ID=="ko" && it.NEW_ADDRESS.contains(gu)) items.add(it)
                    }


                    binding.recyclerviewCulture.adapter = CultureAdapter(requireContext(),items)





                }

                override fun onFailure(call: Call<CultureAttraction>, t: Throwable) {
                    Toast.makeText(requireContext(), "error : ${t.message}", Toast.LENGTH_SHORT).show()
                }

            })



        }
    }

}