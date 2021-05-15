package com.lukitor.projectandroidpemulakotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import com.bumptech.glide.Glide

class LoadDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load_detail)
        val img: ImageView = findViewById(R.id.imageLoadDetail)

        Glide.with(this)
            .load(R.drawable.load1)
            .into(img);

        Handler().postDelayed({
            val tipe = intent.getStringExtra("tipe")
            if (tipe == "1"){
                finish()
            }
            else{
                val inte = Intent(this, DetailUser::class.java)
                val data = intent.getParcelableExtra<User>("data") as User
                inte.putExtra("data",data)
                startActivity(inte)
                finish()
            }
        }, 2000)
    }
}