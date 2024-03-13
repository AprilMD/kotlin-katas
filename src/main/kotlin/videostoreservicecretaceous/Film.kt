package videostoreservicecretaceous


class Film(val title: String, val category: Category) {
    enum class Category {
        REGULAR, NEW_RELEASE, CHILDRENS
    }
}