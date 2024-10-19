package bot

fun main() {
    println("""Hello! My name is Aid.
I was created in 2023.""")
    println("Please, remind me your name.")
    val name = readln()
    println("What a great name you have, $name!")
    println("Let me guess your age.")
    println("Enter remainders of dividing your age by 3, 5 and 7.")
    val remainder3 = readln().toInt()
    val remainder5 = readln().toInt()
    val remainder7 = readln().toInt()
    val age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105
    println("Your age is $age; that's a good time to start programming!")
    println("Now I will prove to you that I can count to any number you want.")
    val n = readln().toInt()
    repeat(n + 1) { i ->
      println("$i!")
    }
    println("""Let's test your programming knowledge.
Why do we use methods?
1. To repeat a statement multiple times.
2. To decompose a program into several small subroutines.
3. To determine the execution time of a program.
4. To interrupt the execution of a program.""")
    while(readln() != "2") {
      println("Please, try again.")
    }
    println("Congratulations, have a nice day!")
}
