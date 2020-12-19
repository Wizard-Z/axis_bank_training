import axios from "axios";
import React, { Component } from "react";

class AddRoomForm extends Component {
  constructor(props) {
    super(props);

    this.state = {
      id: "",
      name: "",
      type: "",
      price: "",
      left: "",
      available: true,
      capacity: "",
      featured: false,
    };
  }
  onChangeHandle = (e) => {
    this.setState({
      [e.target.name]: e.target.value,
    });
    console.log(`${e.target.name}:${e.target.value}`);
  };
  onSubmitForm = (e) => {
    e.preventDefault();
    console.log(this.state);
    axios
      .post("http://localhost:8083/api/add-rooms", this.state)
      .then((response) => {
        console.log(response);
      })
      .catch((error) => {
        console.log(error);
      });
    this.setState({
      id: "",
      name: "",
      type: "",
      price: "",
      left: "",
      available: "",
      capacity: "",
      featured: false,
    });
  };

  render() {
    const {
      id,
      name,
      type,
      price,
      left,
      available,
      capacity,
      featured,
    } = this.state;
    return (
      <div
        className="container d-flex align-items-center justify-content-center"
        style={{ "margin-top": "1em" }}
      >
        <form onSubmit={this.onSubmitForm}>
          <div className="form-group">
            <label for="id">Enter Room Id</label>
            <input
              type="number"
              name="id"
              value={id}
              onChange={this.onChangeHandle}
              className="form-control"
              placeholder="Enter Room-Id"
            ></input>

            <label htmlFor="name">Enter name of Room</label>
            <input
              type="text"
              name="name"
              value={name}
              onChange={this.onChangeHandle}
              className="form-control"
              placeholder="Room name"
            ></input>

            <label for="type">Enter type of Room</label>
            <input
              type="text"
              name="type"
              value={type}
              onChange={this.onChangeHandle}
              className="form-control"
              placeholder="Room type"
            ></input>

            <label for="price">Enter room price</label>
            <input
              type="number"
              name="price"
              value={price}
              onChange={this.onChangeHandle}
              className="form-control"
              placeholder="Room price"
              min="1"
            ></input>

            <label for="left">Enter Rooms quantity</label>
            <input
              type="number"
              name="left"
              value={left}
              onChange={this.onChangeHandle}
              className="form-control"
              placeholder="Room Quantity"
              min="1"
            ></input>

            <label for="capacity">Enter capaciy</label>
            <input
              type="number"
              name="capacity"
              value={capacity}
              onChange={this.onChangeHandle}
              className="form-control"
              placeholder="Beds"
              min="1"
            ></input>

            <label for="available">Is Available?</label>
            <select
              className="custom-select"
              name="available"
              value={available}
              onChange={this.onChangeHandle}
            >
              <option value={true}>True</option>
              <option value={false}>False</option>
            </select>

            <label for="featured">Is Featured?</label>
            <select
              className="custom-select"
              name="featured"
              value={featured}
              onChange={this.onChangeHandle}
            >
              <option value={true}>True</option>
              <option value={false}>False</option>
            </select>

            <button type="submit" className="btn btn-success">
              Add
            </button>
          </div>
        </form>
      </div>
    );
  }
}

export default AddRoomForm;
