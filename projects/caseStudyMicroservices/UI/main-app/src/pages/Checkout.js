import React, { Component } from 'react'
import { Link } from 'react-router-dom'

class Checkout extends Component {
    constructor(props) {
        super(props)
    
        this.state = {
            name:'',
            days:'',
            paymentMethod:'',
            rid:this.props.location.state.rid,
            fullPay:false            
        }
    }

    onChangeHandle=(e)=>{
        this.setState({
            [e.target.name]:e.target.value
        })
        console.log(`${e.target.name}:${e.target.value}`)
    }
    onSubmitForm(e,baseFare){
        e.preventDefault()
        console.log(this.state)

        alert(`You are about to navigate to another page.`)
        this.props.history.push({
            pathname:`${window.location.pathname}/success`,
            state:this.state
        });

    }
    


    
    render() {
        const{ type, price,rname} = this.props.location.state
        //const { room } = this.props.match.params
        console.log(type,price,rname)
        const{ name, days,paymentMethod,fullPay} =this.state
        return  (
            
            <div className="container" style={{"margin-top":"5em"}}>
                
            <h3>Booking Page.</h3>
            <h5>**{type}**</h5>
            <h5>**{rname}**</h5>
            <form onSubmit={e=>this.onSubmitForm(e,price)}>
            <div className="form-group">
                <label for="name">Enter Name</label>
                <input type="text" name="name" value={name} onChange={this.onChangeHandle} className="form-control" placeholder="Enter your name"></input>
            
                <label for="days">Enter number of days to stay</label>
                <input type="number" name="days" value={days} onChange={this.onChangeHandle} className="form-control" placeholder="Days" min="1"></input>
                <label for="paymentMethod">Payment-gateway?</label>
                <select className="custom-select" name="paymentMethod" value={paymentMethod} onChange={this.onChangeHandle}>
                    <option value={"UPI"}>UPI</option>
                    <option value={"Net-Banking"}>Net-Banking</option>
                </select>

                <label for="fullPay">Do you wish to pay the full Amount?</label>
                <select className="custom-select" name="fullPay" value={fullPay} onChange={this.onChangeHandle}>
                    <option value={true}>Yes</option>
                    <option value={false}>No</option>
                </select>
                
                
                <section>
                <p>Your booking choice:{type}</p>
                <p>Your base Fare:{price}</p>
                </section>

                <button type = "submit" className="btn btn-success" >Book</button></div>
           
            </form>



            </div>
            
        )

    }
}

export default Checkout
