import com.amorjk1.languagetranslator.R
/*
Question class
Creates questions, answers, choices, and images for quiz in arrays
 */
class QuestionItalian {

    private val nQuestions = arrayOf<String>("You say 'Buon compleanno' to someone on their",
        "What does 'Buongiorno!' mean?",
        "What does 'Arrivederci!' mean in Italian",
        "When you ask someone 'Come si chiama?' what are you asking them?",
        "What does 'Per favore' mean?");

    private val nChoices = arrayOf<Array<String>>(arrayOf<String>("First day of work", "Weekend", "Birthday", "Last day of school"),
        arrayOf<String>("Good night", "Hello", "Im tired", "Where is the bathroom"),
        arrayOf<String>("Goodbye", "Hello", "I want water", "No"),
        arrayOf<String>("Their age", "Their name", "Where you're from", "How are they doing"),
        arrayOf<String>("Excuse me", "How old are you", "My name is", "Please"))

    private val nAnswers = arrayOf<String>("Birthday","Hello","Goodbye","Their name","Please");

    var images = intArrayOf(R.drawable.birthday,R.drawable.hello,R.drawable.goodbye,R.drawable.theirname,R.drawable.please)

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