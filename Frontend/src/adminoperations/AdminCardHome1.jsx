import React, { Component } from "react";
import AdminCard from "./AdminCardHome";
import card1 from "../images/card1.jpg";
import card2 from "../images/card2.jpg";
import card3 from "../images/card3.jpg";
import { Link } from "react-router-dom";
import { withRouter } from "react-router-dom";
class AdminCardHome1 extends Component {
  logout() {
    localStorage.removeItem("role");
  }
  render() {
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
                  <Link className="nav-link" to={"/admin"}>
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
    <br/>
    <br/>
        <div className="row">
          <div className="col-md-4">
            <AdminCard imgsrc={card1} title="Home" para="Home page for Admin to see all the flight details along with source and destination"
           href="/admin" a="Go to Flights Home "/>
          </div>
          <div className="col-md-4">
            <AdminCard imgsrc={card2} title="Add Flight" para="Adding a new Flight to avail the customers know about flight details,date,time"
            href="/add-flight" a="Go to Add Flights"/>
          </div>
          <div className="col-md-4">
            <AdminCard imgsrc={card3} title="Update Flights" para="Updating flight details,incase flight is rescheduled,update details or cancelled"
            href="/flights" a="Go to Update Flights"/>
          </div>
        </div>
        
      </div>
      
    );
  }
}

export default withRouter(AdminCardHome1);
