package com.example.sortingalgorithms

import android.content.RestrictionEntry
import android.graphics.Color
import android.text.InputType
import android.util.Log
import android.widget.EditText
import android.widget.Toast

class InsertionSort(var editTextViewList: ArrayList<EditText>) : Thread() {
    override fun run() {
        var x = editTextViewList.size
        //disabling editText functionalities during the sorting
        for(i in (0..x-1)){
            editTextViewList[i].isFocusable = true
            editTextViewList[i].isFocusableInTouchMode = false
            editTextViewList[i].inputType = RestrictionEntry.TYPE_NULL
        }
        for(i in (0..(x-1))){
            var key:Boolean = true
            var j:Int = 0
            while((j <= i) && (key)){
                var a = Integer.parseInt(editTextViewList[i].text.toString())
                var b = Integer.parseInt(editTextViewList[j].text.toString())
                //setting colours to greens to show user which numbers are compared
                editTextViewList[i].setBackgroundColor(Color.parseColor("#00FF00"))
                editTextViewList[j].setBackgroundColor(Color.parseColor("#00FF00"))
                Thread.sleep(1000)
                if(j == i){
                    editTextViewList[j].setBackgroundColor(Color.parseColor("#FF0000"))
                    Thread.sleep(1000)
                    editTextViewList[j].setBackgroundColor(Color.parseColor("#1313AF"))
                }
                else if(a < b){
                    //setting color to red to show user inserted number
                    editTextViewList[i].setBackgroundColor(Color.parseColor("#FF0000"))
                    //setting color to initial value
                    editTextViewList[j].setBackgroundColor(Color.parseColor("#1313AF"))
                    key = false
                    var k = i
                    while(k > j){
                        swapTextViewsLocations(editTextViewList[k-1],editTextViewList[k])
                        var tempEditText:EditText = editTextViewList[k]
                        editTextViewList.removeAt(k)
                        editTextViewList.add(k-1,tempEditText)
                        k--
                    }
                    Thread.sleep(1000)
                    //setting color to initial value
                    editTextViewList[k].setBackgroundColor(Color.parseColor("#1313AF"))

                    /*Log.i("MyArray",""+editTextViewList[0].text.toString()+","+
                            editTextViewList[1].text.toString()+","+
                            editTextViewList[2].text.toString()+","+
                            editTextViewList[3].text.toString()+","+
                            editTextViewList[4].text.toString()+","+
                            editTextViewList[5].text.toString()+","+
                            editTextViewList[6].text.toString()+","+
                            editTextViewList[7].text.toString()+","+
                            editTextViewList[8].text.toString()+","+
                            editTextViewList[9].text.toString()+","
                    )*/

                }
                else{
                    //setting colors to initials
                    editTextViewList[i].setBackgroundColor(Color.parseColor("#1313AF"))
                    editTextViewList[j].setBackgroundColor(Color.parseColor("#1313AF"))
                }
                j++

            }
        }
        //reassigning editText functionalities and putting original colors back
        for(i in (0..x-1)){
            editTextViewList[i].isFocusableInTouchMode = true
            editTextViewList[i].inputType = InputType.TYPE_CLASS_NUMBER
            editTextViewList[i].setBackgroundColor(Color.parseColor("#1313AF"))
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