class Solution {
    fun solution(numbers: IntArray): Double {
       val f = numbers[0].toDouble()
       val l = numbers[numbers.size - 1]
        
       val sum: Double = (numbers.size * (f + l)) / 2
       return sum / numbers.size
    }
}