package videostoreservicecretaceous

class RentalFactory {
    companion object {
        fun createRental(film: Film, numberOfDays: Int): Rental {
            return when (film.category) {
                Film.Category.REGULAR -> RegularRental(film, numberOfDays)
                Film.Category.NEW_RELEASE -> NewReleaseRental(film, numberOfDays)
                Film.Category.CHILDRENS -> ChildrensRental(film, numberOfDays)
            }
        }
    }
}