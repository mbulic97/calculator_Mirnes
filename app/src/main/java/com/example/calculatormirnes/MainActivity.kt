package com.example.calculatormirnes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.calculatormirnes.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var deg: Boolean=false
    private var rad: Boolean=true
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        val pi : String="3.14159265"

        //val view=root
        //setContentView(view)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tvmain=findViewById<TextView>(R.id.tvmain)
        val tvsec=findViewById<TextView>(R.id.tvsec)
        val b0=findViewById<Button>(R.id.b0)
        val b1=findViewById<Button>(R.id.b1)
        val b2=findViewById<Button>(R.id.b2)
        val b3=findViewById<Button>(R.id.b3)
        val b4=findViewById<Button>(R.id.b4)
        val b5=findViewById<Button>(R.id.b5)
        val b6=findViewById<Button>(R.id.b6)
        val b7=findViewById<Button>(R.id.b7)
        val b8=findViewById<Button>(R.id.b8)
        val b9=findViewById<Button>(R.id.b9)
        val bac=findViewById<Button>(R.id.bac)
        val bc=findViewById<Button>(R.id.bc)
        val bpi=findViewById<Button>(R.id.bpi)
        val bdot=findViewById<Button>(R.id.bdot)
        val bequal=findViewById<Button>(R.id.bequal)
        val bplus=findViewById<Button>(R.id.bplus)
        val bmin=findViewById<Button>(R.id.bmin)
        val bmul=findViewById<Button>(R.id.bmul)
        val bdiv=findViewById<Button>(R.id.bdiv)
        val binv=findViewById<Button>(R.id.binv)
        val bsqrt=findViewById<Button>(R.id.bsqrt)
        val bsquare=findViewById<Button>(R.id.bsquare)
        val fact=findViewById<Button>(R.id.bfact)
        val bln=findViewById<Button>(R.id.bln)
        val blog=findViewById<Button>(R.id.blog)
        val btan=findViewById<Button>(R.id.btan)
        val bsin=findViewById<Button>(R.id.bsin)
        val bcos=findViewById<Button>(R.id.bcos)
        val bb1=findViewById<Button>(R.id.bb1)
        val bb2=findViewById<Button>(R.id.bb2)
        var dugme: Boolean =true
        /*b0.setOnClickListener {
            tvmain.text="${tvmain.text}0"

        }*/
        b0.setOnClickListener {
            val currentText = tvmain.text.toString()
            val newText = getString(R.string.placeholder_text, currentText, "0")
            tvmain.text = newText
        }
        b1.setOnClickListener {
            val currentText = tvmain.text.toString()
            val newText = getString(R.string.placeholder_text, currentText, "1")
            tvmain.text = newText
        }
        b2.setOnClickListener {
            val currentText = tvmain.text.toString()
            val newText = getString(R.string.placeholder_text, currentText, "2")
            tvmain.text = newText
        }
        b3.setOnClickListener {
            val currentText = tvmain.text.toString()
            val newText = getString(R.string.placeholder_text, currentText, "3")
            tvmain.text = newText
        }
        b4.setOnClickListener {
            val currentText = tvmain.text.toString()
            val newText = getString(R.string.placeholder_text, currentText, "4")
            tvmain.text = newText
        }
        b5.setOnClickListener {
            val currentText = tvmain.text.toString()
            val newText = getString(R.string.placeholder_text, currentText, "5")
            tvmain.text = newText
        }
        b6.setOnClickListener {
            val currentText = tvmain.text.toString()
            val newText = getString(R.string.placeholder_text, currentText, "6")
            tvmain.text = newText
        }
        b7.setOnClickListener {
            val currentText = tvmain.text.toString()
            val newText = getString(R.string.placeholder_text, currentText, "7")
            tvmain.text = newText
        }
        b8.setOnClickListener {
            val currentText = tvmain.text.toString()
            val newText = getString(R.string.placeholder_text, currentText, "8")
            tvmain.text = newText
        }
        b9.setOnClickListener {
            val currentText = tvmain.text.toString()
            val newText = getString(R.string.placeholder_text, currentText, "9")
            tvmain.text = newText
        }
        bac.setOnClickListener{
            tvmain.text=""
            tvsec.text=""
            dugme=true
        }
        bc.setOnClickListener {
            val valText = tvmain.text.toString()
            if(valText.length>0){
                val updatedVal = valText.substring(0, valText.length - 1)
                tvmain.text = updatedVal
            }

        }
        bdot.setOnClickListener {
            val tvmainrec=tvmain.text
            if(tvmain.text.length==0) {
                val currentText = tvmain.text.toString()
                val newText = getString(R.string.placeholder_text, currentText, "0.")
                tvmain.text = newText
            }
            else if(dugme){
                val currentText = tvmain.text.toString()
                val newText = getString(R.string.placeholder_text, currentText, ".")
                tvmain.text = newText
                dugme=false
            }
        }
            bplus.setOnClickListener {
            val tvmainrec=tvmain.text
            val tvmainsize=tvmainrec.length
            if(tvmainsize>0){
                if(tvmainrec[tvmainsize-1]!='×'&&tvmainrec[tvmainsize-1]!='+'&&tvmainrec[tvmainsize-1]!='-'&&tvmainrec[tvmainsize-1]!='÷'){//projveri imal plus zadnja
                    val currentText = tvmain.text.toString()
                    val newText = getString(R.string.placeholder_text, currentText, "+")
                    tvmain.text = newText
                    dugme=true
                }
                else if(tvmainrec[tvmainsize-1]=='×'||tvmainrec[tvmainsize-1]=='-'||tvmainrec[tvmainsize-1]=='÷'){//privjeri imal -,/ i * stavi umjesto +
                    val valText = tvmain.text.toString()
                    val updatedVal = valText.substring(0, valText.length - 1)
                    tvmain.text = updatedVal
                    val currentText = tvmain.text.toString()
                    val newText = getString(R.string.placeholder_text, currentText, "+")
                    tvmain.text = newText
                }
            }
        }
        bmin.setOnClickListener {
            val tvmainrec=tvmain.text
            val tvmainsize=tvmainrec.length
            if(tvmainsize>0){
                if(tvmainrec[tvmainsize-1]!='×'&&tvmainrec[tvmainsize-1]!='+'&&tvmainrec[tvmainsize-1]!='-'&&tvmainrec[tvmainsize-1]!='÷'){//projveri imal minus zadnja
                    tvmain.text="${tvmain.text}-"
                    dugme=true
                }
                else if(tvmainrec[tvmainsize-1]=='×'||tvmainrec[tvmainsize-1]=='+'||tvmainrec[tvmainsize-1]=='÷'){//privjeri imal -,/ i * stavi umjesto +
                    val valText = tvmain.text.toString()
                    val updatedVal = valText.substring(0, valText.length - 1)
                    tvmain.text = updatedVal
                    tvmain.text= "${tvmain.text}-"
                }
            }
        }
        bmul.setOnClickListener {
            val tvmainrec=tvmain.text
            val tvmainsize=tvmainrec.length
            if(tvmainsize>0){
                if(tvmainrec[tvmainsize-1]!='×'&&tvmainrec[tvmainsize-1]!='+'&&tvmainrec[tvmainsize-1]!='-'&&tvmainrec[tvmainsize-1]!='÷'){//projveri imal x zadnja
                    tvmain.text="${tvmain.text}×"
                    dugme=true
                }
                else if(tvmainrec[tvmainsize-1]=='+'||tvmainrec[tvmainsize-1]=='-'||tvmainrec[tvmainsize-1]=='÷'){//privjeri imal -,/ i * stavi umjesto +
                    val valText = tvmain.text.toString()
                    val updatedVal = valText.substring(0, valText.length - 1)
                    tvmain.text = updatedVal
                    tvmain.text= "${tvmain.text}×"
                }
            }
        }
            bdiv.setOnClickListener {
            val tvmainrec=tvmain.text
            val tvmainsize=tvmainrec.length
            if(tvmainsize>0){
                if(tvmainrec[tvmainsize-1]!='×'&&tvmainrec[tvmainsize-1]!='+'&&tvmainrec[tvmainsize-1]!='-'&&tvmainrec[tvmainsize-1]!='÷'){//projveri imal ÷ zadnja
                    tvmain.text="${tvmain.text}÷"
                    dugme=true
                }
                else if(tvmainrec[tvmainsize-1]=='+'||tvmainrec[tvmainsize-1]=='-'||tvmainrec[tvmainsize-1]=='×'){//privjeri imal -,/ i * stavi umjesto +
                    val valText = tvmain.text.toString()
                    val updatedVal = valText.substring(0, valText.length - 1)
                    tvmain.text = updatedVal
                    tvmain.text= "${tvmain.text}÷"
                }

            }
        }
        bsqrt.setOnClickListener {

            val valStr = tvmain.text.toString()
            if(valStr.length>0){
                val r = Math.sqrt(valStr.toDouble())
                val fro =String.format("%.5f",r)
                tvmain.text = fro
            }
            else{
                Toast.makeText(this,"Error", Toast.LENGTH_LONG).show()

            }

        }
        bb1.setOnClickListener {
            tvmain.text="${tvmain.text}("
        }
        bb2.setOnClickListener {
            tvmain.text="${tvmain.text})"
        }
        bpi.setOnClickListener {
            tvmain.text="${tvmain.text}${pi}"
        }
        bsin.setOnClickListener {
            tvmain.text="${tvmain.text}sin("
        }
        bcos.setOnClickListener {
            tvmain.text="${tvmain.text}cos("
        }
        fact.setOnClickListener {
            tvmain.text="${tvmain.text}!"
        }
        bsquare.setOnClickListener {
            val valStr = tvmain.text.toString()
            if(valStr.length>0){
                val r = Math.pow(valStr.toDouble(),2.0)
                tvmain.text = r.toString()
            }
            else{
                Toast.makeText(this,"Error", Toast.LENGTH_LONG).show()
            }

        }
        binv.setOnClickListener {
            tvmain.text="1/${tvmain.text}"
        }
        bequal.setOnClickListener {
            showResult()
        }
        bln.setOnClickListener {
            tvmain.text="${tvmain.text}ln("
        }
        btan.setOnClickListener {
            tvmain.text="${tvmain.text}tan("
        }
        blog.setOnClickListener {
            if(rad){
                rad=false
                deg=true
                blog.text="DEG"
            }
            else {
                rad = true
                deg=false
                blog.text="RAD"
            }

        }
    }



    private fun getInputExpression(): String {
        val tvmain=findViewById<TextView>(R.id.tvmain)
        var expression=tvmain.text.replace(Regex("÷"),"/")
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

    private fun showResult() {
        val tvmain=findViewById<TextView>(R.id.tvmain)
        try{
            val expression=getInputExpression()
            val result=Expression(expression).calculate()

            if (result.isNaN()){
                //Show error message
                Toast.makeText(this,"Error", Toast.LENGTH_LONG).show()
            }
            else{
                tvmain.text=DecimalFormat("0.######").format(result).toString()
                tvmain.setTextColor(ContextCompat.getColor(this,R.color.white))
            }
        }catch (e: java.lang.Exception){
            Toast.makeText(this,"Error", Toast.LENGTH_LONG).show()
        }
    }
}