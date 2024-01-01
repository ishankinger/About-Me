package com.example.aboutme

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding                                     // defining binding variable to use further
                                                                                         // act as a glue b/w data and layout views
    private var myName1 : MyName = MyName("Ishan Kinger")                          // defining an object from MyName data class

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_main)                                         // setContentView without binding class
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)      // setContentView with binding class

        binding.myNameIshan = myName1                                                    // storing value of myName1 in myName object defined in activity main.xml
//        val clickButton: Button =findViewById(R.id.button)                             // using button without binding class
//        clickButton.setOnClickListener(){                                              // id of button inflated and then used in OnClick
//            addNickName(it)                                                            // two functions are called
//            clickButton()
//        }
        binding.button.setOnClickListener {                                       // using button with data binding
            addNickName(it)                                                              // here it refers to button
            clickButton()                                                                // so we can access button without calling for the
        }                                                                                // findViewById methods
        // binding.(nameOfId).(function_To_Perform){ ------ }
    }
    @SuppressLint("SetTextI18n")
    private fun addNickName(view: View){                                          // here view refers to the button

//        val editText = findViewById<EditText>(R.id.editTextTextPersonName)      // method without using binding class
//        val nickName = findViewById<TextView>(R.id.textView4)                   // nickName and editText are inflated
//        val name= editText.text                                                 // this will store text in editText

//        nickName.text = "hello $name"                                           // so nick name text will change
//        editText.visibility = View.GONE                                         // both button and edit text are gone
//        view.visibility = View.GONE
//        nickName.visibility = View.VISIBLE                                      // nickname from gone become visible

        val name= binding.editTextTextPersonName.text                             // variable storing entered text
                                                                                  // method using a binding class
        binding.apply{                                          // binding.apply{} means in this every statement as binding.
            myNameIshan?.nickname=name.toString()                                 // storing the name of edit text in myName variable nickname
            invalidateAll()
            editTextTextPersonName.visibility = View.GONE                         // biding.(name of id to be used).(function) = ......
            view.visibility = View.GONE                                           // way to use data binding to access view of our layout
            textView4.visibility = View.VISIBLE                                   // here view refers to the button
        }

        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager    // code to remove keyboard after writing in textView
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }
    @SuppressLint("SetTextI18n")
    private fun clickButton(){
        val name= binding.editTextTextPersonName.text
        if(name.toString()=="ishi"){
            val myIntro = binding.textView2
            myIntro.text="I am a second-year student of Bachelor of Technology in Computer Science Engineering at the Indian Institute of Technology, Bhubaneswar. Till now I am maintained an average CGPA of 9.40. I have been doing programming since my first year in C++ and I am a 6-star coder at the CodeChef platform. I have done all the fundamental topics of programming languages such as Object Oriented Programming, algorithm design, data structures, and complexity analysis. I regularly participated in coding contests and have built a very good problem-solving mindset. Also, I was also enrolled in some courses for programming where I have done a couple of projects. I am also doing App Development and have a decent hand in that. I have also completed one project on this where I have made an app which stores all the past year papers of our college academics which helps a lot of students in our college. Other than my knowledge of programming I was also engaged in our annual college fest as sponsorship coordinator where I polished my communication skills, and how to deal with clients and acquired leadership qualities and a sense of responsibility. I have also experience in optimization mathematics such as linear programming and non-linear optimization. All these things enhance my ability to effectively articulate technical challenges and solutions and to think abstractly\n" +
                  "about handling ambiguous and undefined problems."

            val myPhoto = binding.avtarImage
            myPhoto.setImageResource(R.drawable.pic_ishan)
        }
        else{
            val myIntro = binding.textView2
            myIntro.text="        CHL BE GLT NAM BTA RHA HAI"

            val myPhoto = binding.avtarImage
            myPhoto.setImageResource(R.drawable.mockingpic)
        }
    }
}


