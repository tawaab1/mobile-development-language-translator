# mobile-development-language-translator

[This is the dokko documentation](https://github.com/tawaab1/mobile-development-language-translator/blob/kdocs-roy/javadoc/app/com.amorjk1.languagetranslator/index.md)

## Splash Screen
The launcher activity, which is the first screen you see when you open the application displaying a simple logo animation. After a set time you go to the MainActivity. This is the main menu of the application



## MainActivity
The main menu of the application, from here you will see 4 buttons, a bottom navigation,and a navigation toolbar at the top. The 4 buttons take you to 4 different quizzes with each language having different sets of questions. The bottom navigation takes you to 4 different screens such as Home, Translate, Contact Us, and About us. 

## BottomNavigationActivity
An activity that allows the user to navigate through 4 different activities/screens. This is displayed at the bottom of the app. It takes you directly to the
- ContactUsActivity
- AboutUsActivity
- TranslationActivity
- Home/MainActivity

## ContactUsActivity
The activity is linked via the BottomNavigationActivity basically telling the user our contact information

## AboutUsActivity
The activity is linked via the BottomNavigationActivity basically telling user some brief information about the developers of the application

## TranslationActivity
Text to translation is done in this activity. This feature allows the user to enter text and translate to a selected language provided. It also has the option of reading the selected translated language as well. 

## PlayScreenActivities
Each one of the activities listed below does the same thing. These activites are the quiz activities. Each with a different set of questions. During the quiz the user is given feedback for questions answered, an option to have the question read aloud, and their score at the end.
- playScreenActivity
- PlayScreenGermanActivity
- PlayScreenItalianActivity
- PlayScreenSpanishActivity







