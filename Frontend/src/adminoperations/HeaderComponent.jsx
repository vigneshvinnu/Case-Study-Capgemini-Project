import React, { Component } from "react";

export default class HeaderComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {};
  }
  render() {
    return (
      <div>
        <nav className="navbar navbar-expand-md navbar-dark- bg-dark">
          <div>
            <a href="www.google.com" className="navbar brand">
              Welcome Admin
            </a>
          </div>
          <div>
            <a href=" /admin" className="navbar brand">
              Home
            </a>
          </div>
          <div>
            <a href=" /flights" className="navbar brand">
              Operations
            </a>
          </div>

          <div>
            <a href=" /add-flight" className="navbar brand">
              Add Flights
            </a>
          </div>
          <div>
            <a href=" /search-flightsuser" className="navbar brand">
              Search Flights
            </a>
          </div>
        </nav>
      </div>
    );
  }
}
