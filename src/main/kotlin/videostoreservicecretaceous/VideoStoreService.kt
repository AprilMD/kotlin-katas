package videostoreservicecretaceous

class VideoStoreService {
    fun printStatement(user: User, rentals: List<Rental>): String {
        rentals.joinToString("\n") { rental ->
            "${rental.filmTitle} £${rental.calculateCost()}"
        }

        val statement = "Rental Record for ${user.name}\n"
        val rentalStatementLines = rentals.map { rental ->
            "${rental.filmTitle} £${rental.calculateCost()}"
        }.joinToString("\n")

        val totalCost = "\nYou owe £${rentals.sumOf { rental -> rental.calculateCost() }}"

        return statement+rentalStatementLines+totalCost
    }

    fun createRental(film: Film, numberOfDays: Int): Rental {
        return RentalFactory.createRental(film, numberOfDays)
    }
}

fun main() {
    val videoStore = VideoStoreService()

    val april = User("april")

    val film1 = Film("film1", Film.Category.REGULAR)
    val film2 = Film("film2", Film.Category.NEW_RELEASE)
    val film3 = Film("film3", Film.Category.CHILDRENS)
    val film4 = Film("film4", Film.Category.REGULAR)

    val rental1 = videoStore.createRental(film1, 4)
    val rental2 = videoStore.createRental(film2, 3)
    val rental3 = videoStore.createRental(film3, 2)
    val rental4 = videoStore.createRental(film4, 1)

    println(videoStore.printStatement(april, listOf(rental1, rental2, rental3, rental4)))
}

// REQUIREMENTS:
// Regular: £2 for 2 days, £1.50 for subsequent days, 1 FRP
// New Release: £3 per day, 1 FRP for 1 day, 2 for 2 or more
// Children's: £1.50 for 3 days, £1.50 each day after, 1 FRP

// Rental Record for videostoreservicejurassic.Customer Name
// Crazynotes  £2.0
// Teeth  £2.0
// The Web  £3.5
// You owe £7.5
// You earned 3 frequent renter points

// PLAN:
// service() - { .printStatement(user, rentals) // save record
// rental(film, length of time) .calculateCost()
// film(val title, var category - regular/new release/childrens), .updateCategory }
// customer(name)