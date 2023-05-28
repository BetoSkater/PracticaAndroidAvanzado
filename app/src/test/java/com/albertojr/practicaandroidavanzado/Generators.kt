package com.albertojr.practicaandroidavanzado



    fun generateFakeToken():String{
        var fakeToken = ""
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        var has254Chars = false
        //Always true, peta.
        /*
        while (fakeToken.length<254){
            fakeToken.plus(allowedChars.random())
        }

         */
        while (!has254Chars){
            fakeToken = "f$fakeToken${allowedChars.random()}"
            if(fakeToken.length >= 253){
                has254Chars = true
            }
        }
        return fakeToken
    }

    fun generateFakeToken2():String{
    return "4545kgygyhbjhb464.jhjvhjbb86464654648"
}