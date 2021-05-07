package com.mobile.pytournaments.domain.enum

enum class TournamentStatus(status: Int) {
    WILL_START(0),
    ONGOING(1),
    CONCLUDED(2),
    CANCELED(3)
}