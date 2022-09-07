package com.muhammaddevin.android.quizproject

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.muhammaddevin.android.quizproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var preferenceHelper: PreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferenceHelper = PreferenceHelper(this)

        binding.btnSave.setOnClickListener {
            saveData()
        }

        binding.btnName.setOnClickListener {
            showData()
        }
    }

    private fun showData() {
        val name = preferenceHelper.getString(Constant.PREF_NAME)
        binding.tvApp.text = name
    }

    private fun saveData() {
        preferenceHelper.put(Constant.PREF_NAME, binding.edtText.text.toString())
        preferenceHelper.put(Constant.PREF_SAVE, true)
    }
}