package com.example.sortingalgorithms

import android.content.RestrictionEntry
import android.graphics.Color
import android.text.InputType
import android.util.Log
import android.widget.EditText

class BubbleSort(var editTextViewList: ArrayList<EditText>) : Thread() {
    override fun run() {
        var x = editTextViewList.size
        //disabling editText functionalities during the sorting
        for(i in (0..x-1)){
            editTextViewList[i].isFocusable = true
            editTextViewList[i].isFocusableInTouchMode = false
            editTextViewList[i].inputType = RestrictionEntry.TYPE_NULL
        }
        var isSorted:Boolean = false
        for(i in (0..(x-1))){
            if(isSorted){
                break
            }
            isSorted = true
            for(j in (0..(x-i-2))){
                //setting colours to greens to show user which numbers are compared
                editTextViewList[j].setBackgroundColor(Color.parseColor("#00FF00"))
                editTextViewList[j+1].setBackgroundColor(Color.parseColor("#00FF00"))
                //fetching numbers from editText views
                var a = Integer.parseInt(editTextViewList[j].text.toString())
                var b = Integer.parseInt(editTextViewList[j+1].text.toString())
                //giving user some time to see which numbers compared
                Thread.sleep(1000)
                if(a > b){
                    isSorted = false
                    //setting colors to red to show user, numbers are gonna swapped
                    editTextViewList[j].setBackgroundColor(Color.parseColor("#FF0000"))
                    editTextViewList[j+1].setBackgroundColor(Color.parseColor("#FF0000"))
                    //swapping in the list
                    var temp = editTextViewList[j]
                    editTextViewList[j] = editTextViewList[j+1]
                    editTextViewList[j+1] = temp
                    //swapping in screen
                    swapTextViewsLocations(editTextViewList[j],editTextViewList[j+1])
                    //giving user enough time see the swapping
                    Thread.sleep(1000)
                }
                else{
                    //do nothing
                }
                //setting colors to initials
                editTextViewList[j].setBackgroundColor(Color.parseColor("#1313AF"))
                editTextViewList[j+1].setBackgroundColor(Color.parseColor("#1313AF"))
            }
        }
        //reassigning editText functionalities
        for(i in (0..x-1)){
            editTextViewList[i].isFocusableInTouchMode = true
            editTextViewList[i].inputType = InputType.TYPE_CLASS_NUMBER
        }
    }
    fun swapTextViewsLocations(editTextView: EditText, editTextView2: EditText){
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