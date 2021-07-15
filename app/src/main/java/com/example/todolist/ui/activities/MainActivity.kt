package com.example.todolist.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.model.DataBase
import com.example.todolist.utils.NoteAdapter
import com.melnykov.fab.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {
    var mAddBtn: FloatingActionButton? = null
    var mEmptyTv: TextView? = null
    var mListRv: RecyclerView? = null
    var mNoteAdapter: NoteAdapter? =null
    var mDataBase: DataBase? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun init(){
        mDataBase = DataBase.getDatabase(this.application)
        mEmptyTv = findViewById(R.id.mEmptyTv)
        mListRv = findViewById(R.id.mListRv)
        val size = mDataBase!!.DaoNote().size()
        println("**********************")
        println(size)
        if(true){
            mListRv!!.visibility = View.GONE
            mEmptyTv!!.visibility = View.VISIBLE
        }
        else{
            viewList()
        }
        mAddBtn = findViewById(R.id.mAddBtn)
        mAddBtn!!.attachToRecyclerView(mListRv!!)
        mAddBtn!!.setOnClickListener {
            val intent = Intent(this@MainActivity, AddActivity::class.java)
            startActivity(intent)
        }
    }
    //TODO
    fun viewList(){

    }

}