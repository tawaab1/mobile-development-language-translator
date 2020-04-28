package com.amorjk1.languagetranslator

//class Question {
//    var id:Int = 0
//    var questionText:String? = null
//    var questionImage:String? = null
//    var answer1:String? = null
//    var answer2:String? = null
//    var answer3:String? = null
//    var answer4:String? = null
//    var correctAnswer:String? = null
//    var imageQuestion: Boolean = false
//    var categoryID:Int = 0
//}

data class Question(
    var theQuestion:String, var theAnswer: ArrayList<String>
)
{

}