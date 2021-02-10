import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun readBufferToInt(): Triple<Int, Int, Int> {
    BufferedReader(InputStreamReader(System.`in`)).use { br ->
        val token = StringTokenizer(br.readLine())
        return Triple(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()))
    }
}

fun main(args:Array<String>) {
    val (a, b, c) = readBufferToInt()

    if (b >= c) {
        println("-1")
    } else {
        println(a/(c-b) + 1)
    }
}
