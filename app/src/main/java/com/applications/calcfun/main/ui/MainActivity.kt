package com.applications.calcfun.main.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.applications.calcfun.databinding.ActivityMainBinding
import com.applications.calcfun.main.presentation.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModel<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.clearScore()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}