package tictactoe

fun main() {

    var gameState = Array(9) { ' ' }

    
    printGrid(gameState)

    var currentPlayer = 'X'
    var gameFinished = false

    while (!gameFinished) {
        
        val input = readln()

        val (row, col) = try {
            input.split(" ").map { it.toInt() }
        } catch (e: NumberFormatException) {
            println("You should enter numbers!")
            continue
        }

        if (row !in 1..3 || col !in 1..3) {
            println("Coordinates should be from 1 to 3!")
            continue
        }

        val index = (row - 1) * 3 + (col - 1)

        if (gameState[index] != ' ') {
            println("This cell is occupied! Choose another one!")
            continue
        }

        gameState[index] = currentPlayer
        printGrid(gameState)

        if (checkWin(gameState, currentPlayer)) {
            println("${currentPlayer} wins")
            gameFinished = true
        } else if (checkDraw(gameState)) {
            println("Draw")
            gameFinished = true
        }

        currentPlayer = if (currentPlayer == 'X') 'O' else 'X'
    }
}

fun printGrid(gameState: Array<Char>) {
    println("---------")
    println("| ${gameState[0]} ${gameState[1]} ${gameState[2]} |")
    println("| ${gameState[3]} ${gameState[4]} ${gameState[5]} |")
    println("| ${gameState[6]} ${gameState[7]} ${gameState[8]} |")
    println("---------")
}

fun checkWin(gameState: Array<Char>, player: Char): Boolean {
    val winPatterns = listOf(
        listOf(0, 1, 2), 
        listOf(3, 4, 5),
        listOf(6, 7, 8),
        listOf(0, 3, 6), 
        listOf(1, 4, 7),
        listOf(2, 5, 8),
        listOf(0, 4, 8), 
        listOf(2, 4, 6)
    )

    for (pattern in winPatterns) {
        if (gameState[pattern[0]] == player &&
            gameState[pattern[1]] == player &&
            gameState[pattern[2]] == player) {
            return true
        }
    }
    return false
}

fun checkDraw(gameState: Array<Char>): Boolean {
    for (cell in gameState) {
        if (cell == ' ') {
            return false
        }
    }
    return true
}
