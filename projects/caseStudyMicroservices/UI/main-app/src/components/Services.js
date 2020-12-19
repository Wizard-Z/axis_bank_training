import React, { Component } from 'react'

import { FaGlassMartiniAlt, FaHiking, FaCarSide, FaBeer } from "react-icons/fa"
class Services extends Component {
    state = {
        services: [{
            icon: <FaGlassMartiniAlt />,
            title: "Drinks!!",
            text: "Lorem ipsum, dolor sit amet consectetur adipisicing elit. Quas, nulla."
        },
        {
            icon: <FaHiking />,
            title: "Endless fun",
            text: "Lorem ipsum, dolor sit amet consectetur adipisicing elit. Quas, nulla."
        },
        {
            icon: <FaCarSide />,
            title: "Tour and travels",
            text: "Lorem ipsum, dolor sit amet consectetur adipisicing elit. Quas, nulla."
        },
        {
            icon: <FaBeer />,
            title: "I need a Hug!",
            text: "Lorem ipsum, dolor sit amet consectetur adipisicing elit. Quas, nulla."
        }
        ]

    }
    render() {
        return (
            <div className="container-fluid" >
    
                <div className="row" >
                         {this.state.services.map((item,index)=>{
                    return( 
                        <div className="col-sm">
                    <article key={index} className="service">
                        <span>{item.icon}</span>
                        <h5>{item.title}</h5>
                        <p>{item.text}</p>
                    </article>
                    </div>)
                })}
                </div>
                </div>
            

        )
    }
}

export default Services
