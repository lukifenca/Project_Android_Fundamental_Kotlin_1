package com.lukitor.projectandroidpemulakotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_list_novel.*

class ListUser : AppCompatActivity() {
    val listData: ArrayList<User> = ArrayList<User>()
    private lateinit var rvHeroes: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_novel)

        supportActionBar?.setTitle("List User")
        supportActionBar?.setSubtitle("Daftar Seluruh User")

        if (intent.extras != null){
            val listDataTemp: ArrayList<User> = intent.getParcelableArrayListExtra<User>("listdata") as ArrayList<User>
            for (item in listDataTemp) listData.add(item)
        }

        rvHeroes = findViewById(R.id.rvList)
        rvHeroes.setHasFixedSize(true)
        showRecyclerCardView()
    }

    private fun showRecyclerCardView() {
        rvList.layoutManager = LinearLayoutManager(this)
        val cardViewUserAdapter: CardViewUserAdapter = CardViewUserAdapter(listData)
        rvList.adapter = cardViewUserAdapter

        val inte = Intent(this, LoadDetail::class.java)
        cardViewUserAdapter.setOnItemClickCallback(object: CardViewUserAdapter.OnItemClickCallback{
            override fun onItemClicked(data: User) {
                inte.putExtra("data", data)
                inte.putExtra("username", data.username)
                inte.putExtra("tipe","2")
                startActivity(inte)
            }
        })
        cardViewUserAdapter.setOnItemClickCallbackk(object: CardViewUserAdapter.OnItemClickCallback{
            override fun onItemClicked(data: User) {
                if (data.love == "0") data.love = "1"
                else data.love = "0"
                cardViewUserAdapter!!.notifyDataSetChanged()
            }
        })
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.profilee,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.item_profile){
            val intent = Intent(this, Load::class.java)
            intent.putExtra("tipe","2")
            startActivity(intent)
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}