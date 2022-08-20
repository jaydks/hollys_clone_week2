package com.example.hollys_clone_week2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.hollys_clone_week2.databinding.ActivityMypageloginedBinding
import com.example.hollys_clone_week2.databinding.ActivitySettingloginedBinding

class SettingloginedActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingloginedBinding
    private val TAG = "LIFECYCLE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Settinglogined: onCreate 호출됨")

        binding = ActivitySettingloginedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogout.setOnClickListener {
            val pref = getSharedPreferences("user_data", 0)
            var edit = pref.edit()
            edit.putInt("login_token", 0)
            edit.apply()
            edit.commit()
            finish()
        }

        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "Settinglogined: onStart 호출됨")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "Settinglogined: onResume 호출됨")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Settinglogined: onPause 호출됨")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "Settinglogined: onStop 호출됨")

        val pref = getSharedPreferences("user_data", 0)
        val editor = pref.edit()
        val login_token = pref.getInt("login_token", 0)

        if(login_token != 0){
            editor.remove("user_name").apply()
            editor.remove("login_token").apply()
        }

    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "Settinglogined: onRestart 호출됨")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Settinglogined: onDestroy 호출됨")
    }


}