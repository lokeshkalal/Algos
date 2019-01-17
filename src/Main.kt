fun hello(): String = "ABBDCACB"

fun main(args: Array<String>) {
    val lookUpMap: HashMap<String, Int> = HashMap()
    println(longestPalindromicSubsequence(hello(), 0, hello().length - 1, lookUpMap))
}


fun longestPalindromicSubsequence(string: String, first: Int, last: Int, map: HashMap<String, Int>): Int {
    if (first > last)
        return 0

    if (first == last)
        return 1

    val key: String = first.toString() + ":" + last.toString()


    if (string[first].equals(string[last])) {
        map.put(key, 2 + longestPalindromicSubsequence(string, first + 1, last - 1, map))
    } else {
        map.put(key, Math.max(longestPalindromicSubsequence(string, first + 1, last, map), longestPalindromicSubsequence(string, first, last - 1, map)))
    }

    return map.get(key)!!
}