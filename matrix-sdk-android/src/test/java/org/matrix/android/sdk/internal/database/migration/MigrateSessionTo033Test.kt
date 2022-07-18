/*
 * Copyright (c) 2022 The Matrix.org Foundation C.I.C.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.matrix.android.sdk.internal.database.migration

import org.junit.Test
import org.matrix.android.sdk.internal.database.model.RoomSummaryEntityFields
import org.matrix.android.sdk.test.fakes.FakeDynamicRealm

internal class MigrateSessionTo033Test {

    private val fakeDynamicRealm = FakeDynamicRealm()
    private val migrator = MigrateSessionTo033(fakeDynamicRealm.instance)

    @Test
    fun `when doMigrate, then directParentNames added`() {
        migrator.doMigrate(fakeDynamicRealm.instance)

        fakeDynamicRealm.fakeRealmSchema.withObjectSchema("RoomSummaryEntity")
                .verifyListFieldAdded(RoomSummaryEntityFields.DIRECT_PARENT_NAMES.`$`, String::class.java)
                .verifyStringTransformation(RoomSummaryEntityFields.DIRECT_PARENT_NAMES.`$`, "")
    }
}
