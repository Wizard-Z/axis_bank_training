import React, { useState } from "react";
import axios from "axios";

export default function TestKafka() {
  const [review, setReview] = useState("");
  const [type, setType] = useState("");
  const [status, setStatus] = useState("");

  function refreshPage() {
    window.location.reload();
  }

  function clickHandle() {
    const obj = { id: type, review };
    console.log(obj);
    axios
      .post("http://localhost:8085/testPython", obj)
      .then((response) => {
        console.log(response);
        setStatus(
          <>
            "Thanks for the feedback!"
            <br />
            <button
              type="button"
              className="btn btn-primary"
              onClick={refreshPage}
            >
              {" "}
              <span>submit-another</span>{" "}
            </button>
          </>
        );
      })
      .catch((error) => {
        console.log(error);
      });
    console.log("Success!!");
  }

  return (
    <div
      className="container d-flex align-items-center justify-content-center"
      style={{ marginTop: "100px", maxWidth: "400px" }}
    >
      <div className="card">
        <div className="input-group md-3">
          <div className="input-group-prepend">
            <label className="input-group-text" htmlFor="inputGroupSelect01">
              Category
            </label>
          </div>
          <select
            className="custom-select"
            id="inputGroupSelect01"
            onChange={(e) => setType(e.target.value)}
          >
            <option selected>Choose...</option>
            <option value="1">Suit</option>
            <option value="2">Single-bed</option>
            <option value="3">Double-bed</option>
            <option value="4">Family</option>
            <option value="5">Master-suit</option>
          </select>
        </div>
        <br />
        <div className="input-group mb-3">
          <input
            type="text"
            className="form-control"
            placeholder="Review.."
            aria-describedby="basic-addon2"
            value={review}
            onChange={(e) => setReview(e.target.value)}
          />
          <div className="input-group-append">
            <button className="btn btn-primary" onClick={clickHandle}>
              Submit Review
            </button>
          </div>
          <h4> {status}</h4>
        </div>
      </div>
    </div>
  );
}
