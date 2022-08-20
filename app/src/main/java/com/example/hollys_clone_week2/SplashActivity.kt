package com.example.hollys_clone_week2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import com.example.hollys_clone_week2.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private val TAG = "LIFECYCLE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Splash: onCreate 호출됨")
        Toast.makeText(this,"Splash onCreate", Toast.LENGTH_SHORT).show()
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var handler = Handler()

        handler.postDelayed({
                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
        }, 500)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "Splash: onStart 호출됨")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "Splash: onResume 호출됨")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Splash: onPause 호출됨")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "Splash: onStop 호출됨")
        Toast.makeText(this,"Splash onStop", Toast.LENGTH_SHORT).show()
        finish()
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "Splash: onRestart 호출됨")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Splash: onDestroy 호출됨")
    }

}