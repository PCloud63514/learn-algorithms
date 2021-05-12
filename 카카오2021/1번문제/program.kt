fun main() {
    var str:String = "...!@BaT#*..y.abcdefghijklm"
    str = str.toLowerCase()
    str = str.replace("[^a-z0-9._-]", "")

    println(str)
}