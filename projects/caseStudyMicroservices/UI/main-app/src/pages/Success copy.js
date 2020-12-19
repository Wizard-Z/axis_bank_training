import React, { Component } from 'react'
import axios from 'axios'
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
   
//    componentDidMount(){
//        const { name,days, paymentMethod, fullPay, rid} = this.props.location.state
//        const obj={
//            name,days,paymentMethod,fullPay,type:this.props.match.params.room,rid
//        }
//        console.log(obj)
//        axios
//         .post('http://localhost:8083/api/customers/bookings/customers',obj)
//         .then(response =>{
//             console.log(response)
//             this.setState({
//                 status:response.status,
//                 cdata:response.data
//             })
//         })
//         .catch (error =>{
//             console.log(error)
//         })
//         console.log("Success!!")
//    }
     render() {
        console.log(this.state)
        return (
            <>




            </>


        )
    }
}

export default Success
