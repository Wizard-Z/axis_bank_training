import { FaWarehouse } from "react-icons/fa";
import { FaChartLine } from "react-icons/fa";
import { FaHandsHelping } from "react-icons/fa";
import { FaHotel } from "react-icons/fa";
import { FaCartPlus } from "react-icons/fa";

import React, { useState, useEffect } from "react";
import Rooms from "./Rooms";
import Plots from "./Plots";
import AddRoomForm from "./AddRoomForm";
import { Link } from "react-router-dom";

export default function Dashboard_copy() {
  const [category, setCategory] = useState("plots");
  const [items, setItems] = useState({ content: "", title: "" });

  useEffect(() => {
    console.log("c:", category);
    if (category === "rooms") {
      setItems({ content: <Rooms />, title: "List of All Rooms!" });
    }
    if (category === "plots") {
      setItems({ content: <Plots />, title: "Sales trends" });
    }
    if (category === "addRoom") {
      setItems({ content: <AddRoomForm />, title: "Add Room!" });
    }

    return () => {};
  }, [category]);

  return (
    <div>
      <nav className="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
        <button className="btn btn-dark" onClick={() => setCategory("plots")}>
          <FaWarehouse />
        </button>
        <button
          className="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#navbarNavDropdown"
          aria-controls="navbarNavDropdown"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarNavDropdown">
          <ul className="navbar-nav">
            <li className="nav-item active">
              <button
                className="btn btn-dark"
                onClick={() => setCategory("plots")}
              >
                Dashboard
              </button>
            </li>
            <li className="nav-item">
              <button
                className="btn btn-dark"
                onClick={() => setCategory("rooms")}
              >
                <FaHotel /> Rooms
              </button>
              {/* <a className="nav-link" href="/rooms">
                <FaHotel /> Rooms
              </a> */}
            </li>
            <li className="nav-item">
              <button
                className="btn btn-dark"
                onClick={() => setCategory("addRoom")}
              >
                <FaCartPlus /> Add-room
              </button>
            </li>
            <li className="nav-item dropdown">
              <a
                className="nav-link dropdown-toggle"
                id="navbarDropdownMenuLink"
                role="button"
                data-toggle="dropdown"
                aria-haspopup="true"
                aria-expanded="false"
              >
                Dropdown link
              </a>
              <div
                className="dropdown-menu"
                aria-labelledby="navbarDropdownMenuLink"
              >
                <Link to="/" className="dropdown-item">
                  Profile
                </Link>
              </div>
            </li>
          </ul>
        </div>
      </nav>
      <div className="sbar">
        {" "}
        <div className="container-fluid">
          <div className="row">
            <nav className="col-md-2 d-none d-md-block bg-light sidebar">
              <div className="sidebar-sticky">
                <ul className="nav flex-column">
                  <li className="nav-item">
                    <div className="nav-link">
                      <button
                        className="btn btn-Link"
                        onClick={() => setCategory("plots")}
                      >
                        <FaChartLine /> Dashboard
                      </button>
                    </div>
                  </li>

                  <li className="nav-item">
                    <div className="nav-link">
                      <button className="btn btn-Link">
                        <FaHandsHelping /> Requests
                      </button>
                    </div>
                  </li>

                  <li className="nav-item">
                    <div className="nav-link">
                      <button
                        className="btn btn-Link"
                        onClick={() => setCategory("rooms")}
                      >
                        <FaHotel /> Rooms
                      </button>
                    </div>
                  </li>

                  <li className="nav-item">
                    <div className="nav-link">
                      <button
                        className="btn btn-Link"
                        onClick={() => setCategory("addRoom")}
                      >
                        <FaCartPlus /> Add-room
                      </button>
                    </div>
                  </li>
                </ul>

                <h6 className="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
                  <span>Saved reports</span>
                  <a className="d-flex align-items-center text-muted">
                    <span data-feather="plus-circle"></span>
                  </a>
                </h6>
                <ul className="nav flex-column mb-2">
                  <li className="nav-item">
                    <a className="nav-link">
                      <span data-feather="file-text"></span>
                      Year-end sale
                    </a>
                  </li>
                </ul>
              </div>
            </nav>

            <main
              role="main"
              className="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4"
            >
              <div className="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
                <h2 className="h2">{items.title}</h2>
                <div className="btn-toolbar mb-2 mb-md-0">
                  <div className="btn-group mr-2">
                    <button className="btn btn-sm btn-outline-secondary">
                      Share
                    </button>
                    <button className="btn btn-sm btn-outline-secondary">
                      Export
                    </button>
                  </div>
                </div>
              </div>
              <>{items.content}</>
            </main>
          </div>
        </div>
      </div>
    </div>
  );
}
