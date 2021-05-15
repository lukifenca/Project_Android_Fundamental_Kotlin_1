package com.lukitor.projectandroidpemulakotlin

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailUser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_novel)
        val dataobj = intent.getParcelableExtra<User>("data") as User

        val gambarg: ImageView = findViewById(R.id.gambar_detail)
        val userg: TextView = findViewById(R.id.username_detail)
        val namag: TextView = findViewById(R.id.nama_detail)
        val folower: TextView = findViewById(R.id.txtfollower)
        val folowing: TextView = findViewById(R.id.txtfollowing)
        val location: TextView = findViewById(R.id.txtlocation)
        val repository: TextView = findViewById(R.id.txtrepository)
        val company: TextView = findViewById(R.id.txtcompany)

        userg.text = Html.fromHtml("<u>${dataobj.username}</u>")
        namag.text = dataobj.nama
        gambarg.setImageResource(dataobj.foto)
        folower.text = dataobj.follower
        folowing.text = dataobj.following
        location.text = dataobj.location
        company.text = dataobj.company
        repository.text = dataobj.repository

        val btn: Button = findViewById(R.id.btnMenu)
        btn.setOnClickListener(View.OnClickListener { view ->
            val intent = Intent(this, LoadDetail::class.java)
            intent.putExtra("tipe","1")
            startActivity(intent)
            finish()
        })

        userg.setOnClickListener(View.OnClickListener { view ->
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(dataobj.link)
            startActivity(intent)
        })
    }
}