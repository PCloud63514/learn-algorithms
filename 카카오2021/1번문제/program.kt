fun main() {
    println("Start")
    // ...!@BaT#*..y.abcdefghijklm.
    var str:String = "abcdefghijklmn.p"
    var regex = "[^a-z0-9\\.\\-\\_]".toRegex()

    str = str.toLowerCase()
    str = regex.replace(str, "")

    while(str.indexOf("..") != -1) {
        str = str.replace("..", ".")
    }

    str = "^\\.|\\.$".toRegex().replace(str,"")

    if(str.isEmpty()) {
        str = "a"
    }

    if(16 <= str.length) {
        str = str.substring(0, 15)
        str = "\\.$".toRegex().replace(str, "")
    }

    if(2 >= str.length) {
        var c = str.last()
        while(str.length != 3) {
            str = str.plus(c)
        }
    }
    println(str)
}