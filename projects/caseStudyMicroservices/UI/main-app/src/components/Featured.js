import React, { Component } from 'react'
import {RoomContext} from '../Context'
//import Loading from "./Loading"
import Room from './tempR'
//import Title from './Title'
class Featured extends Component {
    static contextType=RoomContext
    render() {
        let {loading,featuredRooms} = this.context
        /*rooms=rooms.map(room=>{
            return <Room key={room.id} room={room}/>
        })*/
        console.log(featuredRooms)
        return (
            <div>
                <Room rooms = {featuredRooms}/>
            </div>
        )
    }
}

export default Featured
