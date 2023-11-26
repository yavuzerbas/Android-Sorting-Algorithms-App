package com.example.sortingalgorithms.presentation.selectionsort

import android.content.RestrictionEntry
import android.graphics.Color
import android.text.InputType
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import com.example.sortingalgorithms.utils.constants.MS4
import com.example.sortingalgorithms.utils.constants.MS5
import com.example.sortingalgorithms.utils.extensions.SortCompletionListener
import com.example.sortingalgorithms.utils.extensions.Speed

class SelectionSort(
    private var editTextViewList:ArrayList<EditText>,
    private val completionListener: SortCompletionListener
):Thread() {
    override fun run() {
        val x = editTextViewList.size
        //disabling editText functionalities during the sorting
        for(i in (0 until x)){
            editTextViewList[i].isFocusable = true
            editTextViewList[i].isFocusableInTouchMode = false
            editTextViewList[i].inputType = RestrictionEntry.TYPE_NULL
        }
        for(i in (0 until x)){
            var smallestValue:Int = Integer.MAX_VALUE
            var locationOfMin:Int = i
            for(j in (i until x)){
                editTextViewList[j].setBackgroundColor(Color.parseColor("#00FF00"))
                //fetching numbers from editText views
                Thread.sleep((MS4 / Speed.speed).toLong())
                val currentValue = Integer.parseInt(editTextViewList[j].text.toString())
                if(currentValue < smallestValue){
                    editTextViewList[locationOfMin].setBackgroundColor(Color.parseColor("#1313AF"))
                    smallestValue = currentValue
                    locationOfMin = j
                    editTextViewList[locationOfMin].setBackgroundColor(Color.parseColor("#231709"))
                    Thread.sleep((MS4 / Speed.speed).toLong())
                }
                else{
                    editTextViewList[j].setBackgroundColor(Color.parseColor("#1313AF"))
                }

            }
            for(k in (i until locationOfMin)){
                swapTextViewsLocations(editTextViewList[k],editTextViewList[k+1])
            }
            val tempEditText:EditText = editTextViewList[locationOfMin]
            editTextViewList.removeAt(locationOfMin)
            editTextViewList.add(i,tempEditText)
        }
        //reassigning editText functionalities and putting original colors back
        for(i in (0 until x)){
            editTextViewList[i].isFocusableInTouchMode = true
            editTextViewList[i].inputType = InputType.TYPE_CLASS_NUMBER
            editTextViewList[i].setBackgroundColor(Color.parseColor("#1313AF"))
        }
        completionListener.onSortCompleted()
    }
    private fun swapTextViewsLocations(editTextView:EditText, editTextView2:EditText){
        Log.i("location"," pre textView location: " + editTextView.x +"," +editTextView.y)
        Log.i("location"," pre textView2 location: " + editTextView2.x +"," +editTextView2.y)
        val tempX = editTextView.x
        val tempY = editTextView.y
        editTextView.x = editTextView2.x
        editTextView.y = editTextView2.y
        editTextView2.x = tempX
        editTextView2.y = tempY
        Log.i("location"," post textView location: " + editTextView.x +"," +editTextView.y)
        Log.i("location"," post textView2 location: " + editTextView2.x +"," +editTextView2.y)

    }
}