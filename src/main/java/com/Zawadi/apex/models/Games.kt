package com.Zawadi.apex.models

import com.google.firebase.firestore.DocumentId


class Games {
    data class Game(
        @DocumentId val id: String = "",
        val name: String = "",
        val price: String = "",
        val duration: String = "",
        val rating: Double = 0.0
    )
}