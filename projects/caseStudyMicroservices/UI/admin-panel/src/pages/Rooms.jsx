import React, { Component } from "react";
import axios from "axios";
import RoomList from "../components/RoomsList";

export class Rooms extends Component {
  state = {
    rooms: [],
    sortedRooms: [],
    featuredRooms: [],
    loading: true,
    type: "all",
    price: 0,
    minPrice: 0,
    maxPrice: 0,
    minSize: 0,
    maxSize: 0,
    capacity: 1,
    baseUrl: "http://localhost:8083",
  };

  hangleToggle = (roomId) => {
    roomId = parseInt(roomId);
    console.log("Toggle clicked", roomId);

    axios
      .post(`${this.state.baseUrl}/api/rooms-toggle/${roomId}`, {
        id: roomId,
      })
      .then((response) => {
        let res = response.data;
        console.log(res);
        const rooms = [...this.state.rooms];
        const index = rooms.indexOf(res);
        rooms[index] = { ...res };
        console.log(`Index is ${index}`);
        this.setState({ rooms });
      });
  };
  componentDidMount() {
    axios
      .get(`${this.state.baseUrl}/api/bookings/rooms`)
      .then((response) => {
        let res = response.data;
        let featuredRooms = res.filter((room) => room.featured === true);
        let maxPrice = Math.max(...res.map((item) => item.price));
        let maxSize = Math.max(...res.map((item) => item.capacity));
        let minPrice = Math.min(...res.map((item) => item.price));
        this.setState({
          rooms: res,
          sortedRooms: res,
          loading: false,
          featuredRooms,
          price: maxPrice,
          maxPrice,
          minPrice,
          maxSize,
        });
        console.log(this.state);
      })
      .catch((error) => {
        console.log(error);
      });
  }

  render() {
    return (
      <div>
        <RoomList rooms={this.state.rooms} onToggle={this.hangleToggle} />
      </div>
    );
  }
}

export default Rooms;
