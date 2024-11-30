package com.applications.calcfun.generator.ui

import android.os.Bundle
import android.os.Handler
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.applications.calcfun.databinding.FragmentCalcBinding
import com.applications.calcfun.generator.presentation.CalcViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CalcFragment : Fragment() {

    private var _binding: FragmentCalcBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModel<CalcViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalcBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var createdExpression = viewModel.getExpression()
        binding.textViewStringCalc.text = createdExpression.expression
        val editText = binding.editTextNumberDecimal
        val keyboard = binding.keyboard
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
                Toast.makeText(requireContext(), "Right", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Wrong", Toast.LENGTH_SHORT).show()
            }
            createdExpression = createNewExpression()
            binding.textViewStringCalc.text = createdExpression.expression
            editText.text.clear()
            isRunnable = true
        }
        var progressStatus = 0
        var handler = Handler()
        Thread(Runnable {
            while (progressStatus < 100 && !isRunnable) {
                progressStatus += 1
                Thread.sleep(100)
                handler.post {
                    binding.progressBar.progress = progressStatus
                }
            }
        }).start()
    }

    private fun createNewExpression() =
        viewModel.getExpression()

    private fun checkExpression(generatorText: Int, inputText: String?): Boolean {
        return inputText != null && generatorText == inputText.toInt()
    }
}