// ***** CODE USING BINDING CLASS CONCEPT*****
//package com.example.aboutme
//
//import android.annotation.SuppressLint
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.view.View
//import android.view.inputmethod.InputMethodManager
//import android.widget.Button
//import android.widget.EditText
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.databinding.DataBindingUtil
//import com.example.aboutme.databinding.ActivityMainBinding
//
//class MainActivity : AppCompatActivity() {
//
//    private lateinit var binding:ActivityMainBinding
//
//    private var myName1 : MyName = MyName("Ishan Kinger")
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
//
//        binding.myName = myName1;
//
//        binding.button.setOnClickListener {
//            addNickName(it)
//            clickButton()
//        }
//    }
//
//    @SuppressLint("SetTextI18n")
//    private fun addNickName(view: View){
//
//        binding.apply{
//            myName?.nickname=name.toString()
//            invalidateAll()
//            editTextTextPersonName.visibility = View.GONE
//            view.visibility = View.GONE
//            textView4.visibility = View.VISIBLE
//        }
//
//        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
//        imm.hideSoftInputFromWindow(view.windowToken,0)
//    }
//
//    @SuppressLint("SetTextI18n")
//    private fun clickButton(){
//
//        val name= binding.editTextTextPersonName.text
//
//        if(name.toString()=="ishi"){
//
//            val myIntro = binding.textView2
//            myIntro.text="I am a second-year student of Bachelor of Technology in Computer Science Engineering at the Indian
//            Institute of Technology, Bhubaneswar. Till now I am maintained an average CGPA of 9.40. I have been doing programming
//            since my first year in C++ and I am a 6-star coder at the CodeChef platform. I have done all the fundamental topics of
//            programming languages such as Object Oriented Programming, algorithm design, data structures, and complexity analysis.
//            I regularly participated in coding contests and have built a very good problem-solving mindset. Also, I was also enrolled
//            in some courses for programming where I have done a couple of projects. I am also doing App Development and have a decent
//            hand in that. I have also completed one project on this where I have made an app which stores all the past year papers of
//            our college academics which helps a lot of students in our college. Other than my knowledge of programming I was also engaged
//            in our annual college fest as sponsorship coordinator where I polished my communication skills, and how to deal with clients
//            and acquired leadership qualities and a sense of responsibility. I have also experience in optimization mathematics such as
//            linear programming and non-linear optimization. All these things enhance my ability to effectively articulate technical challenges
//             and solutions and to think abstractly\n" + "about handling ambiguous and undefined problems."
//
//            val myPhoto = binding.avtarImage
//            myPhoto.setImageResource(R.drawable.pic_ishan)
//        }
//        else{
//            val myIntro = binding.textView2
//            myIntro.text="        CHL BE GLT NAM BTA RHA HAI"
//
//            val myPhoto = binding.avtarImage
//            myPhoto.setImageResource(R.drawable.mockingpic)
//        }
//    }
//}

//      *****CODE WITHOUT USING BINDING CLASS CONCEPT*****
//package com.example.aboutme
//
//import android.annotation.SuppressLint
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.view.View
//import android.view.inputmethod.InputMethodManager
//import android.widget.Button
//import android.widget.EditText
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.databinding.DataBindingUtil
//import com.example.aboutme.databinding.ActivityMainBinding
//
//class MainActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        setContentView(R.layout.activity_main)
//
//        val clickButton: Button =findViewById(R.id.button)
//        clickButton.setOnClickListener(){
//            addNickName(it)
//        }
//    }
//
//    @SuppressLint("SetTextI18n")
//    private fun addNickName(view: View){
//
//        // inflating the view objects in mainActivity
//        val editText = findViewById<EditText>(R.id.editTextTextPersonName)
//        val nickName = findViewById<TextView>(R.id.textView4)
//        val name= editText.text
//
//       // button and editText removed and nickName is shown
//        nickName.text = "hello $name"
//        editText.visibility = View.GONE
//        view.visibility = View.GONE
//        nickName.visibility = View.VISIBLE
//
//        // hide the keyboard
//        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
//        imm.hideSoftInputFromWindow(view.windowToken,0)
//    }