import React from "react";
import loadingGif from "../images/loading.gif";
import bcg from "../images/cardBcg.jpg";
export default function room({ rooms, onToggle }) {
  console.log(rooms);
  let posts = rooms;
  console.log("--->> ", posts);
  return (
    <div className="container">
      <div className="row">
        {posts.length ? (
          posts.map((post) => (
            <div className="col-sm-4" key={post.id}>
              <p> </p>
              <div className={post.available ? "card" : "card bg-danger"}>
                <img className="card-img-top" src={bcg}></img>
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
                    <strong>left: </strong> {post.left}
                  </li>
                  <li className="list-group-item">
                    <strong>capacity: </strong> {post.capacity}
                  </li>
                  <li className="list-group-item">
                    <strong>available: </strong> {post.available.toString()}
                  </li>
                  <li className="list-group-item">
                    <strong>featured: </strong> {post.featured.toString()}
                  </li>
                  <li className="list-group-item">
                    <button
                      onClick={() => onToggle(post.id)}
                      type="button"
                      className="btn btn-success"
                    >
                      Toggle
                    </button>
                  </li>
                </ul>
              </div>
            </div>
          ))
        ) : (
          <div className="container">
            <h4>Rooms Loading....</h4>
            <img src={loadingGif} alt="loading" />
          </div>
        )}
      </div>
    </div>
  );
}
