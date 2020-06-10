package com.jisu.pizzachickenstore_20200610.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.jisu.pizzachickenstore_20200610.fragments.ChickenFragment
import com.jisu.pizzachickenstore_20200610.fragments.PizzaFragment
import com.jisu.pizzachickenstore_20200610.fragmentsDetail.FirstImgFragment
import com.jisu.pizzachickenstore_20200610.fragmentsDetail.SecondImgFragment

class MyPagerAdapter (fm: FragmentManager, FragmentCd :String) :FragmentPagerAdapter(fm) {

    val whichFragments = FragmentCd

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "피자 주문"
            else -> "치킨 주문"
        }
    }

    override fun getItem(position: Int): Fragment {
        return when(whichFragments){
            "List" -> when (position) {  0 -> PizzaFragment()
                                        else -> ChickenFragment()}
            else -> when (position)  {  0 -> FirstImgFragment()
                                        else -> SecondImgFragment()}
        }
    }

    override fun getCount(): Int {
        return when(whichFragments){
            "List" -> return 2
            else -> return 2
        }
    }
}