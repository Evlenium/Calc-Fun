package com.applications.calcfun.generator.ui

import android.os.Bundle
import android.os.Handler
import android.text.InputType
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import com.applications.calcfun.R
import com.applications.calcfun.generator.data.Generator
import com.applications.calcfun.util.MyKeyboard


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val generator = Generator()
        var createdExpression = generator.createExpression()
        val textView = findViewById<TextView>(R.id.textViewStringCalc)
        textView.text = createdExpression.expression
        val editText = findViewById<EditText>(R.id.editTextNumberDecimal)
        val keyboard = findViewById<MyKeyboard>(R.id.keyboard)
        editText.setRawInputType(InputType.TYPE_CLASS_TEXT)
        editText.setTextIsSelectable(true)
        val ic = editText.onCreateInputConnection(EditorInfo())
        keyboard.setInputConnection(ic)
        var inputText: String? = null
        editText.addTextChangedListener(
            beforeTextChanged = { s, start, count, after -> },
            onTextChanged = { s, start, before, count -> },
            afterTextChanged = { s -> inputText = s.toString() })
        var isRunnable = false
        keyboard.mButtonEnter?.setOnClickListener {
            if (checkExpression(createdExpression.result, inputText)) {
                Toast.makeText(this, "Right", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()
            }
            createdExpression = createNewExpression(generator)
            textView.text = createdExpression.expression
            editText.text.clear()
            isRunnable = true
        }
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        var progressStatus = 0
        var handler = Handler()
        Thread(Runnable {
            while (progressStatus < 100 && !isRunnable) {
                // update progress status
                progressStatus += 1

                // sleep the thread for 100 milliseconds
                Thread.sleep(100)

                // update the progress bar
                handler.post {
                    progressBar.progress = progressStatus
//                    textView.text = "$progressStatus"
                }
            }
        }).start()
    }

    private fun createNewExpression(generator: Generator) =
        generator.createExpression()

    private fun checkExpression(generatorText: Int, inputText: String?): Boolean {
        return inputText != null && generatorText == inputText.toInt()
    }

}