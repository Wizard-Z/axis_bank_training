import React from "react";
import { Link } from "react-router-dom";
import bcg from "../images/cardBcg.jpg";
import loadingGif from "../images/loading.gif";
export default function room({ rooms }) {
  console.log(rooms);
  let posts = rooms;
  return (
    <div className="container-fluid">
      <h6>Room Lists</h6>
      <div className="row">
        {posts.length ? (
          posts.map((post) => (
            <div className="col-md m-2" key={post.id}>
              <div className="card" style={{ width: "18rem" }}>
                <img className="card-img-top" src={bcg} alt="Room"></img>
                <div className="card-body">
                  <h4 className="card-title">{post.name}</h4>
                  <p className="card-text">
                    Lorem ipsum, dolor sit amet consectetur adipisicing elit.
                    Quas, nulla.
                  </p>
                </div>
                <ul className="list-group list-group-flush">
                  <li className="list-group-item">
                    <strong>Price: </strong>
                    {post.price}
                  </li>
                  <li className="list-group-item">
                    <strong>Beds: </strong> {post.capacity}
                  </li>
                  <li className="list-group-item">
                    <strong>category: </strong> {post.type}
                  </li>
                  <li className="list-group-item">
                    <Link
                      to={{
                        pathname: `/test/checkout/${post.type}`,
                        state: {
                          type: post.type,
                          rname: post.name,
                          rid: post.id,
                          price: post.price,
                        },
                      }}
                    >
                      <button type="button" className="btn btn-success">
                        Book
                      </button>
                    </Link>
                  </li>
                </ul>
              </div>
            </div>
          ))
        ) : (
          <div className="container">
            <h4>Rooms Loading....</h4>
            <img src={loadingGif} alt="loading" />
            <br/>
            try refreshing... or change search parameters....
          </div>
        )}
      </div>
    </div>
  );
}
