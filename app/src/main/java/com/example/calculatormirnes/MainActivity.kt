package com.example.calculatormirnes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.calculatormirnes.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
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
        val log=findViewById<Button>(R.id.blog)
        val btan=findViewById<Button>(R.id.btan)
        val bsin=findViewById<Button>(R.id.bsin)
        val bcos=findViewById<Button>(R.id.bcos)
        val bb1=findViewById<Button>(R.id.bb1)
        val bb2=findViewById<Button>(R.id.bb2)
        var dugme: Boolean =true
        b0.setOnClickListener {
            tvmain.text = "${tvmain.text}0"
        }
        b1.setOnClickListener {
            tvmain.text = "${tvmain.text}1"
        }
        b2.setOnClickListener {
            tvmain.text = "${tvmain.text}2"
        }
        b3.setOnClickListener {
            tvmain.text = "${tvmain.text}3"
        }
        b4.setOnClickListener {
            tvmain.text = "${tvmain.text}4"
        }
        b5.setOnClickListener {
            tvmain.text = "${tvmain.text}5"
        }
        b6.setOnClickListener {
            tvmain.text = "${tvmain.text}6"
        }
        b7.setOnClickListener {
            tvmain.text = "${tvmain.text}7"
        }
        b8.setOnClickListener {
            tvmain.text = "${tvmain.text}8"
        }
        b9.setOnClickListener {
            tvmain.text = "${tvmain.text}9"
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
                tvmain.text = "0."
            }
            else if(dugme){
                tvmain.text="${tvmain.text}."
                dugme=false
            }
        }
            bplus.setOnClickListener {
            val tvmainrec=tvmain.text
            val tvmainsize=tvmainrec.length
            if(tvmainsize>0){
                if(tvmainrec[tvmainsize-1]!='×'&&tvmainrec[tvmainsize-1]!='+'&&tvmainrec[tvmainsize-1]!='-'&&tvmainrec[tvmainsize-1]!='÷'){//projveri imal plus zadnja
                    tvmain.text="${tvmain.text}+"
                    dugme=true
                }
                else if(tvmainrec[tvmainsize-1]=='×'||tvmainrec[tvmainsize-1]=='-'||tvmainrec[tvmainsize-1]=='÷'){//privjeri imal -,/ i * stavi umjesto +
                    val valText = tvmain.text.toString()
                    val updatedVal = valText.substring(0, valText.length - 1)
                    tvmain.text = updatedVal
                    tvmain.text= "${tvmain.text}+"
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
            }
        }
        bsqrt.setOnClickListener {
            val valStr = tvmain.text.toString()
            val r = Math.sqrt(valStr.toDouble())
            tvmain.text = r.toString()
        }
        bequal.setOnClickListener {
            showResult()

        }
    }

    private fun getInputExpression(): String {
        val tvmain=findViewById<TextView>(R.id.tvmain)
        var expression=tvmain.text.replace(Regex("÷"),"/")
        expression=expression.replace(Regex("×"),"*")
        return expression
    }

    private fun showResult() {
        val tvmain=findViewById<TextView>(R.id.tvmain)
        try{
            val expression=getInputExpression()
            val result=Expression(expression).calculate()
            if (result.isNaN()){
                //Show error message
                tvmain.text="Error"
                tvmain.setTextColor(ContextCompat.getColor(this, R.color.purple_200))
            }
            else{
                tvmain.text=DecimalFormat("0.######").format(result).toString()
                tvmain.setTextColor(ContextCompat.getColor(this,R.color.white))
            }
        }catch (e: java.lang.Exception){
            tvmain.text="Error"
            tvmain.setTextColor(ContextCompat.getColor(this,R.color.purple_200))
        }
    }
}