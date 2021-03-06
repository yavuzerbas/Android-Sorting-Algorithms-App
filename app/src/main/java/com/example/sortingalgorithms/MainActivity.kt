package com.example.sortingalgorithms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity(){
    //var recursiveSortFragment:RecursiveSortFragment = RecursiveSortFragment()//Getting editText views
    override fun onCreate(savedInstanceState: Bundle?) {

        var isSortInProgress:Boolean = false //if sorting in progress
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var editTextViews:ArrayList<EditText> = ArrayList()
        val editText1 = findViewById<EditText>(R.id.editText1)
        val editText2 = findViewById<EditText>(R.id.editText2)
        val editText3 = findViewById<EditText>(R.id.editText3)
        val editText4 = findViewById<EditText>(R.id.editText4)
        val editText5 = findViewById<EditText>(R.id.editText5)
        val editText6 = findViewById<EditText>(R.id.editText6)
        val editText7 = findViewById<EditText>(R.id.editText7)
        val editText8 = findViewById<EditText>(R.id.editText8)

        editTextViews.add(editText1)
        editTextViews.add(editText2)
        editTextViews.add(editText3)
        editTextViews.add(editText4)
        editTextViews.add(editText5)
        editTextViews.add(editText6)
        editTextViews.add(editText7)
        editTextViews.add(editText8)


        val spinner:Spinner = findViewById(R.id.spinner)

        //connection views with xml ids
        val buttonStartSorting:Button = findViewById(R.id.buttonStartSorting)
        val buttonRandomizeNumbers:Button = findViewById(R.id.buttonRandomizeNumbers)


        buttonStartSorting.setOnClickListener(View.OnClickListener {
            //Bubble Sort is selected in spinner
            if(spinner.selectedItem.toString().equals("Noob Sort")){
                NoobSort(editTextViews).start()
            }
            else if(spinner.selectedItem.toString().equals("Selection Sort")){
                SelectionSort(editTextViews).start()
            }
            else if(spinner.selectedItem.toString().equals("Insertion Sort")){
                InsertionSort(editTextViews).start()
            }
            else if(spinner.selectedItem.toString().equals("Bubble Sort")){
                BubbleSort(editTextViews).start()
            }

            else{
                Toast.makeText(applicationContext,"Only SelectionSort,InsertionSort,BubbleSort and NoobBubbleSort works!",Toast.LENGTH_LONG).show()
            }
        })


        buttonRandomizeNumbers.setOnClickListener(View.OnClickListener {
            setRandomNumbersToTextViews(editTextViews)
            //myScrollingFragment.randomize()
        })




    }

    //FULL SCREEN FUNCTIONS
    //{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }

    private fun hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                // Set the content to appear under the system bars so that the
                // content doesn't resize when the system bars hide and show.
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                // Hide the nav bar and status bar
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }

    // Shows the system bars by removing all the flags
    // except for the ones that make the content appear under the system bars.
    private fun showSystemUI() {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
    }
    //END OF FULL SCREEN FUNCTIONS
    //}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}
//function giving random values to edit text areas
    fun setRandomNumbersToTextViews(editTextViews:ArrayList<EditText>){
        var numbers = getRandomNumbers(8)
        for(i in (0..7)){
            editTextViews[i].setText("" + numbers[i])
        }
    }
    //Following two functions for obtaining random numbers "getRandomNumbers","rand"
    //{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{

    fun getRandomNumbers(arraySize:Int):ArrayList<Int>{
        var numbersArrayList:ArrayList<Int> = ArrayList()
        for(i in 0..(arraySize-1)){
            var temp = rand(1,99)
            numbersArrayList.add(temp)
        }
        return numbersArrayList;
    }
    fun rand(start: Int, end: Int): Int {
        require(start <= end) { "Illegal Argument" }
        return (start..end).random()
    }
}
/*

 */

