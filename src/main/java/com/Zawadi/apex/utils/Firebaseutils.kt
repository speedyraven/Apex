package com.Zawadi.apex.utils



import android.util.Log
import com.Zawadi.apex.models.PaymentInfo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

object FirebaseUtils {

    private val auth: FirebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }

    private val database by lazy {
        FirebaseDatabase.getInstance().reference
    }

    // Function to get the current user ID
    fun getUserId(): String? {
        return auth.currentUser?.uid
    }

    // Function to store payment info in the database
    fun savePaymentInfo(paymentInfo: PaymentInfo, callback: (Boolean, String) -> Unit) {
        val userId = getUserId()
        if (userId == null) {
            callback(false, "User not authenticated")
            return
        }

        val paymentRef = database.child("payments").child(userId)

        paymentRef.setValue(paymentInfo)
            .addOnSuccessListener {
                Log.d("FirebaseUtils", "Payment saved successfully")
                callback(true, "Payment saved successfully")
            }
            .addOnFailureListener { exception ->
                Log.e("FirebaseUtils", "Error saving payment: ${exception.message}")
                callback(false, "Error saving payment: ${exception.message}")
            }
    }

    // Function to log out the current user
    fun signOut() {
        auth.signOut()
    }

    // Function to check if the user is logged in
    fun isUserLoggedIn(): Boolean {
        return auth.currentUser != null
    }
}
