package com.example.kitsuapperic.data.locale.preferences.userdata

import com.example.kitsuapperic.data.locale.preferences.PreferencesConstants
import com.example.kitsuapperic.data.locale.preferences.PreferencesHelper

class UserPreferencesData(
    private val preferences: PreferencesHelper
) {
    var isAuthorized: Boolean
        get() = preferences().getBoolean(
            PreferencesConstants.PREF_IS_AUTHORIZED, false
        )
        set(value) = preferences()
            .edit().putBoolean(
                PreferencesConstants.PREF_IS_AUTHORIZED, value
            ).apply()

    var accessToken: String
        get() = preferences().getString(
            PreferencesConstants.PREF_ACCESS_TOKEN, "null"
        )!!
        set(value) = preferences()
            .edit().putString(
                PreferencesConstants.PREF_ACCESS_TOKEN, value
            ).apply()

    var refreshToken: String
        get() = preferences().getString(
            PreferencesConstants.PREF_REFRESH_TOKEN, "null"
        )!!
        set(value) = preferences()
            .edit().putString(
                PreferencesConstants.PREF_REFRESH_TOKEN, value
            ).apply()

}