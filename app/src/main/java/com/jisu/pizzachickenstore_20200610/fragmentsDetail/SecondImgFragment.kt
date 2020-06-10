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
import kotlinx.android.synthetic.main.second_image_fragment.*

class SecondImgFragment : BaseFragment() {

    lateinit var mStore: Store

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.second_image_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

        val tmpItmImg = "https://www.pizzaetang.com/resources/images/menu/menuinfo/NEW_pz_dal_l.png"
        Glide.with(mContext).load(tmpItmImg).into(itmImg)
    }
}
