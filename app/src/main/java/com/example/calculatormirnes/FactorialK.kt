package com.example.calculatormirnes

class FactorialK {
    fun factorialfindcomma(res: String):Boolean{
        var i=0
        var resultfact=false
        while (i!=res.length){
            if(res[i]=='.'||res[i]==','){
                resultfact=true
            }
            i++
        }
        return resultfact
    }
    fun result(res: String): Int{
        var res1=res.toInt()
        var numb=1
        var resfact=1
        while((numb-1)!=res.toInt()){
            resfact*=numb
            numb++
        }
        return resfact
    }
}