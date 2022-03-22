package com.example.sortingalgorithms

import android.content.RestrictionEntry
import android.graphics.Color
import android.text.InputType
import android.util.Log
import android.widget.EditText
import android.widget.TextView

class SelectionSort(var editTextViewList:ArrayList<EditText>):Thread() {
    override fun run() {
        var x = editTextViewList.size
        //disabling editText functionalities during the sorting
        for(i in (0..x-1)){
            editTextViewList[i].isFocusable = true
            editTextViewList[i].isFocusableInTouchMode = false
            editTextViewList[i].inputType = RestrictionEntry.TYPE_NULL
        }
        for(i in (0..(x-1))){
            var smallestValue:Int = Integer.MAX_VALUE
            var locationOfMin:Int = i
            for(j in (i..(x-1))){
                editTextViewList[j].setBackgroundColor(Color.parseColor("#00FF00"))
                //fetching numbers from editText views
                Thread.sleep(800)
                var currentValue = Integer.parseInt(editTextViewList[j].text.toString())
                if(currentValue < smallestValue){
                    editTextViewList[locationOfMin].setBackgroundColor(Color.parseColor("#1313AF"))
                    smallestValue = currentValue
                    locationOfMin = j
                    editTextViewList[locationOfMin].setBackgroundColor(Color.parseColor("#231709"))
                    Thread.sleep(800)
                }
                else{
                    editTextViewList[j].setBackgroundColor(Color.parseColor("#1313AF"))
                }

            }
            for(k in (i..locationOfMin-1)){
                swapTextViewsLocations(editTextViewList[k],editTextViewList[k+1])
            }
            var tempEditText:EditText = editTextViewList[locationOfMin]
            editTextViewList.removeAt(locationOfMin)
            editTextViewList.add(i,tempEditText)
        }
        //reassigning editText functionalities and putting original colors back
        for(i in (0..x-1)){
            editTextViewList[i].isFocusableInTouchMode = true
            editTextViewList[i].inputType = InputType.TYPE_CLASS_NUMBER
            editTextViewList[i].setBackgroundColor(Color.parseColor("#1313AF"))
        }
    }
    fun swapTextViewsLocations(editTextView:EditText, editTextView2:EditText){
        Log.i("location"," pre textView location: " + editTextView.x +"," +editTextView.y)
        Log.i("location"," pre textView2 location: " + editTextView2.x +"," +editTextView2.y)
        var tempX = editTextView.x
        var tempY = editTextView.y
        editTextView.x = editTextView2.x
        editTextView.y = editTextView2.y
        editTextView2.x = tempX
        editTextView2.y = tempY
        Log.i("location"," post textView location: " + editTextView.x +"," +editTextView.y)
        Log.i("location"," post textView2 location: " + editTextView2.x +"," +editTextView2.y)

    }
}