import React from 'react'
import Banner from '../components/Banner'
import CarouselT from '../components/CarouselT'
import Featured from '../components/Featured'
import Hero from '../components/Hero'
import Services from '../components/Services'

function Home() {
    return (
        <div>
            {/*<CarouselT/>*/}
        <Hero>
            <Banner title="Affordable-Comfortable" subtitle="Deluxe">
            <a href="/rooms" className="btn btn-secondary">Rooms</a>

            </Banner>
        </Hero>
        
        <Services/>
        <Featured/>
        </div>
    )
}

export default Home
