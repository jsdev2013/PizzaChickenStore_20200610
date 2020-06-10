package com.jisu.pizzachickenstore_20200610.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jisu.pizzachickenstore_20200610.BaseFragment
import com.jisu.pizzachickenstore_20200610.R
import com.jisu.pizzachickenstore_20200610.StoreListViewDetailActivity
import com.jisu.pizzachickenstore_20200610.adapter.StoreAdapter
import com.jisu.pizzachickenstore_20200610.datas.Store
import kotlinx.android.synthetic.main.chicken_fragment.*

class ChickenFragment : BaseFragment() {

    val stores = ArrayList<Store>()
    lateinit var storeAdapter : StoreAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.chicken_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        chickenStoreListView.setOnItemClickListener { parent, view, position, id ->
            val clickedStore = stores[position]

            val myIntent = Intent(mContext, StoreListViewDetailActivity::class.java)
            myIntent.putExtra("storeData", clickedStore)
            startActivity(myIntent)
        }
    }

    override fun setValues() {

        val pizzahutLogUrl = "https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FnkQca%2FbtqwVT4rrZo%2FymhFqW9uRbzrmZTxUU1QC1%2Fimg.jpg"
        val papazonsLogUrl = "http://mblogthumb2.phinf.naver.net/20160530_65/ppanppane_1464617766007O9b5u_PNG/%C6%C4%C6%C4%C1%B8%BD%BA_%C7%C7%C0%DA_%B7%CE%B0%ED_%284%29.png?type=w800"
        val misterLogUrl = "https://post-phinf.pstatic.net/MjAxODEyMDVfMzYg/MDAxNTQzOTYxOTA4NjM3.8gsStnhxz7eEc9zpt5nmSRZmI-Pzpl4NJvHYU-Dlgmcg.7Vpgk0lopJ5GoTav3CUDqmXi2-_67S5AXD0AGbbR6J4g.JPEG/IMG_1641.jpg?type=w1200"
        val dominoLogUrl = "https://pbs.twimg.com/profile_images/1098371010548555776/trCrCTDN_400x400.png"

        val itmLogUrl = "https://www.pizzamaru.co.kr/resources/images/menu/gold/gol1_L_01.png"

        stores.add(Store(pizzahutLogUrl, itmLogUrl,"교촌치킨","1588-5588"))
        stores.add(Store(papazonsLogUrl, itmLogUrl, "네네치킨","1577-8080"))
        stores.add(Store(misterLogUrl, itmLogUrl, "BBQ","1577-0077"))
        stores.add(Store(dominoLogUrl, itmLogUrl, "굽네치킨","1577-3082"))

        storeAdapter = StoreAdapter(
            mContext,
            R.layout.store_list_item, stores
        )
        chickenStoreListView.adapter = storeAdapter
    }
}
