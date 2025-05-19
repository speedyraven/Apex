package com.Zawadi.apex.navigation


object Routes {
    const val ROUT_HOME = "home"
    const val ROUT_ABOUT = "about"
    const val ROUT_SIGNUP = "signup"
    const val ROUT_LOGIN = "login"
    const val ROUT_PAYMENT = "payment"
    const val ROUT_SUCCESS = "success"
    const val ROUT_PROFILE = "profile"
    const val ROUT_SETTINGS = "settings"
    const val ROUT_MESSAGES = "messages"
    const val ROUT_GAMEPROFILE = "gameprofile"
    const val ROUT_EDITPROFILE = "editprofile"
    const val ROUT_ADDPAYMENT = "addpayment"
    const val ROUT_GAMES = "games"
    const val ROUT_ADDGAME = "addgame"
    const val ROUT_GAMES_VIEW = "gamesview"
    const val ROUT_BOOKING = "booking"
    const val ROUT_BOOKING_CONFIRMATION = "bookingConfirmation"
    const val ROUT_LOUNGE_CHECKIN = "loungeCheckIn/{userId}"


    const val ROUT_EDITGAME = "editgame/{gamesId}"
    fun editGame(gamesId: String) = "editgame/$gamesId"
}
