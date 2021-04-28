import React, { Component } from "react";
import flightservice from "../flightsservices/flightservice";
import { Link } from "react-router-dom";
import { withRouter } from "react-router-dom";

const validateForm = (errors) => {
  let valid = true;
  Object.values(errors).forEach((val) => val.length > 0 && (valid = false));
  return valid;
};
class CreateFlightsComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      flightId: this.props.match.params.flightId,

      
      flightTakeOffStation: "",
      departureDate: "",
      departureTime: "",
      flightLandingStation: "",
      arrivalDate: "",
      arrivalTime: "",
      price: "",
      errors: {
        flightId: "",
        flightTakeOffStation: "",
        flightLandingStation: "",
        price: "",
      },
    };
    this.changeflightIdHandler = this.changeflightIdHandler.bind(this);
    this.changeflightTakeOffStationHandler = this.changeflightTakeOffStationHandler.bind(
      this
    );
    this.changedepartureDateHandler = this.changedepartureDateHandler.bind(
      this
    );
    this.changedepartureTimeHandler = this.changedepartureTimeHandler.bind(
      this
    );
    this.changeflightLandingStationHandler = this.changeflightLandingStationHandler.bind(
      this
    );
    this.changearrivalDateHandler = this.changearrivalDateHandler.bind(this);
    this.changearrivalTimeHandler = this.changearrivalTimeHandler.bind(this);
    this.changepriceHandler = this.changepriceHandler.bind(this);
    this.saveFlight = this.saveFlight.bind(this);
  }

  saveFlight = (e) => {
    e.preventDefault();
    let flights = {
      flightId: this.state.flightId,
      flightTakeOffStation: this.state.flightTakeOffStation,
      departureDate: this.state.departureDate,
      departureTime: this.state.departureTime,
      flightLandingStation: this.state.flightLandingStation,
      arrivalDate: this.state.arrivalDate,
      arrivalTime: this.state.arrivalTime,
      price: this.state.price,
    };
    if (validateForm(this.state.errors)) {
      console.info("Valid Form");
      flightservice.InsertingFlight(flights).then((res) => {
        this.props.history.push("/flights");
      });
    } else {
      console.error("Invalid Form");
    }
  };

  changeflightIdHandler = (event) => {
    this.setState({ flightId: event.target.value });
  };
  changeflightTakeOffStationHandler = (event) => {
    this.setState({ flightTakeOffStation: event.target.value });
  };
  changedepartureDateHandler = (event) => {
    this.setState({ departureDate: event.target.value });
  };

  changedepartureTimeHandler = (event) => {
    this.setState({ departureTime: event.target.value });
  };
  changeflightLandingStationHandler = (event) => {
    this.setState({ flightLandingStation: event.target.value });
  };
  changearrivalDateHandler = (event) => {
    this.setState({ arrivalDate: event.target.value });
  };
  changearrivalTimeHandler = (event) => {
    this.setState({ arrivalTime: event.target.value });
  };
  changepriceHandler = (event) => {
    this.setState({ price: event.target.value });
  };

  cancel() {
    this.props.history.push("admincardhome");
  }

  logout() {
    localStorage.removeItem("role");
  }

  handleChange = (event) => {
    event.preventDefault();
    const { name, value } = event.target;
    let errors = this.state.errors;
    console.log("hello");
    switch (name) {
      case "flightId":
        errors.flightId = value.length < 6 ? "flightId should be 6 digits" : "";
        break;
      case "flightTakeOffStation":
        errors.flightTakeOffStation =
          value.length < 5 ? "It should be of 5 digits" : "";
        break;
      case "flightLandingStation":
        errors.flightLandingStation =
          value.length < 5 ? "It should be of 5 digits" : "";
        break;
      case "price":
        var reg = [0 - 9];
        errors.price = reg ? "" : "price should be in numbers";
        break;
      default:
        break;
    }
    this.setState({ errors, [name]: value });
    console.log(errors);
  };

  render() {
    const { errors } = this.state;
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

        <div>
          <div className="container">
            <div className="row">
              <div className="card-body">
                <h3 className="text-center">Add Flight</h3>
                <form noValidate>
                  <div className="row mb-2">
                    <div className="col-sm-6">
                      <div className="form-group">
                        <label>flightId:</label>
                        <input
                          type="text"
                          placeholder="flightId"
                          name="flightId"
                          className="form-control"
                          value={this.state.flightId}
                          onChange={this.handleChange}
                          noValidate
                        />
                        {errors.flightId.length > 0 && (
                          <span className="error" style={{ color: "red" }}>
                            {errors.flightId}
                          </span>
                        )}
                      </div>
                    </div>

                    <div className="col-sm-6">
                      <div className="form-group">
                        <label htmlFor="flightTakeOffStation">
                          FlightTakeOffStation:
                        </label>
                        <input
                          type="text"
                          placeholder="flightTakeOffStation"
                          name="flightTakeOffStation"
                          className="form-control"
                          value={this.state.flightTakeOffStation}
                          onChange={this.handleChange}
                          noValidate
                        />
                        {errors.flightTakeOffStation.length > 0 && (
                          <span className="error" style={{ color: "red" }}>
                            {errors.flightTakeOffStation}
                          </span>
                        )}
                      </div>
                    </div>
                  </div>

                  <div className="row mb-2">
                    <div className="col-sm-6">
                      <div className="form-group">
                        <label>DepartureDate:</label>
                        <input
                          type="date"
                          name="departureDate"
                          className="form-control"
                          value={this.state.departureDate}
                          onChange={this.changedepartureDateHandler}
                          noValidate
                        />
                      </div>
                    </div>

                    <div className="col-sm-6">
                      <div className="form-group">
                        <label>DepartureTime:</label>
                        <input
                          type="time"
                          name="departureTime"
                          className="form-control"
                          value={this.state.departureTime}
                          onChange={this.changedepartureTimeHandler}
                          noValidate
                        />
                      </div>
                    </div>
                  </div>

                  <div className="form-group">
                    <label>FlightLandingStation:</label>
                    <input
                      type="text"
                      placeholder="flightLandingStation"
                      name="flightLandingStation"
                      className="form-control"
                      value={this.state.flightLandingStation}
                      onChange={this.handleChange}
                      noValidate
                    />
                    {errors.flightLandingStation.length > 0 && (
                      <span className="error" style={{ color: "red" }}>
                        {errors.flightLandingStation}
                      </span>
                    )}
                  </div>

                  <div className="row mb-2">
                    <div className="col-sm-6">
                      <div className="form-group">
                        <label>ArrivalDate:</label>
                        <input
                          type="date"
                          name="arrivalDate"
                          className="form-control"
                          value={this.state.arrivalDate}
                          onChange={this.changearrivalDateHandler}
                          noValidate
                        />
                      </div>
                    </div>

                    <div className="col-sm-6">
                      <div className="form-group">
                        <label>ArrivalTime:</label>
                        <input
                          type="time"
                          name="arrivalTime"
                          className="form-control"
                          value={this.state.arrivalTime}
                          onChange={this.changearrivalTimeHandler}
                          noValidate
                        />
                      </div>
                    </div>
                  </div>

                  <div className="form-group">
                    <label>Price:</label>
                    <input
                      type="text"
                      pattern="[0-9]*"
                      placeholder="price"
                      name="price"
                      className="form-control"
                      value={this.state.price}
                      onChange={this.handleChange}
                      noValidate
                    />

                    {errors.price > 0 && (
                      <span className="error" style={{ color: "red" }}>
                        {errors.price}
                      </span>
                    )}
                  </div>

                  <button className="btn btn-success" onClick={this.saveFlight}>
                    save
                  </button>
                  <button
                    className="btn btn-danger"
                    onClick={this.cancel.bind(this)}
                    style={{ marginLeft: "10px" }}
                  >
                    Cancel
                  </button>
                </form>
              </div>
              {/*</div>*/}
            </div>
          </div>
        </div>
        <div>
          <footer className="footer">
            <span className="text-muted">
              All Rights Reserved 2021 @Vignesh
            </span>
          </footer>
        </div>
      </div>
    );
  }
}

export default withRouter(CreateFlightsComponent);
