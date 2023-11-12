package com.hrishikesh.quizapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hrishikesh.quizapp.R
import com.hrishikesh.quizapp.databinding.ActivityQuizBinding
import com.hrishikesh.quizapp.di.QuestionModel

class QuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizBinding
    private lateinit var list : ArrayList<QuestionModel>
    private var count : Int = 0
    private var score : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list = ArrayList<QuestionModel>()
        list.add(
            QuestionModel("Who is the P.M of India?",
            "Narendra Modi",
            "Amit Shah",
            "Adityanath Yogi",
            "Rahul Gandhi",
            "Narendra Modi"))

        list.add(QuestionModel("Who is the P.M of India?",
            "Narendra Modi",
            "Amit Shah",
            "Adityanath Yogi",
            "Rahul Gandhi",
            "Narendra Modi"))

        list.add(QuestionModel("Who is the P.M of India?",
            "Narendra Modi",
            "Amit Shah",
            "Adityanath Yogi",
            "Rahul Gandhi",
            "Narendra Modi"))

        list.add(QuestionModel("Who is the P.M of India?",
            "Narendra Modi",
            "Amit Shah",
            "Adityanath Yogi",
            "Rahul Gandhi",
            "Narendra Modi"))

        list.add(QuestionModel("Who is the P.M of India?",
            "Narendra Modi",
            "Amit Shah",
            "Adityanath Yogi",
            "Rahul Gandhi",
            "Narendra Modi"))

        binding.tvQuestion.setText(list.get(0).question)
        binding.btnOption1.setText(list.get(0).option1)
        binding.btnOption2.setText(list.get(0).option2)
        binding.btnOption3.setText(list.get(0).option3)
        binding.btnOption4.setText(list.get(0).option4)

        binding.btnOption1.setOnClickListener {
            nextData(binding.btnOption1.text.toString())
        }

        binding.btnOption2.setOnClickListener {
            nextData(binding.btnOption2.text.toString())
        }

        binding.btnOption3.setOnClickListener {
            nextData(binding.btnOption3.text.toString())
        }

        binding.btnOption4.setOnClickListener {
            nextData(binding.btnOption4.text.toString())
        }
    }

    private fun nextData(i: String) {
        if(count<list.size){
            if(i.equals(list.get(count).ans)){
                score++
            }
        }
        count++
        if(count>=list.size){
            val intent = Intent(this@QuizActivity, ScoreActivity::class.java)
            intent.putExtra("SCORE", score)
            startActivity(intent)
            Toast.makeText(this@QuizActivity, "Your Score $score", Toast.LENGTH_LONG).show()
        }else{
            binding.progressBarQuestion.progress = (count/list.size)*100
            binding.tvQuestion.setText(list.get(count).question)
            binding.btnOption1.setText(list.get(count).option1)
            binding.btnOption2.setText(list.get(count).option2)
            binding.btnOption3.setText(list.get(count).option3)
            binding.btnOption4.setText(list.get(count).option4)
        }

    }
}