package com.example.todolist.ui.fragment

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.todolist.R
import java.lang.IllegalStateException

class DialogFragmentNotes: DialogFragment()  {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle(R.string.error).setMessage(R.string.error_mes).setPositiveButton(R.string.ok){
                dialog, id ->dialog.cancel()
            }
            builder.create()
        }?: throw IllegalStateException("Activity cannot be null")
    }
}