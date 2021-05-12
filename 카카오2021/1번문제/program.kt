fun main() {
    println("Start")
    var str:String = "...!@BaT#*..y.abcdefghijklm."
    str = str.toLowerCase()
    str = str.replace("[^a-z0-9._-]", "")

    while(str.indexOf("..") != -1) {
        str = str.replace("..", ".")
    }
    str = str.replace("^.|.$","")
    println(str)
}