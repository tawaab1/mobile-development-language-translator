class Question {
    private val nQuestions = arrayOf<String>("What is the capital of NZ",
    "How many People in NZ",
    "How many planets are there?");

    private val nChoices = arrayOf<Array<String>>(arrayOf<String>("Wellington", "Dunedin", "Auckland", "Oamaru"),
        arrayOf<String>("1", "2", "3", "4"),
        arrayOf<String>("10", "5", "7", "9"))

    private val nAnswers = arrayOf<String>("Wellington","1","10");

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