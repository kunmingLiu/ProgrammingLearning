class Kmp{
    fun KmpSearch(text : String , pattern: String) : Int{
        var lsp = createLspTable(pattern)
        var j = 0
        for (i in 0 until text.length){

            while (j > 0 && text[i] != pattern[j]){
                j = lsp[j-1]
            }


            if(text[i] == pattern[j]){
                j++
                if( j == pattern.length)
                    return i - (j - 1)
            }
        }

        return -1
    }
    
    fun createLspTable(pattern : String) : IntArray{
        var lsp = IntArray(pattern.length)
        lsp[0] = 0

        for(i in 1 until pattern.length){
            var j : Int = lsp[i-1]

            while (j > 0 && pattern[i] != pattern[j]){
                j = lsp[j-1]
            }
            if(pattern[i] == pattern[j]){
                j++
            }
            lsp[i] = j
        }


        return lsp
    }

}