package com.example.hollys_clone_week2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.hollys_clone_week2.databinding.ActivityMainBinding
import com.example.hollys_clone_week2.databinding.ActivityMypagenotloginBinding

class MypagenotloginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMypagenotloginBinding
    private val TAG = "LIFECYCLE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "MypageNotlogin: onCreate 호출됨")

        binding = ActivityMypagenotloginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.btnClose.setOnClickListener {
            finish()
        }
    }

    //logintoken ==1 and logined가 == true이면 loginmypage로 이동하고 finish()
    //logintoken ==1이기만 하면 finish()
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "MypageNotlogin: onStart 호출됨")

        val pref = getSharedPreferences("user_data", 0)
        val login_token = pref.getInt("login_token", 0)

        if(login_token == 1) {
            if(intent.getBooleanExtra("Logined", false) == true){
                val intent = Intent(this, MypageloginedActivity::class.java)
                startActivity(intent)
                finish()
            }
            else finish()
        }

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "MypageNotlogin: onResume 호출됨")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "MypageNotlogin: onPause 호출됨")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "MypageNotlogin: onStop 호출됨")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "MypageNotlogin: onRestart 호출됨")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "MypageNotlogin: onDestroy 호출됨")
    }
}