package videostoreservicecretaceous

interface Rental {
    val filmTitle: String
    val initialCost: Double
    val numberOfDayCoveredByInitialCost: Int
    val dailyCostAfterInitialCost: Double

    fun calculateCost(): Double
}

class RegularRental(film: Film, private val numberOfDays: Int) : Rental {
    override val filmTitle = film.title
    override val initialCost = 2.0
    override val numberOfDayCoveredByInitialCost = 2
    override val dailyCostAfterInitialCost = 1.5

    override fun calculateCost(): Double {
        return if (numberOfDays <= numberOfDayCoveredByInitialCost) {
            initialCost
        } else {
            initialCost + ((numberOfDays - numberOfDayCoveredByInitialCost) * dailyCostAfterInitialCost)
        }
    }
}

class NewReleaseRental(private val film: Film, private val numberOfDays: Int) : Rental {
    override val filmTitle = film.title
    override val initialCost = 3.0
    override val numberOfDayCoveredByInitialCost = 1 // deceptive????
    override val dailyCostAfterInitialCost = 3.0

    override fun calculateCost(): Double {
        return numberOfDays * dailyCostAfterInitialCost
    }
}

class ChildrensRental(private val film: Film, private val numberOfDays: Int) : Rental {
    override val filmTitle = film.title
    override val initialCost = 1.5
    override val numberOfDayCoveredByInitialCost = 3
    override val dailyCostAfterInitialCost = 1.5

    override fun calculateCost(): Double {
        return if (numberOfDays <= numberOfDayCoveredByInitialCost) {
            initialCost
        } else {
            initialCost + ((numberOfDays - numberOfDayCoveredByInitialCost) * dailyCostAfterInitialCost)
        }
    }
}
