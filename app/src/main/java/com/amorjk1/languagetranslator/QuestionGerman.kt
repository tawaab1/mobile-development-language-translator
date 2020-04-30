import com.amorjk1.languagetranslator.R

class QuestionGerman {

    var nQuestions = arrayOf<String>("Danke.",
        "Ja",
        "What does the phrase “Guten morgen” translate to?",
        "What does 'Es tut mir leid' mean?",
        "Can you tell what 'Vielen Dank' means in English?");


    private val nChoices = arrayOf<Array<String>>(arrayOf<String>("Im hungry", "Hello", "Goodbye", "Thank You"),
        arrayOf<String>("No", "Yes", "Good Afternoon", "Im Lost"),
        arrayOf<String>("My name is", "How are you", "Good morning", "Good evening"),
        arrayOf<String>("Of course", "Nothing, thanks", "Can you translate that", "I'm sorry"),
        arrayOf<String>("Thank you very much", "Im going to the park", "I'm doing well", "I reserved a table"))

    private val nAnswers = arrayOf<String>("Thank You","Yes","Good morning","I'm sorry","Thank you very much");

    var images = intArrayOf(R.drawable.thank_you,R.drawable.yes,R.drawable.good_morning,R.drawable.im_sorry,R.drawable.verymuch)


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