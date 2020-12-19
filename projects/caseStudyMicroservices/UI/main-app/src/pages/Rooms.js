import React from 'react'
import Banner from '../components/Banner'
import Hero from '../components/Hero'
import ShowRooms from '../components/ShowRooms'

function Rooms() {
    return (
        <div>
        <Hero hero="roomsHero">
        <Banner title=" Our Rooms">
            <a href="/" className="btn btn-secondary">HOME</a>
        </Banner>
        </Hero>
        <ShowRooms/>
        </div>
    )
}

export default Rooms
