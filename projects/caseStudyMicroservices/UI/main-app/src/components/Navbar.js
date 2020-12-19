import React, { Component } from 'react'
import {FaWarehouse} from 'react-icons/fa'
import { Link } from 'react-router-dom'
class Navbar extends Component {
    render() {
        return (
            <header>            
                <nav className="navbar fixed-top navbar-expand-md navbar-light "  style={{"background-color":" #e3f2fd"}}>
            <a className="navbar-brand" href="/"><FaWarehouse/></a>
            <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#idn">
                <span className="navbar-toggler-icon"></span>
            </button>
            <div className="collapse navbar-collapse" id="idn">
                <ul className="navbar-nav">
                <li className="nav-item active"><a className="nav-link" href="/">Home</a></li>
    
                    <li className="nav-item dropdown">
                        <a className="nav-link dropdown-toggle" href="#" id="tdetails" role="button"
                            data-toggle="dropdown">Menu</a>
                        <div className="dropdown-menu" aria-labelledby="tdetails">
                            <a className="dropdown-item" href="#" id="pviews">Recently Viewed</a>
                            <a className="dropdown-item" href="#">Popular</a>
                            <Link to = "/test/kafka">-test-</Link>
                        </div>
                    </li>
                    <li className="nav-item"><a className="nav-link" href="/rooms">Rooms</a></li>
                </ul>
            </div>
        </nav>
        </header>

        )
    }
}

export default Navbar
