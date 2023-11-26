package com.example.sortingalgorithms.presentation.noobsort

import android.content.RestrictionEntry.TYPE_NULL
import android.graphics.Color
import android.text.InputType
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import com.example.sortingalgorithms.utils.constants.MS0
import com.example.sortingalgorithms.utils.constants.MS5
import com.example.sortingalgorithms.utils.extensions.SortCompletionListener
import com.example.sortingalgorithms.utils.extensions.Speed
import java.lang.Exception
import java.text.ParseException

class NoobSort(
    private var editTextViewList: ArrayList<EditText>,
    private val completionListener: SortCompletionListener
) : Thread() {

    override fun run() {
        val x = editTextViewList.size
        //disabling editText functionalities during the sorting
        for (i in (0 until x)) {
            editTextViewList[i].isFocusable = true
            editTextViewList[i].isFocusableInTouchMode = false
            editTextViewList[i].inputType = TYPE_NULL
        }
        for (i in (0..(x - 2))) {
            for (j in ((i + 1) until x)) {
                //setting colours to greens to show user which numbers are compared
                editTextViewList[i].setBackgroundColor(Color.parseColor("#00FF00"))
                editTextViewList[j].setBackgroundColor(Color.parseColor("#00FF00"))
                //fetching numbers from editText views
                val a = Integer.parseInt(editTextViewList[i].text.toString())
                val b = Integer.parseInt(editTextViewList[j].text.toString())
                //giving user some time to see which numbers compared
                Thread.sleep((MS5 / Speed.speed).toLong())
                if (a > b) {
                    //setting colors to red to show user, numbers are gonna swapped
                    editTextViewList[i].setBackgroundColor(Color.parseColor("#FF0000"))
                    editTextViewList[j].setBackgroundColor(Color.parseColor("#FF0000"))
                    //swapping in the list
                    val temp = editTextViewList[i]
                    editTextViewList[i] = editTextViewList[j]
                    editTextViewList[j] = temp
                    //swapping in screen
                    swapTextViewsLocations(editTextViewList[i], editTextViewList[j])
                    //giving user enough time see the swapping
                    Thread.sleep((MS5 / Speed.speed).toLong())
                } else {
                    Thread.sleep((MS0 / Speed.speed).toLong())
                }
                //setting colors to initials
                editTextViewList[i].setBackgroundColor(Color.parseColor("#1313AF"))
                editTextViewList[j].setBackgroundColor(Color.parseColor("#1313AF"))
            }
        }
        //reassigning editText functionalities
        for (i in (0 until x)) {
            editTextViewList[i].isFocusableInTouchMode = true
            editTextViewList[i].inputType = InputType.TYPE_CLASS_NUMBER
        }
        completionListener.onSortCompleted()
    }

    private fun swapTextViewsLocations(editTextView: EditText, editTextView2: EditText) {
        Log.i("location", " pre textView location: " + editTextView.x + "," + editTextView.y)
        Log.i("location", " pre textView2 location: " + editTextView2.x + "," + editTextView2.y)
        val tempX = editTextView.x
        val tempY = editTextView.y
        editTextView.x = editTextView2.x
        editTextView.y = editTextView2.y
        editTextView2.x = tempX
        editTextView2.y = tempY
        Log.i("location", " post textView location: " + editTextView.x + "," + editTextView.y)
        Log.i("location", " post textView2 location: " + editTextView2.x + "," + editTextView2.y)

    }

}