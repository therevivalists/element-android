/*
 * Copyright 2019 New Vector Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package im.vector.riotx.features.home.room.list

import im.vector.matrix.android.api.session.room.model.RoomSummary
import im.vector.matrix.android.api.session.room.notification.RoomNotificationState
import im.vector.riotx.core.platform.VectorViewModelAction
import im.vector.riotx.features.share.SharedData

sealed class RoomListAction : VectorViewModelAction {
    data class SelectRoom(val roomSummary: RoomSummary) : RoomListAction()
    data class ToggleCategory(val category: RoomCategory) : RoomListAction()
    data class AcceptInvitation(val roomSummary: RoomSummary) : RoomListAction()
    data class RejectInvitation(val roomSummary: RoomSummary) : RoomListAction()
    data class FilterWith(val filter: String) : RoomListAction()
    data class ChangeRoomNotificationState(val roomId: String, val notificationState: RoomNotificationState) : RoomListAction()
    data class LeaveRoom(val roomId: String) : RoomListAction()
    object MarkAllRoomsRead : RoomListAction()
}
