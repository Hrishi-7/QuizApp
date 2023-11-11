package com.hrishikesh.quizapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.hrishikesh.quizapp.R
import com.hrishikesh.quizapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var mAuth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mAuth = FirebaseAuth.getInstance()

        binding.btnSubmit.setOnClickListener {
            mAuth.createUserWithEmailAndPassword(
                binding.etEmail.editText?.text.toString(),
                binding.etPassword.editText?.text.toString()).addOnCompleteListener {
                    if(it.isSuccessful){
                        val intent = Intent(this, QuizActivity::class.java)
                        startActivity(intent)
                        Toast.makeText(this, "User Created", Toast.LENGTH_SHORT).show()
                    }else{

                        Toast.makeText(this, "User Not Created", Toast.LENGTH_SHORT).show()
                    }
            }
        }
    }
}