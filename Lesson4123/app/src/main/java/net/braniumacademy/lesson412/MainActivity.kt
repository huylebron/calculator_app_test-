package net.braniumacademy.lesson412

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity(), View.OnClickListener {
    // todo 1: create variables for views
    private lateinit var textResult: TextView
    private lateinit var btn0: Button
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button
    private lateinit var btnDot: Button
    private lateinit var btnAnswer: Button
    private lateinit var btnAdd: Button
    private lateinit var btnSubtract: Button
    private lateinit var btnNegative: Button
    private lateinit var btnMultiply: Button
    private lateinit var btnDivide: Button
    private lateinit var btnModulo: Button
    private lateinit var btnClear: Button
    // todo 1 done

    // todo 14: create your ViewModel object variable
    private lateinit var model: CalculatorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = getString(R.string.title_calculator)
        initViews()
        registerEventListener()
        model = ViewModelProvider(this)[CalculatorViewModel::class.java]
        model.expression
            .observe(this) { expression: String? -> textResult.text = expression }
    }
    // todo 14 done

    // todo 3: register on click listener for buttons
    private fun registerEventListener() {
        btn0.setOnClickListener(this)
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
        btn8.setOnClickListener(this)
        btn9.setOnClickListener(this)
        btnDot.setOnClickListener(this)
        btnAnswer.setOnClickListener(this)
        btnAdd.setOnClickListener(this)
        btnSubtract.setOnClickListener(this)
        btnNegative.setOnClickListener(this)
        btnMultiply.setOnClickListener(this)
        btnDivide.setOnClickListener(this)
        btnModulo.setOnClickListener(this)
        btnClear.setOnClickListener(this)
    }
    // todo 3 done

    // todo 2: bind views id to corresponding variables
    private fun initViews() {
        btn0 = findViewById(R.id.btn_0)
        btn1 = findViewById(R.id.btn_1)
        btn2 = findViewById(R.id.btn_2)
        btn3 = findViewById(R.id.btn_3)
        btn4 = findViewById(R.id.btn_4)
        btn5 = findViewById(R.id.btn_5)
        btn6 = findViewById(R.id.btn_6)
        btn7 = findViewById(R.id.btn_7)
        btn8 = findViewById(R.id.btn_8)
        btn9 = findViewById(R.id.btn_9)
        btnAnswer = findViewById(R.id.btn_answer)
        btnDot = findViewById(R.id.btn_dot)
        btnClear = findViewById(R.id.btn_clear)
        btnNegative = findViewById(R.id.btn_negative)
        btnModulo = findViewById(R.id.btn_modulo)
        btnDivide = findViewById(R.id.btn_divide)
        btnMultiply = findViewById(R.id.btn_multiply)
        btnAdd = findViewById(R.id.btn_add)
        btnSubtract = findViewById(R.id.btn_substract)
        textResult = findViewById(R.id.text_result)
    }
    // todo 2 done

    // todo 15: implement click event for buttons
    override fun onClick(view: View) {
        when (view.id) {
            R.id.btn_0 -> {
                model.appendNumber(btn0.text[0])
            }
            R.id.btn_1 -> {
                model.appendNumber(btn1.text[0])
            }
            R.id.btn_2 -> {
                model.appendNumber(btn2.text[0])
            }
            R.id.btn_3 -> {
                model.appendNumber(btn3.text[0])
            }
            R.id.btn_4 -> {
                model.appendNumber(btn4.text[0])
            }
            R.id.btn_5 -> {
                model.appendNumber(btn5.text[0])
            }
            R.id.btn_6 -> {
                model.appendNumber(btn6.text[0])
            }
            R.id.btn_7 -> {
                model.appendNumber(btn7.text[0])
            }
            R.id.btn_8 -> {
                model.appendNumber(btn8.text[0])
            }
            R.id.btn_9 -> {
                model.appendNumber(btn9.text[0])
            }
            R.id.btn_dot -> {
                model.appendNumber(btnDot.text[0])
            }
            R.id.btn_clear -> {
                model.clear()
            }
            R.id.btn_add -> {
                model.appendNumber(btnAdd.text[0])
                model.setOperator(Operator.ADD)
            }
            R.id.btn_multiply -> {
                model.appendNumber(btnMultiply.text[0])
                model.setOperator(Operator.MUL)
            }
            R.id.btn_divide -> {
                model.appendNumber(btnDivide.text[0])
                model.setOperator(Operator.DIV)
            }
            R.id.btn_modulo -> {
                model.appendNumber(btnModulo.text[0])
                model.setOperator(Operator.MOD)
            }
            R.id.btn_substract -> {
                model.appendNumber(btnSubtract.text[0])
                model.setOperator(Operator.SUB)
            }
            R.id.btn_answer -> {
                model.calculateAnswer()
            }
            R.id.btn_negative -> {
                model.changeSign()
            }
        }
    }
    // todo 15 done
}