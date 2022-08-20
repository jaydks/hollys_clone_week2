package com.example.hollys_clone_week2

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.hollys_clone_week2.databinding.ActivityLoginBinding
import com.example.hollys_clone_week2.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {


    private lateinit var binding: ActivityLoginBinding
    private lateinit var sharedPreferences: SharedPreferences
    private val TAG = "LIFECYCLE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Login: onStart 호출됨")

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // 저장된 데이터와 이이디, 비밀번호 일치하면 로그인로큰 = 1로 뱌꾸고 화면 전환
        binding.btnLogin.setOnClickListener {
            var pref = getSharedPreferences("user_data", 0)
            var edit = pref.edit()

            val enterID = binding.enterid.text.toString()
            val enterPW = binding.enterpw.text.toString()
            run {
                UserInfoList.forEach {
                    if (enterID == it.userID && enterPW == it.userPW) {
                        edit.putInt("login_token", 1)
                        val userName = it.userName
                        edit.putString("userName", userName)
                        edit.apply()
                        finish()
                    }
                    Toast.makeText(this, "다시 입력해주세요", Toast.LENGTH_SHORT).show()
                }
            }

        }
        binding.imgBack.setOnClickListener {
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "Login: onStart 호출됨")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "Login: onResume 호출됨")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Login: onPause 호출됨")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "Login: onStop 호출됨")
    }

    //화면 restart시 텍스트 초기화
    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "Login: onRestart 호출됨")

        binding.enterid.setText("")
        binding.enterpw.setText("")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Login: onDestroy 호출됨")
    }
}