import React, {Component} from  'react'
import flightservice from '../flightsservices/flightservice';
import {  withRouter } from "react-router-dom";

import {Link } from 'react-router-dom';
class ListBookingsComponent extends Component {
    constructor(props){
        super(props)

        this.state={
            bookings: []

        }

        this.deleteBooking = this.deleteBooking.bind(this);
    }
    
    deleteBooking(bookingid){
        flightservice.deleteBooking(bookingid).then(res => {
            this.setState({bookings: this.state.bookings.filter(booking => booking.bookingid !== bookingid)});
        });
    }

    componentDidMount(){
        flightservice.getBookings().then((res)=>{
            this.setState({bookings: res.data})
        })

    }

    addBooking() {
        this.props.history.push('/admincardhome')
    }

    logout() {
        localStorage.removeItem("role");
      }

    render(){
        return (
            <div>

<header>
          <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
            <div className="container">
              <Link className="navbar-brand" to={"/home"}>
                <h2>Flight Space</h2>
              </Link>

              <div
                className="collapse navbar-collapse"
                id="navbarTogglerDemo02"
              >
                {localStorage.getItem("role") === "admin" ? (
                  <ul className="navbar-nav ml-auto">
                    <li className="nav-item">
                      <Link className="nav-link" to={"/admincardhome"}>
                        Home
                      </Link>
                    </li>

                    <li className="nav-item">
                  <Link className="nav-link" to={"/userlistinadmin"}>
                    DashBoard
                  </Link>
                </li>

                    <li className="nav-item">
                      <Link className="nav-link" to={"/add-Flight"}>
                        Add Flights
                      </Link>
                    </li>

                    <li className="nav-item">
                      <Link className="nav-link" to={"/flights"}>
                        Update Flights
                      </Link>
                    </li>

                    <li className="nav-item">
                      <Link
                        onClick={this.logout.bind(this)}
                        className="nav-link"
                        to={"/login"}
                      >
                        Logout
                      </Link>
                    </li>
                  </ul>
                ) : null}
              </div>
            </div>
          </nav>
        </header>
               
                <div className="d-flex p-2 mx-n3 ">
                    <div className="mx-auto text-center"><h2 className="mx-auto">Bookings List</h2></div>
                </div>
                <div className="row flight-table">
                    <table className="table table-striped table-bordered" style={{color:"black"}}>
                        <thead>
                            <tr>
                               <th>Flight Id</th>
                               <th>User Id</th>
                                <th>Booking Id</th> 
                                <th>Actions</th>
                            </tr>
                        </thead>

                        <tbody>
                            {
                                this.state.bookings.map(
                                    booking => 
                                    <tr key = {booking.bookingid}>
                                        <td>{booking.flightId}</td>
                                        <td>{booking.userid}</td>
                                        <td>{booking.bookingid}</td>
                                        
                                        <td>
                                            <button title="delete" onClick={() => this.deleteBooking(booking.bookingid)} 
                                               className="btn btn-danger">Delete</button>   
                                        </td>
                                    </tr>)
                            }
                        </tbody>

                    </table>
                </div>

            </div>
        )
    }
}

export default withRouter(ListBookingsComponent);