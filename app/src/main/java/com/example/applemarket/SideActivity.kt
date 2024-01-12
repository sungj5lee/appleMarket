package com.example.applemarket

import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.applemarket.databinding.ActivityMainBinding
import com.example.applemarket.databinding.ActivitySideBinding

class SideActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySideBinding

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySideBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mItem = intent.getParcelableExtra("itemInfo", myItem::class.java)!!

        binding.imgPost.setImageResource(mItem.aIcon)
        binding.textUsername.text = mItem.aUsername
        binding.textAdress.text = mItem.aAddress
        binding.textPostPrice.text = "%,d".format(mItem.aPrice)+"원"
        binding.textPostTitle.text = mItem.aProductName
        binding.textPostBody.text = mItem.aDescription

        binding.imgBack.setOnClickListener {
            finish()
        }
    }
}