/*
 * Copyright (C) 2018 The Tachiyomi Open Source Project
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package tachiyomi.data.sync.prefs

import android.app.Application
import android.content.Context
import tachiyomi.core.prefs.AndroidPreferenceStore
import tachiyomi.domain.sync.prefs.SyncPreferences
import javax.inject.Inject
import javax.inject.Provider

internal class SyncPreferencesProvider @Inject constructor(
  private val context: Application
) : Provider<SyncPreferences> {

  override fun get(): SyncPreferences {
    val sharedPreferences = context.getSharedPreferences("sync", Context.MODE_PRIVATE)
    val preferenceStore = AndroidPreferenceStore(sharedPreferences)

    return SyncPreferences(preferenceStore)
  }

}
