package com.example.photosample.domain.base.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.photosample.domain.base.view.IView

abstract class BaseActivity : AppCompatActivity(), IView{

    abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
    }
}