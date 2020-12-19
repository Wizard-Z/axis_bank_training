import React from 'react'
import { useContext } from 'react'
import { RoomContext } from '../Context'

const getUnique = (items, value) => {
    return [...new Set(items.map(item => item[value]))]
}
function FilterRooms({ rooms }) {
    const context = useContext(RoomContext)
    const { handleChange, type, capacity, price, minPrice, maxPrice } = context
    console.log('From filter', context)
    // get unique types
    let types = getUnique(rooms, 'type')
    // add all
    types = ['all', ...types]
    console.log(types)
    types = types.map((item, index) => {
        return <option value={item} key={index}>{item}</option>
    })

    // capacity

    let beds = getUnique(rooms, 'capacity')
    beds = beds.map((item, index) => {
        return <option key={index} value={item}>{item}</option>
    })

    return (
        <div className="container-fluid bg-gradient-primary" style={{"padding":"1em"}}>
            {/* <h4 style={{"fontWeight":"bold","textAlign":"center"}}>Search room</h4> */}
            <section>
                <form>
                    <div className="row" >
                    <div className="col-sm">
                        {/**type filter */}
                        <label htmlFor="type">
                            <strong>Type of room </strong></label>
                            <br/>
                        <select name="type" value={type} id="type" onChange={handleChange}>
                            {types}
                        </select>
                    </div>
                    {/**--end select-- */}
                    {/** capacity filter */}
                    <div className="col-sm">
                        <label htmlFor="capacity">
                            <strong>Atleast how many guests?</strong>  </label>
                            <br/>
                        <select name ="capacity" value={capacity} id="capacity" onChange={handleChange}>
                            {beds}
                        </select>
                    </div>

                    {/**--end capacity-- */}
                    {/**Price filter */}
                    <div className="col-sm">
                        <label htmlFor="price">
                            <strong>Room-Price (in Rs.) </strong>
                            <br/>
                            <strong>{price}</strong>
                            </label>
                        <input type="range" name="price" min={minPrice} max={maxPrice} id="price" value={price} onChange={handleChange} ></input>
                    </div>
                    </div>
                </form>
            </section>
        </div>
    )
}

export default FilterRooms
