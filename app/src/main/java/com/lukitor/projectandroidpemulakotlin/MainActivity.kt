package com.lukitor.projectandroidpemulakotlin

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val img: ImageView = findViewById(R.id.imageView2)
        Glide.with(this)
                .load(R.drawable.book)
                .into(img);

        Handler().postDelayed({
            val listData: ArrayList<User> = ArrayList<User>()

            val username = resources.getStringArray(R.array.judulnovel)
            val nama  = resources.getStringArray(R.array.nama)
            val love = resources.getStringArray(R.array.love)
            val follower = resources.getStringArray(R.array.follower)
            val following = resources.getStringArray(R.array.following)
            val location  = resources.getStringArray(R.array.location)
            val repository = resources.getStringArray(R.array.repository)
            val url  = resources.getStringArray(R.array.url)
            val company  = resources.getStringArray(R.array.company)
            val gambar = resources.getStringArray(R.array.datafoto)

            for (i in 0..(username.size - 1)){
                val temp = User()
                temp.username = username[i]
                temp.nama = nama[i]
                temp.love = love[i]
                temp.follower = follower[i]
                temp.following = following[i]
                temp.location = location[i]
                temp.repository = repository[i]
                temp.link = url[i]
                temp.company = company[i]
                val tempgambar = resources.getIdentifier(gambar[i],"drawable", packageName)
                temp.foto = tempgambar
                listData.add(temp)
            }

            val inte = Intent(this, ListUser::class.java)
            inte.putExtra("listdata", listData)
            startActivity(inte)
            finish()
        }, 5000)

    }
}