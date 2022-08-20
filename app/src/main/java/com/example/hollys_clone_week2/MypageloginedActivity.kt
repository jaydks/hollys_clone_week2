package com.example.hollys_clone_week2

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.util.Log
import android.widget.Toast
import com.example.hollys_clone_week2.databinding.ActivityLoginBinding
import com.example.hollys_clone_week2.databinding.ActivityMypageloginedBinding

class MypageloginedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMypageloginedBinding
    private val TAG = "LIFECYCLE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Mypagelogined: onCreate 호출됨")

        binding = ActivityMypageloginedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSetting.setOnClickListener {
            val intent = Intent(this, SettingloginedActivity::class.java)
            startActivity(intent)
        }

        binding.imgClose.setOnClickListener {
            finish()
        }

        val ssb = SpannableStringBuilder(binding.btnLoginLogined.text)

        ssb.setSpan(
            StyleSpan(Typeface.BOLD),
            0,
            3,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        binding.btnLoginLogined.text = ssb



    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "Mypagelogined: onStart 호출됨")

        val pref = getSharedPreferences("user_data", 0)
        val login_token = pref.getInt("login_token", 0)

        if(login_token != 1){
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "Mypagelogined: onResume 호출됨")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Mypagelogined: onPause 호출됨")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "Mypagelogined: onStop 호출됨")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "Mypagelogined: onRestart 호출됨")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Mypagelogined: onDestroy 호출됨")
    }
}