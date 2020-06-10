package com.jisu.pizzachickenstore_20200610

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import com.jisu.pizzachickenstore_20200610.adapter.MyPagerAdapter
import com.jisu.pizzachickenstore_20200610.datas.Store
import kotlinx.android.synthetic.main.activity_store_list_view_detail.*

class StoreListViewDetailActivity : BaseActivity() {

    lateinit var myPagerAdater: MyPagerAdapter
    lateinit var mStore:Store

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_list_view_detail)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        myPagerAdater = MyPagerAdapter(supportFragmentManager, "ImgDetail")
        imgViewPager.adapter = myPagerAdater

        telBtn.setOnClickListener {

            //https://github.com/ParkSangGwon/TedPermission
            val pl = object : PermissionListener {
                override fun onPermissionGranted() {
                    // 허가가 나면 실행할 내용
                    val myUri = Uri.parse("tel:${storeTel.text}")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    // 거부되면
                    Toast.makeText(mContext, "전화 권한이 거부되어 통화할 수 없습니다.", Toast.LENGTH_SHORT).show()
                }
            }

            TedPermission.with(mContext)
                .setPermissionListener(pl)
                .setDeniedMessage("권한을 거부하면 통화할 수 없습니다. [설정]->[권한]에서 권한 설정을 해주시기 바랍니다.")
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()

        }
    }

    override fun setValues() {
        mStore = intent.getSerializableExtra("storeData") as Store

        Glide.with(mContext).load(mStore.logoImg).into(logoImg)
        storeNm.text = mStore.storeNm
        storeTel.text = mStore.storeTel
    }
}
