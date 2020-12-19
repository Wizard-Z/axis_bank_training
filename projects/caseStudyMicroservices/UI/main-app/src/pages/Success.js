import React, { Component } from 'react'
import axios from 'axios'
import { Link } from 'react-router-dom'
class Success extends Component {
    /*
    * Do error checking..
    */
   constructor(props) {
       super(props)
   
       this.state = {
            status:'',
            cdata:{}

       }
   }
   
   componentDidMount(){
       const { name,days, paymentMethod, fullPay, rid} = this.props.location.state
       const obj={
           name,days,paymentMethod,fullPay,type:this.props.match.params.room,rid
       }
       console.log(obj)
       axios
        .post('http://localhost:8083/api/customers/bookings/customers',obj)
        .then(response =>{
            console.log(response)
            this.setState({
                status:response.status,
                cdata:response.data
            })
        })
        .catch (error =>{
            console.log(error)
        })
        console.log("Success!!")
   }
     render() {
        console.log(this.state)
        return (
            <>

        <div style={{"margin-top":"40px"}}className="jumbotron text-center">
            <h1 className="display-3">Thank you !!</h1>
            {/* <p className="lead"><strong>Please check your email</strong></p> */}
            <br>
            </br>
            <p>Here are your details!</p>
            
            <h5>CustomerId:{this.state.cdata.cid}</h5>
            <h5>Booked Room:{this.state.cdata.type}</h5>
            <h5>Total amount:{this.state.cdata.totalFair}</h5>
        <h5>Days:{this.state.cdata.days}</h5>
        

            <p className="lead">  
            <Link to="/"><button className="btn btn-primary btn-sm">Continue to homepage</button>
            </Link>            
            </p>


        </div>


            </>


        )
    }
}

export default Success
