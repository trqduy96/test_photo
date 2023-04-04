package com.example.photosample.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.photosample.presentation.R
import com.example.photosample.presentation.databinding.ActivityMainBinding
import com.example.photosample.presentation.extension.viewInflateBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(){

    private val mBinding by viewInflateBinding(ActivityMainBinding::inflate)
    private val mNavController: NavController by lazy {
        findNavController(R.id.container)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
    }

    override fun onSupportNavigateUp(): Boolean = mNavController.navigateUp()
}