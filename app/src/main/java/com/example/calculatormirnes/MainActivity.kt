package com.example.calculatormirnes

import android.icu.text.DecimalFormatSymbols
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.calculatormirnes.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat
import java.util.*
import kotlin.math.pow
private var dugme_faktor: Boolean=false
private var deg: Boolean=false
private var rad: Boolean=true
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        val pi : String="3.14159265"

        //val view=root
        //setContentView(view)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tvmain=findViewById<TextView>(R.id.tvmain)
        val  tvsec=findViewById<TextView>(R.id.tvsec)
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
            if(tvsec.text.toString().length>0){
                if(tvsec.text.toString()[0]!='0'){// provjeri jel poc 0
                    getStringtvsec(tvsec,0)
                }
            }
            else{//prvi put 0
                getStringtvsec(tvsec,0)

            }

        }
        b1.setOnClickListener {
            ispistvsecsamobrojod1do9(tvsec,1)

        }
        b2.setOnClickListener {
            ispistvsecsamobrojod1do9(tvsec,2)

        }
        b3.setOnClickListener {
            ispistvsecsamobrojod1do9(tvsec,3)

        }
        b4.setOnClickListener {
            ispistvsecsamobrojod1do9(tvsec,4)

        }
        b5.setOnClickListener {
            ispistvsecsamobrojod1do9(tvsec,5)

        }
        b6.setOnClickListener {
            ispistvsecsamobrojod1do9(tvsec,6)

        }
        b7.setOnClickListener {
            ispistvsecsamobrojod1do9(tvsec,7)

        }
        b8.setOnClickListener {
            ispistvsecsamobrojod1do9(tvsec,8)

        }
        b9.setOnClickListener {
            ispistvsecsamobrojod1do9(tvsec,9)

        }
        bac.setOnClickListener{
            tvmain.text=""
            tvsec.text=""
            dugme=true
            dugme_faktor=false
        }
        bc.setOnClickListener {
            val valText = tvsec.text.toString()
            if(valText.length>0){
                val updatedVal = valText.substring(0, valText.length - 1)
                tvsec.text = updatedVal
            }

        }
        bdot.setOnClickListener {
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
        bplus.setOnClickListener {
            val tvmainrec=tvsec.text
            val tvmainsize=tvmainrec.length
            if(tvmainsize>0){
                if(tvmainrec[tvmainsize-1]!='×'&&tvmainrec[tvmainsize-1]!='+'&&tvmainrec[tvmainsize-1]!='-'&&tvmainrec[tvmainsize-1]!='÷'){//projveri imal plus zadnja
                    val currentText = tvsec.text.toString()
                    val newText = getString(R.string.placeholder_text, currentText, "+")
                    tvsec.text = newText
                    dugme=true
                }
                else if(tvmainrec[tvmainsize-1]=='×'||tvmainrec[tvmainsize-1]=='-'||tvmainrec[tvmainsize-1]=='÷'){//privjeri imal -,/ i * stavi umjesto +
                    val valText = tvsec.text.toString()
                    val updatedVal = valText.substring(0, valText.length - 1)
                    tvsec.text = updatedVal
                    val currentText = tvsec.text.toString()
                    val newText = getString(R.string.placeholder_text, currentText, "+")
                    tvsec.text = newText
                }
            }
        }
        bmin.setOnClickListener {
            val tvmainrec=tvsec.text
            val tvmainsize=tvmainrec.length
            if(tvmainsize>0){
                if(tvmainrec[tvmainsize-1]!='×'&&tvmainrec[tvmainsize-1]!='+'&&tvmainrec[tvmainsize-1]!='-'&&tvmainrec[tvmainsize-1]!='÷'){//projveri imal minus zadnja
                    tvsec.text="${tvsec.text}-"
                    dugme=true
                }
                else if(tvmainrec[tvmainsize-1]=='×'||tvmainrec[tvmainsize-1]=='+'||tvmainrec[tvmainsize-1]=='÷'){//privjeri imal -,/ i * stavi umjesto +
                    val valText = tvsec.text.toString()
                    val updatedVal = valText.substring(0, valText.length - 1)
                    tvsec.text = updatedVal
                    tvsec.text= "${tvsec.text}-"
                }
            }
        }
        bmul.setOnClickListener {
            val tvmainrec=tvsec.text
            val tvmainsize=tvmainrec.length
            if(tvmainsize>0){
                if(tvmainrec[tvmainsize-1]!='×'&&tvmainrec[tvmainsize-1]!='+'&&tvmainrec[tvmainsize-1]!='-'&&tvmainrec[tvmainsize-1]!='÷'){//projveri imal x zadnja
                    tvsec.text="${tvsec.text}×"
                    dugme=true
                }
                else if(tvmainrec[tvmainsize-1]=='+'||tvmainrec[tvmainsize-1]=='-'||tvmainrec[tvmainsize-1]=='÷'){//privjeri imal -,/ i * stavi umjesto +
                    val valText = tvsec.text.toString()
                    val updatedVal = valText.substring(0, valText.length - 1)
                    tvsec.text = updatedVal
                    tvsec.text= "${tvsec.text}×"
                }
            }
        }
        bdiv.setOnClickListener {
            val tvmainrec=tvsec.text
            val tvmainsize=tvmainrec.length
            if(tvmainsize>0){
                if(tvmainrec[tvmainsize-1]!='×'&&tvmainrec[tvmainsize-1]!='+'&&tvmainrec[tvmainsize-1]!='-'&&tvmainrec[tvmainsize-1]!='÷'){//projveri imal ÷ zadnja
                    tvsec.text="${tvsec.text}÷"
                    dugme=true
                }
                else if(tvmainrec[tvmainsize-1]=='+'||tvmainrec[tvmainsize-1]=='-'||tvmainrec[tvmainsize-1]=='×'){//privjeri imal -,/ i * stavi umjesto +
                    val valText = tvsec.text.toString()
                    val updatedVal = valText.substring(0, valText.length - 1)
                    tvsec.text = updatedVal
                    tvsec.text= "${tvmain.text}÷"
                }

            }
        }
        bsqrt.setOnClickListener {
            if(tvsec.length()==0){
                tvsec.text="√(${tvsec.text}"
            }
            else{
                tvsec.text="${tvsec.text}√("
            }
        }
        bb1.setOnClickListener {
            tvsec.text="${tvsec.text}("
        }
        bb2.setOnClickListener {
            tvsec.text="${tvsec.text})"
        }
        bpi.setOnClickListener {
            tvsec.text="${tvsec.text}${pi}"
        }
        bsin.setOnClickListener {
            tvsec.text="${tvsec.text}sin("
        }
        bcos.setOnClickListener {
            tvsec.text="${tvsec.text}cos("
        }
        fact.setOnClickListener {
            dugme_faktor=true
            tvsec.text="${tvsec.text}!"
        }
        bsquare.setOnClickListener {
            tvsec.text="${tvsec.text}^(2)"


        }
        binv.setOnClickListener {
            tvsec.text="1/(${tvsec.text}"
        }
        bequal.setOnClickListener {
            showResult()
        }
        bln.setOnClickListener {
            tvsec.text="${tvsec.text}ln("
        }
        btan.setOnClickListener {
            tvsec.text="${tvsec.text}tan("
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

    private fun ispistvsecsamobrojod1do9(tvsec: TextView, i: Int) {
        if(tvsec.text.toString().length>0){
            if(tvsec.text.toString()[0]=='0'&&tvsec.text.length==1){// provjeri jel poc 0 jer 01 ili 02 umjesto 1 ili 2
                val valText = tvsec.text.toString()
                val updatedVal = valText.substring(0, valText.length - 1)
                tvsec.text = updatedVal
                getStringtvsec(tvsec, i)
            }
            else{
                getStringtvsec(tvsec,i)

            }
        }
        else{//prvi put 0
            getStringtvsec(tvsec,i)
        }

    }


    private fun getStringtvsec(tvsec: TextView?, i: Int) {
        val currentText = tvsec?.text.toString()
        val newText = getString(R.string.placeholder_text, currentText, "$i")
        tvsec?.text = newText
    }
    private fun getInputExpression(): String {
        val tvsec=findViewById<TextView>(R.id.tvsec)
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
    private fun showResult() {
        val tvsec=findViewById<TextView>(R.id.tvsec)
        val tvmain=findViewById<TextView>(R.id.tvmain)
        try{
            if(dugme_faktor){
                var i=0
                var findcomma=false
                val tvmaintostring=tvsec.text.toString()
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
                    }
                    else{
                        tvmain.text=DecimalFormat("0.######").format(result).toString()
                        tvmain.setTextColor(ContextCompat.getColor(this,R.color.white))
                    }
                }
            }
            else{//sve ostalo osim faktora
                val expression=getInputExpression()
                val result=Expression(expression).calculate()

                if (result.isNaN()){
                    //Show error message
                    Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show()
                }
                else{
                    tvmain.text=DecimalFormat("0.######").format(result).toString()
                    tvmain.setTextColor(ContextCompat.getColor(this,R.color.white))
                }
            }
        }catch (e: java.lang.Exception){
            Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show()

        }
    }
}