package com.jisu.pizzachickenstore_20200610

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jisu.pizzachickenstore_20200610.adapter.MyPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    lateinit var myPagerAdater: MyPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        myPagerAdater = MyPagerAdapter(supportFragmentManager, "List")
        myViewPager.adapter = myPagerAdater

        myTabLayout.setupWithViewPager(myViewPager)
    }

    override fun setValues() {

    }
}
