package com.example.hollys_clone_week2

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.util.Log
import android.widget.Toast
import com.example.hollys_clone_week2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val TAG = "LIFECYCLE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Main: onCreate 호출됨")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.moreMenu.setOnClickListener {
            val intent = Intent(this, MypagenotloginActivity::class.java)

            val pref = getSharedPreferences("user_data", 0)
            val login_token = pref.getInt("login_token", 0)

            if (login_token == 1) {
                intent.putExtra("Logined", true)
            }
            startActivity(intent)
        }
    }

    //로그인되면 상단에 회원이름 함게 띄우기
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "Main: onStart 호출됨")

        val pref = getSharedPreferences("user_data", 0)
        val login_token = pref.getInt("login_token", 0)



        val ssb = SpannableStringBuilder(binding.txtMainTop.text)
        val currenttxt = binding.txtMainTop.text.toString()
        val txttoporiginal = "상큼달콤한 여름 스무디를 즐겨보세요"

        if (login_token == 1) {
            if (currenttxt== txttoporiginal) {
                val userName = pref.getString("userName", "null") + "님, "

                ssb.insert(0, userName)
                binding.txtMainTop.text = ssb
            }
        } else {
            if (currenttxt != txttoporiginal) {
                binding.txtMainTop.text = txttoporiginal
            }
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "Main: onResume 호출됨")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Main: onPause 호출됨")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "Main: onStop 호출됨")
    }

    //로그인 토큰 판단해서 1이면
    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "Main: onRestart 호출됨")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Main: onDestroy 호출됨")
    }
}