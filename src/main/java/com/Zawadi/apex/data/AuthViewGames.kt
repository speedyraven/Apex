package com.Zawadi.apex.data

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.Zawadi.apex.models.Games
import com.Zawadi.apex.navigation.Routes.ROUT_LOGIN
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
class AuthViewGames(var navController: NavHostController, var context: Context) {
    var authViewModel: AuthViewModel
    private val databaseReference = FirebaseDatabase.getInstance().getReference("Games")

    init {
        authViewModel = AuthViewModel(navController, context)
        if (!authViewModel.isLoggedIn()) {
            navController.navigate(ROUT_LOGIN)
        }
    }

    // Upload game
    fun uploadGame(name: String, duration: String, price: String, rating: String) {
        val gameId = System.currentTimeMillis().toString()
        val currentUser = FirebaseAuth.getInstance().currentUser
        val userId = currentUser?.uid ?: ""

        val game = Games(
            name = name,
            duration = duration,
            price = price,
            rating = rating,
            id = gameId,
            userId = userId
        )

        val databaseRef = databaseReference.child(gameId)
        databaseRef.setValue(game).addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(context, "Game uploaded successfully", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Error uploading game", Toast.LENGTH_SHORT).show()
            }
        }
    }



    // Delete game from database
    fun deleteGame(gameId: String) {
        val ref = databaseReference.child(gameId)
        ref.removeValue()
        Toast.makeText(context, "Game deleted successfully", Toast.LENGTH_SHORT).show()
    }

    // Fetch all games from the database (update the list)
    fun allGames(
        gamesList: SnapshotStateList<Games>
    ) {
        // Use addValueEventListener to listen for changes
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                gamesList.clear() // Clear the current list
                for (snap in snapshot.children) {
                    val game = snap.getValue(Games::class.java)
                    if (game != null) {
                        gamesList.add(game)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "Database error", Toast.LENGTH_SHORT).show()
            }
        })


    }

    // Fetch game by ID
    fun gamesId(gameId: String, callback: (Games?) -> Unit) {
        databaseReference.child(gameId).get().addOnSuccessListener { snapshot ->
            val game = snapshot.getValue(Games::class.java)
            callback(game)
        }.addOnFailureListener {
            callback(null)
        }
    }

    // Update game details
    fun updateGame(
        gameId: String,
        name: String,
        rating: String,
        price: String,
        duration: String
    ) {
        val updatedData = mapOf(
            "name" to name,
            "duration" to duration,
            "price" to price,
            "rating" to rating
        )

        databaseReference.child(gameId).updateChildren(updatedData).addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(context, "Game updated successfully", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Failed to update game", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
