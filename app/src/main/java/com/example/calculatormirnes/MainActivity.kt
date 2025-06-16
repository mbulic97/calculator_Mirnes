package com.example.calculatormirnes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.calculatormirnes.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat
private var dugme_faktor: Boolean=false
private var deg: Boolean=false
private var rad: Boolean=true
private var dugme: Boolean= true
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
        calculatorApp()
    }

    private fun calculatorApp() {
        val pi : String="3.14159265"
        setupNumberButtons()
        setupOperatorButtons()
        setupAdvancedFunctions(pi)
        setupListeners()
    }

    private fun setupListeners() {
        binding.bac.setOnClickListener{
            binding.apply {
                tvmain.text=""
                tvsec.text="0"
                dugme=true
                dugme_faktor=false
            }

        }
        binding.bc.setOnClickListener {
            binding.apply {
                val valText = tvsec.text.toString()
                if(valText.length>0){
                    val updatedVal = valText.substring(0, valText.length - 1)
                    if (updatedVal.length>0)
                        tvsec.text = updatedVal
                    else
                        tvsec.text="0"
                }
            }
        }
        binding.bequal.setOnClickListener {
            showResult()
        }
    }

    private fun setupAdvancedFunctions(pi: String) {
        binding.bsqrt.setOnClickListener {
            binding.apply {
                tvsec.text="${tvsec.text}√("
            }

        }
        binding.bb1.setOnClickListener {
            binding.tvsec.text="${binding.tvsec.text}("
        }
        binding.bb2.setOnClickListener {
            binding.tvsec.text="${binding.tvsec.text})"
        }
        binding.bpi.setOnClickListener {
            binding.tvsec.text="${binding.tvsec.text}${pi}"
        }
        binding.bsin.setOnClickListener {
            binding.tvsec.text="${binding.tvsec.text}sin("
        }
        binding.bcos.setOnClickListener {
            binding.tvsec.text="${binding.tvsec.text}cos("
        }
        binding.bfact.setOnClickListener {
            dugme_faktor=true
            binding.tvsec.text="${binding.tvsec.text}!"
        }
        binding.bsquare.setOnClickListener {
            binding.tvsec.text="${binding.tvsec.text}^(2)"
        }
        binding.binv.setOnClickListener {
            binding.tvsec.text="1/(${binding.tvsec.text}"
        }
        binding.bln.setOnClickListener {
            binding.tvsec.text="${binding.tvsec.text}ln("
        }
        binding.btan.setOnClickListener {
            binding.tvsec.text="${binding.tvsec.text}tan("
        }
        binding.blog.setOnClickListener {
            if(rad){
                rad=false
                deg=true
                binding.blog.text="DEG"
            }
            else {
                rad = true
                deg=false
                binding.blog.text="RAD"
            }
        }
    }

    private fun setupOperatorButtons() {

        binding.bplus.setOnClickListener {
            dodajOperator('+')
        }
        binding.bmin.setOnClickListener {
            dodajOperator('-')
        }
        binding.bmul.setOnClickListener {
            dodajOperator('×')
        }
        binding.bdiv.setOnClickListener {
            dodajOperator('÷')
        }
    }

    private fun dodajOperator(c: Char) {
        binding.apply {
            val tvmainrec=tvsec.text
            val tvmainsize=tvmainrec.length
            if(tvmainsize>0){
                if(tvmainrec[tvmainsize-1]!='×'&&tvmainrec[tvmainsize-1]!='+'&&tvmainrec[tvmainsize-1]!='-'&&tvmainrec[tvmainsize-1]!='÷'){//projveriti imal x left, ne smije "xx" 2 puta ili vise
                    tvsec.text="${tvsec.text}${c}"
                    dugme=true
                }
                else if((tvmainrec[tvmainsize-1]=='×' || tvmainrec[tvmainsize-1]=='+' || tvmainrec[tvmainsize-1]=='-' || tvmainrec[tvmainsize-1]== '÷')&& tvmainrec[tvmainsize-1]!=c){//provjeriti imal -,/ i * staviti umjesto + npr 2/ umjesto 2* ne smije 2/*
                    val valText = tvsec.text.toString()
                    val updatedVal = valText.substring(0, valText.length - 1)
                    tvsec.text = updatedVal
                    tvsec.text= "${tvsec.text}${c}"
                }
            }
        }
    }


    private fun setupNumberButtons() {
        binding.b0.setOnClickListener {
            binding.apply {
                if(tvsec.text.toString().length>0){
                    if(tvsec.text.toString()[0]!='0'&&tvsec.text.length==1){// provjeri jel poc 0 ne smije "00" dva puta
                        getStringtvsec(0)
                    }
                    else if (tvsec.text.length>1){
                        getStringtvsec(0)

                    }
                }
                else{//prvi put 0
                    getStringtvsec(0)

                }
            }
        }
        binding.b1.setOnClickListener {
            ispistvsecsamobrojod1do9(1)
        }
        binding.b2.setOnClickListener {
            ispistvsecsamobrojod1do9(2)

        }
        binding.b3.setOnClickListener {
            ispistvsecsamobrojod1do9(3)

        }
        binding.b4.setOnClickListener {
            ispistvsecsamobrojod1do9(4)

        }
        binding.b5.setOnClickListener {
            ispistvsecsamobrojod1do9(5)

        }
        binding.b6.setOnClickListener {
            ispistvsecsamobrojod1do9(6)

        }
        binding.b7.setOnClickListener {
            ispistvsecsamobrojod1do9(7)

        }
        binding.b8.setOnClickListener {
            ispistvsecsamobrojod1do9(8)

        }
        binding.b9.setOnClickListener {
            ispistvsecsamobrojod1do9(9)
        }
        binding.bdot.setOnClickListener {
            binding.apply {
                val tvmainrec=tvsec.text
                if(tvsec.text.isEmpty()) {
                    val currentText = tvsec.text.toString()
                    val newText = getString(R.string.placeholder_text, currentText, "0.")
                    tvsec.text = newText
                }
                else if(dugme){
                    val currentText = tvsec.text.toString()
                    val newText = getString(R.string.placeholder_text, currentText, ".")
                    tvsec.text = newText
                    dugme=false
                }
            }
        }
    }


    private fun ispistvsecsamobrojod1do9(i: Int) {
        if(binding.tvsec.text.length<16){
            if(binding.tvsec.text[0]=='0'&&binding.tvsec.text.length==1){// provjeri jel poc 0 jer 01 ili 02 umjesto 1 ili 2
                val valText = binding.tvsec.text.toString()
                val updatedVal = valText.substring(0, valText.length - 1)
                binding.tvsec.text = updatedVal
                getStringtvsec(i)
            }
            else{
                getStringtvsec(i)
            }
        }
        else {
            Toast.makeText(this, "Cannot enter more than 15", Toast.LENGTH_SHORT).show()
        }
    }


    private fun getStringtvsec( i: Int) {
        val currentText = binding.tvsec.text.toString()
        val newText = getString(R.string.placeholder_text, currentText, "$i")
        binding.tvsec.text = newText
    }
    private fun getInputExpression(): String {
        //val tvsec=findViewById<TextView>(R.id.tvsec)
        binding.apply {
            var expression=tvsec.text.replace(Regex("÷"),"/")
            expression=expression.replace(Regex("×"),"*")
            if(deg){
                expression=expression.replace(Regex("tan\\(([^)]+)\\)")){
                    val degree=it.groupValues[1].toDouble()
                    "tan(${Math.toRadians(degree)})"
                }

                /*expression=expression.replace(Regex("cos\\\\(((?:[^()]+|\\\\([^()]*\\\\))+)\\\\)")){
                    val degree=it.groupValues[1].toDouble()
                    "cos(${Math.toRadians(degree)})"
                }*/
                expression = expression.replace(Regex("cos\\(([^)]+)\\)")) {
                    val degree = it.groupValues[1].toDouble()
                    "cos(${Math.toRadians(degree)})"
                }
                expression=expression.replace(Regex("sin\\(([^)]+)\\)")){
                    val degree=it.groupValues[1].toDouble()
                    "sin(${Math.toRadians(degree)})"
                }
            }
            return expression
        }

    }
    private fun showResult() {
        try{
            if(dugme_faktor){
                var i=0
                var findcomma=false
                val tvmaintostring=binding.tvsec.text.toString()
                while (i!=tvmaintostring.length){
                    if(tvmaintostring[i]=='.'||tvmaintostring[i]==','){
                        findcomma=true
                    }
                    i++
                }
                if(findcomma){
                    Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show()

                }
                else{
                    val expression=getInputExpression()
                    val result=Expression(expression).calculate()

                    if (result.isNaN()){
                        //Show error message
                        Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show()
                        //binding.tvmain.text="Error"

                    }
                    else{
                        binding.tvmain.text=DecimalFormat("0.######").format(result).toString()
                        binding.tvmain.setTextColor(ContextCompat.getColor(this,R.color.white))
                    }
                }
            }
            else{//sve ostalo osim faktora
                val expression=getInputExpression()
                val result=Expression(expression).calculate()

                if (result.isNaN()){
                    //Show error message
                    Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show()

                    //binding.tvmain.text="Error"

                }
                else{
                    binding.tvmain.text=DecimalFormat("0.######").format(result).toString()
                    binding.tvmain.setTextColor(ContextCompat.getColor(this,R.color.white))
                }
            }
        }catch (e: java.lang.Exception){
            Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show()

            //binding.tvmain.text="Error"

        }
    }

}