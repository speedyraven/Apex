package com.Zawadi.apex.models



data class PaymentInfo(
    val amount: String,       // Amount as a string to handle decimal values
    val cardNumber: String,   // Card number as a string to preserve leading zeros
    val expiryDate: String,   // Expiry date in MM/YY format
    val cvv: String           // CVV as a string for security reasons
)

