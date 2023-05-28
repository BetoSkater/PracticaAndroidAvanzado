package com.albertojr.practicaandroidavanzado



    fun generateFakeToken():String{
        var fakeToken = ""
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')

        while (fakeToken.length<254){
            fakeToken.plus(allowedChars.random())
        }
        return fakeToken
    }

    fun generateFakeToken2():String{
    return "4545kgygyhbjhb464.jhjvhjbb86464654648"
}