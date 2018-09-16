package com.example.leona.recyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private var wordListAdapter:WordListAdapter? = null
    private val wordList= LinkedList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (i in 0..19)
        {
                wordList.addLast("Word"+i)
        }

        wordListAdapter= WordListAdapter(this,wordList)

        recyclerview!!.adapter=wordListAdapter

        recyclerview!!.layoutManager=LinearLayoutManager(this)

        val fab =findViewById<View>(R.id.fab) as FloatingActionButton
        fab.setOnClickListener {
            val wordListSize=wordList.size

            wordList.addLast("+ Word" + wordListSize)

            recyclerview!!.adapter?.notifyItemInserted(wordListSize)

            recyclerview!!.smoothScrollToPosition(wordListSize)

        }

    }
}
