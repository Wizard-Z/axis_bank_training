import React, { Component } from 'react'
import axios from 'axios'
const RoomContext = React.createContext();

class RoomProvider extends Component {
    state = {
        rooms:[],
        sortedRooms:[],
        featuredRooms:[],
        loading:true,
        type:'all',
        price:0,
        minPrice:0,
        maxPrice:0,
        minSize:0,
        maxSize:0,
        capacity:1
    }
    componentDidMount(){
       
        axios.get('http://localhost:8083/api/bookings/available-rooms/')
            .then(response => {
                let res = response.data
                let featuredRooms=res.filter(room=>room.featured===true)
                let maxPrice=Math.max(...res.map(item=>item.price))
                let maxSize = Math.max(...res.map(item=>item.capacity))
                let minPrice = Math.min(...res.map(item=>item.price))
                this.setState({ rooms: res,sortedRooms:res,loading:false,featuredRooms,price:maxPrice,maxPrice,minPrice,maxSize })
                console.log(this.state)
                
            })
            .catch(error => {
                console.log(error)
                this.setState({ err: "cannot Fetch data..." })
            })
        //this.getData
        //let featuredRooms=rooms.filter(room=>room.featured===true)
        //console.log(featuredRooms)
        console.log(this.state)
    }
    handleChange = (e) =>{
        const target = e.target
        const name = e.target.name
        const value = e.type==='checkbox'?target.checked:target.value
        console.log(`${target}::::${name}:::${value}`)
        this.setState({
            [name]:value},this.filterRooms)
    }
    //fallback method
    filterRooms =()=>{
        let {
            rooms,type,capacity,price,minSize,maxSize
        }=this.state
        let tempRooms = [...rooms]
        //capacity = parseInt(capacity)
        price = parseInt(price)

        console.log("Before::",tempRooms,type,capacity,price)

        //filter by type
        if(type!=='all'){
            tempRooms=tempRooms.filter(room=>room.type===type)
        }

        //filter by capacity
        if(capacity!==1)
        tempRooms = tempRooms.filter(room=>room.capacity>=capacity)

        //filter by price
        tempRooms = tempRooms.filter(room=>room.price <=price)

        console.log(tempRooms)
        this.setState({
            sortedRooms:tempRooms
        })



        

    }

    render() {
        return (
            <RoomContext.Provider value={{...this.state,handleChange:this.handleChange} }>
                {this.props.children}
                </RoomContext.Provider>
        )
    }
}
const RoomConsumer = RoomContext.Consumer;
// higher order component for props for room cunsumers:

export function withRoomConsumer(Component){
    return function ConsumerWrapper(props){
        return <RoomConsumer>
            {value => <Component {...props} context={value}/>}
        </RoomConsumer>
    }
}

export {RoomProvider, RoomConsumer, RoomContext }
