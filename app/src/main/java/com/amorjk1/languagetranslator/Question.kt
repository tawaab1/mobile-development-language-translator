import com.amorjk1.languagetranslator.R

class Question {
    private val nQuestions = arrayOf<String>("How do you say you're welcome?",
    "Argent means what in English?",
    "What does the picture show?",
    "This is a young what?",
    "How many chairs are there?");


    private val nChoices = arrayOf<Array<String>>(arrayOf<String>("Vous êtes les bienvenus", "Bonjour", "Bicyclette", "La télé"),
        arrayOf<String>("Money", "Car", "Laptop", "School"),
        arrayOf<String>("Chaise", "Verde", "Lit", "Lady"),
        arrayOf<String>("Senorita", "Mama", "Lady", "Dame"),
        arrayOf<String>("Quatre", "beaucoup", "Tres", "Cuatro"))


    private val nAnswers = arrayOf<String>("Vous êtes les bienvenu","Money","Lit","Dame","Quatre");


    var images = intArrayOf(R.drawable.youre_welcome,R.drawable.dolares,R.drawable.cama,R.drawable.senorita,R.drawable.chairs)


    fun getQuestion(a:Int):String {
        val question = nQuestions[a]
        return question
    }

    fun getChoice1(a:Int):String {
        val choice1 = nChoices[a][0]
        return choice1
    }

    fun getChoice2(a:Int):String {
        val choice2 = nChoices[a][1]
        return choice2
    }

    fun getChoice3(a:Int):String {
        val choice3 = nChoices[a][2]
        return choice3
    }

    fun getChoice4(a:Int):String {
        val choice4 = nChoices[a][3]
        return choice4
    }

    fun getCorrectAnswer(a:Int):String {
        val correctAnswer = nAnswers[a]
        return correctAnswer
    }
}