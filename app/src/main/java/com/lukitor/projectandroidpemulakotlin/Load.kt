package com.lukitor.projectandroidpemulakotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import com.bumptech.glide.Glide

class Load : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load)

        val img: ImageView = findViewById(R.id.imageLoad)

        Glide.with(this)
            .load(R.drawable.load)
            .into(img)

        Handler().postDelayed({
            val tipe = intent.getStringExtra("tipe")
            if (tipe == "1") startActivity(Intent(this, ListUser::class.java))
            else startActivity(Intent(this, Profile::class.java))
            finish()
        }, 4000)
    }
}