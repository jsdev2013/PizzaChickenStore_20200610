package com.jisu.pizzachickenstore_20200610.fragmentsDetail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.jisu.pizzachickenstore_20200610.BaseFragment
import com.jisu.pizzachickenstore_20200610.R
import com.jisu.pizzachickenstore_20200610.datas.Store
import kotlinx.android.synthetic.main.activity_store_list_view_detail.*
import kotlinx.android.synthetic.main.first_image_fragment.*

class FirstImgFragment : BaseFragment() {

    lateinit var mStore: Store

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.first_image_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {
        //mStore = intent.getSerializableExtra("storeData") as Store
        //Glide.with(mContext).load(mStore.itmImg).into(itmImg)

        val tmpItmImg = "https://www.pizzamaru.co.kr/resources/images/menu/gold/gol1_L_01.png"
        Glide.with(mContext).load(tmpItmImg).into(itmImg)
    }
}
