# mobile-development-language-translator

[This is the dokko documentation](https://github.com/tawaab1/mobile-development-language-translator/blob/kdocs-roy/javadoc/app/com.amorjk1.languagetranslator/index.md)

## Splash Screen
The launcher activity, which is the first screen you see when you open the application displaying a simple logo animation. After a set time you go to the MainActivity. This is the main menu of the application

<img src="https://github.com/tawaab1/mobile-development-language-translator/blob/readmefile-roy/images/splashscreen.png" width="300" height="500" />

## MainActivity
The main menu of the application, from here you will see 4 image buttons, a bottom navigation,and a navigation toolbar at the top. The 4 image buttons take you to 4 different quizzes with each language having different sets of questions. The bottom navigation takes you to 4 different screens such as Home, Translate, Contact Us, and About us. 

<img src="https://github.com/tawaab1/mobile-development-language-translator/blob/readmefile-roy/images/mainActivity.png" width="300" height="500"/>

Exit dialog from Menu
If the user presses back on their device a dialog appears and gives you the option to exit the app or not


<img src="https://github.com/tawaab1/mobile-development-language-translator/blob/readmefile-roy/images/playscreenexit.png" height="500" width="300" />

## BottomNavigationActivity
An activity that allows the user to navigate through 4 different activities/screens. This is displayed at the bottom of the app. It takes you directly to the
- ContactUsActivity
- AboutUsActivity
- TranslationActivity
- Home/MainActivity
The navigation is found at the bottom with icons.

## ContactUsActivity
The activity is linked via the BottomNavigationActivity basically telling the user our contact information

<img src="https://github.com/tawaab1/mobile-development-language-translator/blob/readmefile-roy/images/contactus.png" width="300" height="500"/>

## AboutUsActivity
The activity is linked via the BottomNavigationActivity basically telling user some brief information about the developers of the application

<img src="https://github.com/tawaab1/mobile-development-language-translator/blob/readmefile-roy/images/aboutus.png" width="300" height="500"/>

## TranslationActivity
Text to translation is done in this activity. This feature allows the user to enter text and translate to a selected language provided. It also has the option of reading the selected translated language as well. 

<img src="https://github.com/tawaab1/mobile-development-language-translator/blob/readmefile-roy/images/translate1.png" width="300" height="500"/>

## PlayScreenActivities
Each one of the activities listed below does the same thing. These activites are the quiz activities. Each with a different set of questions. During the quiz the user is given feedback for questions answered, an option to have the question read aloud, and their score at the end.
- playScreenActivity
- PlayScreenGermanActivity
- PlayScreenItalianActivity
- PlayScreenSpanishActivity

Play screen 


<img src="https://github.com/tawaab1/mobile-development-language-translator/blob/readmefile-roy/images/playscreenplay.png" width="300" height="500"/>

Play screen correct. When the user answers the question correctly a toast message displays


<img src="https://github.com/tawaab1/mobile-development-language-translator/blob/readmefile-roy/images/playscreencorrect.png" width="300" height="500"/>

Play screen wrong. When the user answers the question incorrectly a toast message displays

<img src="https://github.com/tawaab1/mobile-development-language-translator/blob/readmefile-roy/images/playscreenwrong.png" width="300" height="500"/>

Play screen final score. Displays the user final score at the end of the quiz with a dialog box


<img src="https://github.com/tawaab1/mobile-development-language-translator/blob/readmefile-roy/images/playscreenfinalscore.png" width="300" height="500"/>


Play screen go back. If the user wants to go back a dialog box appears with an option to return to main menu or stay on the quiz

<img src="https://github.com/tawaab1/mobile-development-language-translator/blob/readmefile-roy/images/playscreengoback.png" width="300" height="500" />

## Dark mode feature
Configure the dark mode feature by 
- Settings > display > dark mode

This feauture switches your devices display settings to 'dark mode' and can switched back by following the previous steps

<img src="https://github.com/tawaab1/mobile-development-language-translator/blob/readmefile-roy/images/darkmode.png" width="300" height="500" />













