package com.example.grammarlyinterview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*
import java.util.*
import kotlin.concurrent.timerTask

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var mainAdapter:MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView= findViewById(R.id.recyclerView)

        mainAdapter = MainAdapter(this)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=mainAdapter
//        GlobalScope.async {
//            update()
//        }
        var timer=Timer()
        timer.schedule(
        timerTask {
            while(true){
                Thread.sleep(1000)
                i++
                Log.e("i",i.toString())
                runOnUiThread {
                    updateUI()
                }
               //


            }
        },1000)

    }

    var i:Int = 0
    fun update() {
        //awaitAll(1000)
        while(true){
            Thread.sleep(1000)
            i++
            Log.e("i",i.toString())
           // updateUI()


        }


    }
    fun updateUI() {
        mainAdapter.updateList(i)
    }
}
// make the recylerview works
// set task, update the value every second
// set onclickListener on each item, so it would update or not.