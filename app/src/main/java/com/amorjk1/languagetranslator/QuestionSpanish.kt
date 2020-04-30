import com.amorjk1.languagetranslator.R

class QuestionSpanish {

    private val nQuestions = arrayOf<String>("Good morning is?",
        "How are you?",
        "My name is?",
        "How do you make toast?",
        "Feliz navidad is?");

    private val nChoices = arrayOf<Array<String>>(arrayOf<String>("Buenos Dias", "Bueonas Noches", "Buenas tardes", "Hola"),
        arrayOf<String>("Como esas", "Comas dias", "Comas como", "Coma est"),
        arrayOf<String>("Mi llamo", "Me llamo", "My llamo", "My namo"),
        arrayOf<String>("Salud", "Viva", "Vila", "Salut"),
        arrayOf<String>("Easter", "Otago anniversary", "Christmas", "New year"))

    private val nAnswers = arrayOf<String>("Buenoas dias","Coma estas","Me llamo","Salud","Christmas");

    var images = intArrayOf(R.drawable.buenosdias,R.drawable.comoestas,R.drawable.mellamo,R.drawable.salud,R.drawable.christmas)

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