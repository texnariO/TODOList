package com.example.todolist.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.todolist.R
import com.example.todolist.model.DaoNote
import com.example.todolist.model.DataBase
import com.example.todolist.ui.adapters.NoteAdapter
import com.melnykov.fab.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {
    var mAddBtn: FloatingActionButton? = null
    var mEmptyTv: TextView? = null
    var mListRv: RecyclerView? = null
    var mNoteAdapter: NoteAdapter? =null
    var mDataBase: DataBase? =null
    var mNoteDao: DaoNote? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun init(){
        mDataBase = Room.databaseBuilder(applicationContext,DataBase::class.java,"note_table").allowMainThreadQueries().build()
        mEmptyTv = findViewById(R.id.mEmptyTv)
        mListRv = findViewById(R.id.mListRv)
        mNoteDao = mDataBase!!.DaoNote()
        if(mNoteDao!!.size()==0){
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

    fun viewList(){
        mNoteAdapter = NoteAdapter(mNoteDao!!.getAllNotes())
        mListRv!!.visibility = View.VISIBLE
        mEmptyTv!!.visibility = View.GONE
        mListRv!!.layoutManager = LinearLayoutManager(this)
        mListRv!!.adapter = mNoteAdapter
    }

}