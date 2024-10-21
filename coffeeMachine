package machine

class CoffeeMachine {
    private var water = 400
    private var milk = 540
    private var coffeeBeans = 120
    private var disposableCups = 9
    private var money = 550

    private var state: State = State.ChoosingAction

    private enum class State {
        ChoosingAction, ChoosingCoffee, FillingWater, FillingMilk, FillingCoffeeBeans, FillingCups
    }

    fun processInput(input: String) {
        when (state) {
            State.ChoosingAction -> handleAction(input)
            State.ChoosingCoffee -> handleCoffeeSelection(input)
            State.FillingWater -> fillWater(input)
            State.FillingMilk -> fillMilk(input)
            State.FillingCoffeeBeans -> fillCoffeeBeans(input)
            State.FillingCups -> fillCups(input)
        }
    }

    private fun handleAction(action: String) {
        when (action) {
            "buy" -> {
                println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
                state = State.ChoosingCoffee
            }
            "fill" -> {
                println("Write how many ml of water you want to add:")
                state = State.FillingWater
            }
            "take" -> {
                println("I gave you \$$money")
                money = 0
                state = State.ChoosingAction
            }
            "remaining" -> {
                printState()
                state = State.ChoosingAction
            }
            "exit" -> return
            else -> {
                println("Invalid action")
                state = State.ChoosingAction
            }
        }
    }

    private fun handleCoffeeSelection(coffeeType: String) {
        when (coffeeType) {
            "1" -> makeCoffee(250, 0, 16, 4)
            "2" -> makeCoffee(350, 75, 20, 7)
            "3" -> makeCoffee(200, 100, 12, 6)
            "back" -> state = State.ChoosingAction
            else -> {
                println("Invalid selection")
                state = State.ChoosingAction
            }
        }
    }

    private fun makeCoffee(waterNeeded: Int, milkNeeded: Int, coffeeBeansNeeded: Int, cost: Int) {
        if (water >= waterNeeded && milk >= milkNeeded && coffeeBeans >= coffeeBeansNeeded && disposableCups >= 1) {
            water -= waterNeeded
            milk -= milkNeeded
            coffeeBeans -= coffeeBeansNeeded
            disposableCups -= 1
            money += cost
            println("I have enough resources, making you a coffee!")
        } else {
            println("Sorry, not enough resources!")
        }
        state = State.ChoosingAction
    }

    private fun fillWater(amount: String) {
        water += amount.toInt()
        println("Write how many ml of milk you want to add:")
        state = State.FillingMilk
    }

    private fun fillMilk(amount: String) {
        milk += amount.toInt()
        println("Write how many grams of coffee beans you want to add:")
        state = State.FillingCoffeeBeans
    }

    private fun fillCoffeeBeans(amount: String) {
        coffeeBeans += amount.toInt()
        println("Write how many disposable cups you want to add:")
        state = State.FillingCups
    }

    private fun fillCups(amount: String) {
        disposableCups += amount.toInt()
        state = State.ChoosingAction
    }

    private fun printState() {
        println("The coffee machine has:")
        println("$water ml of water")
        println("$milk ml of milk")
        println("$coffeeBeans g of coffee beans")
        println("$disposableCups disposable cups")
        println("\$$money of money")
    }
}

fun main() {
    val coffeeMachine = CoffeeMachine()
    while (true) {
        println("Write action (buy, fill, take, remaining, exit):")
        val input = readLine() ?: return
        coffeeMachine.processInput(input)
        if (input == "exit") break
    }
}
