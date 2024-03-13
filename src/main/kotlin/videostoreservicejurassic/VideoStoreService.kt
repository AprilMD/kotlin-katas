package videostoreservicejurassic

class VideoStoreService {
    fun printStatement(customer: Customer): String {
        return "Rental Record for ${customer.getFirstName()}"
    }

}
/**/