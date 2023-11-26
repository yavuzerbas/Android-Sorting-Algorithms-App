package com.example.sortingalgorithms.presentation.insertionsort

import android.content.RestrictionEntry
import android.graphics.Color
import android.text.InputType
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.example.sortingalgorithms.utils.constants.MS5
import com.example.sortingalgorithms.utils.extensions.SortCompletionListener
import com.example.sortingalgorithms.utils.extensions.Speed

class InsertionSort
    (
    private var editTextViewList: ArrayList<EditText>,
    private val completionListener: SortCompletionListener
) : Thread() {
    override fun run() {
        val x = editTextViewList.size
        //disabling editText functionalities during the sorting
        for (i in (0 until x)) {
            editTextViewList[i].isFocusable = true
            editTextViewList[i].isFocusableInTouchMode = false
            editTextViewList[i].inputType = RestrictionEntry.TYPE_NULL
        }
        for (i in (0 until x)) {
            var key: Boolean = true
            var j: Int = 0
            while ((j <= i) && (key)) {
                val a = Integer.parseInt(editTextViewList[i].text.toString())
                val b = Integer.parseInt(editTextViewList[j].text.toString())
                //setting colours to greens to show user which numbers are compared
                editTextViewList[i].setBackgroundColor(Color.parseColor("#00FF00"))
                editTextViewList[j].setBackgroundColor(Color.parseColor("#00FF00"))
                Thread.sleep((MS5 / Speed.speed).toLong())
                if (j == i) {
                    editTextViewList[j].setBackgroundColor(Color.parseColor("#FF0000"))
                    Thread.sleep((MS5 / Speed.speed).toLong())
                    editTextViewList[j].setBackgroundColor(Color.parseColor("#1313AF"))
                } else if (a < b) {
                    //setting color to red to show user inserted number
                    editTextViewList[i].setBackgroundColor(Color.parseColor("#FF0000"))
                    //setting color to initial value
                    editTextViewList[j].setBackgroundColor(Color.parseColor("#1313AF"))
                    key = false
                    var k = i
                    while (k > j) {
                        swapTextViewsLocations(editTextViewList[k - 1], editTextViewList[k])
                        val tempEditText: EditText = editTextViewList[k]
                        editTextViewList.removeAt(k)
                        editTextViewList.add(k - 1, tempEditText)
                        k--
                    }
                    Thread.sleep((MS5 / Speed.speed).toLong())
                    //setting color to initial value
                    editTextViewList[k].setBackgroundColor(Color.parseColor("#1313AF"))


                } else {
                    //setting colors to initials
                    editTextViewList[i].setBackgroundColor(Color.parseColor("#1313AF"))
                    editTextViewList[j].setBackgroundColor(Color.parseColor("#1313AF"))
                }
                j++

            }
        }
        //reassigning editText functionalities and putting original colors back
        for (i in (0 until x)) {
            editTextViewList[i].isFocusableInTouchMode = true
            editTextViewList[i].inputType = InputType.TYPE_CLASS_NUMBER
            editTextViewList[i].setBackgroundColor(Color.parseColor("#1313AF"))
        }
        completionListener.onSortCompleted()
    }

    fun swapTextViewsLocations(editTextView: EditText, editTextView2: EditText) {
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