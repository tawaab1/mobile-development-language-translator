[app](../../index.md) / [com.amorjk1.languagetranslator](../index.md) / [TranslationActivity](./index.md)

# TranslationActivity

`class TranslationActivity : AppCompatActivity`

### Types

| [OnNavigationItemSelectedListener](-on-navigation-item-selected-listener/index.md) | `inner class OnNavigationItemSelectedListener : OnNavigationItemSelectedListener`<br>Navigation class |
| [SpeakButtonClickHandler](-speak-button-click-handler/index.md) | `inner class SpeakButtonClickHandler : OnClickListener` |
| [TextToSpeechInit](-text-to-speech-init/index.md) | `inner class TextToSpeechInit : OnInitListener` |
| [TranslateButtonClickHandler](-translate-button-click-handler/index.md) | `inner class TranslateButtonClickHandler : OnClickListener` |
| [getAPIData](get-a-p-i-data/index.md) | `inner class getAPIData : AsyncTask<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, `[`Void`](http://docs.oracle.com/javase/6/docs/api/java/lang/Void.html)`?, `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?>`<br>get the requested data from the API |

### Constructors

| [&lt;init&gt;](-init-.md) | `TranslationActivity()` |

### Properties

| [originalText](original-text.md) | `lateinit var originalText: EditText` |
| [translatedSpinner](translated-spinner.md) | `lateinit var translatedSpinner: Spinner` |
| [translatedText](translated-text.md) | `lateinit var translatedText: TextView` |
| [tts](tts.md) | `lateinit var tts: TextToSpeech` |

### Functions

| [onCreate](on-create.md) | `fun onCreate(savedInstanceState: Bundle?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

