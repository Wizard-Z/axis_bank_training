import React, { Component } from 'react'
import axios from 'axios'
import bcg from '../images/cardBcg.jpg'
import { Link } from 'react-router-dom'

class SingleRoom extends Component {
    constructor(props) {
        super(props)
    
        this.state = {
            posts: [],
            err: ''
        }
    }
    componentDidMount() {
        const { type } = this.props.match.params
        axios.get(`http://localhost:8087/api/bookings/rooms-type/${type}`)
            .then(response => {
                console.log(response)
                this.setState({ posts: response.data })
            })
            .catch(error => {
                console.log(error)
                this.setState({ err: "cannot Fetch data..." })
            })
    }

    
    render() {
        const { posts, err } = this.state
        console.log(`${posts}:::${typeof posts.id}:::${err}`)
        return (
            <div className="container-fluid">
                <h6>Room Lists</h6>
                <div className="row">
                    {
                        posts.id? 
            <div className="col-sm" key={posts.id}>
                <div className="card" style={{ width: "18rem", }}>
                <img className="card-img-top" src={bcg}></img><div className="card-body">

                <h4 className="card-title">{posts.type}</h4>
                <p className="card-text">Lorem ipsum, dolor sit amet consectetur adipisicing elit. Quas, nulla.</p>
                </div>
                <ul className="list-group list-group-flush">
                <li className="list-group-item"><strong>Price: </strong>{posts.price}</li>
                <li className="list-group-item"><strong>Beds:</strong> {posts.capacity}</li>
                <li className="list-group-item">
                <Link to="/test/checkout">
                <button type="button" className="btn btn-success">Book</button>
                </Link></li></ul></div></div>:(
                    <h4>{err}</h4>
                )
                
                    }
                </div>
            </div>
        )
    }
}

export default SingleRoom
