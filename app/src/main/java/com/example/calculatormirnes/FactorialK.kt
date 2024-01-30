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
    fun result(res: String): Long{
        var resfact:Long = 1
        if(res.toLong()<=17) {
            var numb:Long = 1
            while ((numb - 1) != res.toLong()) {
                resfact *= numb
                numb++
            }
        }
        else{//this problem.. 15! treba staviti brojE+10

        }
        return resfact
    }
}