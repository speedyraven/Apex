package com.Zawadi.apex.models



 class Games {
    var name: String = ""
    var duration: String = ""
    var price: String = ""
    var rating: String = ""
    var id: String = ""              // Make sure this is here
    var userId: String = ""

    // Primary constructor with all properties
    constructor(
        name: String = "",
    duration: String = "",
    price: String = "",
    rating: String = "",
    id: String = "",              // ID should be passed as well
    userId: String = ""           // userId should also be passed
    ) {
        this.name = name
        this.duration = duration
        this.price = price
        this.rating = rating
        this.id = id                   // Initialize ID
        this.userId = userId           // Initialize userId

    }

    // Secondary constructor with no parameters (for Firebase deserialization)
    constructor()
}
