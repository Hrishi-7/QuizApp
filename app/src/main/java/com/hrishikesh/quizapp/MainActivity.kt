package com.hrishikesh.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.os.postDelayed
import com.google.firebase.auth.FirebaseAuth
import com.hrishikesh.quizapp.ui.LoginActivity
import com.hrishikesh.quizapp.ui.QuizActivity

class MainActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()

        Handler(Looper.getMainLooper()).postDelayed(3000){
            if(mAuth.currentUser!=null){
                val intent = Intent(this, QuizActivity::class.java)
                startActivity(intent)
            }else{
                val intent = Intent(this, LoginActivity::class.java)
                intent.putExtra("MODE", "SIGNUP")
                startActivity(intent)
            }
        }
    }
}