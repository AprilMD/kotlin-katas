import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.string.shouldContain

class VideoStoreServiceTest: DescribeSpec ({
    describe("video store service") {
        it("returns a statement for user") {
            val john = Customer("John")
            val videoStore = VideoStoreService() // class or instance methods?

            val result = videoStore.printStatement(john)

            result.shouldContain("Rental Record for John")
        }

        it("returns a statement for the right user in the correct format") {
            val jane = Customer("jane")
            val videoStore = VideoStoreService() // class or instance methods?

            val result = videoStore.printStatement(jane)

            result.shouldContain("Rental Record for Jane")
        }
    }
})

// REQUIREMENTS:
// Regular: £2 for 2 days, £1.50 for subsequent days, 1 FRP
// New Release: £3 per day, 1 FRP for 1 day, 2 for 2 or more
// Childern's: £1.50 for 3 days, £1.50 each day after, 1 FRP

// Rental Record for Customer Name
// Crazynotes  £2.0
// Teeth  £2.0
// The Web  £3.5
// You owe £7.5
// You earned 3 frequent renter points

// PLAN:
// service() - { .printStatement(user, rentals) // save record
// rental(film, length of time)
// film(val title, var category - regular/new release/childrens), .updateCategory }
// customer(name)
