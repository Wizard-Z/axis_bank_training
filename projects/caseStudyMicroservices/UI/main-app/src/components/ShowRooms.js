import React from 'react'
import Roomlist from './tempR'
import {withRoomConsumer} from '../Context'
import FilterRooms from './FilterRooms'


function ShowRooms({context}) {
    const {loading,rooms,sortedRooms} = context
    console.log("-ShowROoms-",rooms)
    return (
        <div>
            <FilterRooms rooms={rooms}/>
            <Roomlist rooms={sortedRooms}/>
        </div>
    )
}
export default withRoomConsumer(ShowRooms)