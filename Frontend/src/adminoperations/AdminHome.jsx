import React, { Component } from "react";
import flightservice from "../flightsservices/flightservice";
import { withRouter } from "react-router-dom";
import { Link } from "react-router-dom";
class Home extends Component {
  constructor(props) {
    super(props);
    this.state = {
      filter: "",
      flights: [],
    };
  }

  componentDidMount() {
    flightservice.getFlights().then((res) => {
      this.setState({ flights: res.data });
    });
  }

  addFlights() {
    this.props.history.push("/add-flight");
  }

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
        <br />
        <h2 className="text-center">Flights Details</h2>
        <br />
        <div className="row">
          <table className="table table-striped table-bordered">
            <thead>
              <tr>
                <th>FlightId</th>
                <th>Source</th>
                <th>Departure Date</th>
                <th>Departure Time</th>
                <th>Destination</th>
                <th>Arrival Date</th>
                <th>Arrival Time</th>
                <th>Price</th>
              </tr>
            </thead>
            <tbody>
              {this.state.flights.map((flight) => (
                <tr key={flight.flightId}>
                  <td>{flight.flightId}</td>
                  <td>{flight.flightTakeOffStation}</td>
                  <td>{flight.departureDate}</td>
                  <td>{flight.departureTime}</td>
                  <td>{flight.flightLandingStation}</td>
                  <td>{flight.arrivalDate}</td>
                  <td>{flight.arrivalTime}</td>
                  <td>{flight.price}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
        <div>
        <footer className="footer">
          <span className="text-muted">All Rights Reserved 2021 @Vignesh</span>
        </footer>
        </div>
      </div>
    );
  }
}

export default withRouter(Home);
