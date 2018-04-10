fun main(args : Array<String>) {
    var kmp : Kmp = Kmp()
    var index = kmp.KmpSearch("ABABDABABC" , "ABABC")
    println(String.format("index = %s",index))
}