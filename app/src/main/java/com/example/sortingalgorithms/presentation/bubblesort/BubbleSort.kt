package com.example.sortingalgorithms.presentation.bubblesort

import android.content.RestrictionEntry
import android.graphics.Color
import android.text.InputType
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.sortingalgorithms.utils.constants.MS5
import com.example.sortingalgorithms.utils.extensions.SortCompletionListener
import com.example.sortingalgorithms.utils.extensions.Speed

class BubbleSort(
    private var editTextViewList: ArrayList<EditText>,
    private val completionListener: SortCompletionListener
) : Thread() {
    override fun run() {
        val listSize = editTextViewList.size
        //disabling editText functionalities during the sorting
        for (i in (0 until listSize)) {
            editTextViewList[i].isFocusable = true
            editTextViewList[i].isFocusableInTouchMode = false
            editTextViewList[i].inputType = RestrictionEntry.TYPE_NULL
        }
        var isSorted: Boolean = false
        for (i in (0 until listSize)) {
            if (isSorted) {
                break
            }
            isSorted = true
            for (j in (0..(listSize - i - 2))) {
                //setting colours to greens to show user which numbers are compared
                editTextViewList[j].setBackgroundColor(Color.parseColor("#00FF00"))
                editTextViewList[j + 1].setBackgroundColor(Color.parseColor("#00FF00"))
                //fetching numbers from editText views
                val a = Integer.parseInt(editTextViewList[j].text.toString())
                val b = Integer.parseInt(editTextViewList[j + 1].text.toString())
                //giving user some time to see which numbers compared
                Thread.sleep((MS5 / Speed.speed).toLong())
                if (a > b) {
                    isSorted = false
                    //setting colors to red to show user, numbers are gonna swapped
                    editTextViewList[j].setBackgroundColor(Color.parseColor("#FF0000"))
                    editTextViewList[j + 1].setBackgroundColor(Color.parseColor("#FF0000"))
                    //swapping in the list
                    val temp = editTextViewList[j]
                    editTextViewList[j] = editTextViewList[j + 1]
                    editTextViewList[j + 1] = temp
                    //swapping in screen
                    swapTextViewsLocations(editTextViewList[j], editTextViewList[j + 1])
                    //giving user enough time see the swapping
                    Thread.sleep((MS5 / Speed.speed).toLong())
                } else {
                    //do nothing
                }
                //setting colors to initials
                editTextViewList[j].setBackgroundColor(Color.parseColor("#1313AF"))
                editTextViewList[j + 1].setBackgroundColor(Color.parseColor("#1313AF"))
            }
        }
        //reassigning editText functionalities
        for (i in (0 until listSize)) {
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