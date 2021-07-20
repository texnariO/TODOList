package com.example.todolist.ui.activities

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.room.Room
import com.example.todolist.R
import com.example.todolist.model.DaoNote
import com.example.todolist.model.DataBase
import com.example.todolist.model.Note
import com.example.todolist.ui.fragment.DialogFragmentNotes
import com.example.todolist.utils.DateInputMask

class AddActivity : AppCompatActivity() {

    var aAcceptBtn: Button? =null
    var aBackBtn: Button? =null
    var aNameEt: EditText? =null
    var aDateEt: EditText? =null
    var aCategorySpn: Spinner? =null
    var aDataBase: DataBase? =null
    var aNoteDao: DaoNote? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        init()
    }

    fun init(){
        aAcceptBtn = findViewById(R.id.aAcceptBtn)
        aBackBtn = findViewById(R.id.aBackBtn)

        aAcceptBtn?.setOnClickListener{
            addNote()
        }
        aBackBtn?.setOnClickListener{
            mainActivity()
        }
        aDateEt = findViewById(R.id.aDateEt)
        DateInputMask(aDateEt!!).listen()
        aNameEt = findViewById(R.id.aNameEt)
        val category = resources.getStringArray(R.array.category)
        aCategorySpn = findViewById(R.id.aCategorySpn)
        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,category)
        aCategorySpn!!.adapter = adapter
    }

    fun addNote(){
        if(aDateEt!!.text.isNotEmpty() && aNameEt!!.text.isNotEmpty()){
            aDataBase = Room.databaseBuilder(applicationContext,DataBase::class.java,"note_table").allowMainThreadQueries().build()
            aNoteDao = aDataBase!!.DaoNote()
            aNoteDao!!.insert(Note(
                aNoteDao!!.size()+1, aNameEt!!.text.toString(),aCategorySpn!!.selectedItem.toString(),
                aDateEt!!.text.toString()
            ))
            Toast.makeText(this,R.string.add,Toast.LENGTH_LONG).show()
            mainActivity()
        }
        else{
            val DialogFragment = DialogFragmentNotes()
            val manager  = supportFragmentManager
            DialogFragment.show(manager,"Dialog")
        }
    }

    fun mainActivity(){
        val intent = Intent(this@AddActivity,MainActivity::class.java)
        startActivity(intent)
    }


}