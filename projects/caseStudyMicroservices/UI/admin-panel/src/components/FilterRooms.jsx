import React from "react";

const getUnique = (items, value) => {
  return [...new Set(items.map((item) => item[value]))];
};
function FilterRooms({ rooms }) {
  const { handleChange, type, capacity, price, minPrice, maxPrice } = context;
  console.log("From filter", context);
  // get unique types
  let types = getUnique(rooms, "type");
  // add all
  types = ["all", ...types];
  console.log(types);
  types = types.map((item, index) => {
    return (
      <option value={item} key={index}>
        {item}
      </option>
    );
  });

  // capacity

  let beds = getUnique(rooms, "capacity");
  beds = beds.map((item, index) => {
    return (
      <option key={index} value={item}>
        {item}
      </option>
    );
  });

  return (
    <div>
      <h4>Search room</h4>
      <section>
        <form>
          <div>
            {/**type filter */}
            <label htmlFor="type">room type</label>
            <select name="type" value={type} id="type" onChange={handleChange}>
              {types}
            </select>
          </div>
          {/**--end select-- */}
          {/** capacity filter */}
          <div>
            <label htmlFor="capacity">Guests</label>
            <select
              name="capacity"
              value={capacity}
              id="capacity"
              onChange={handleChange}
            >
              {beds}
            </select>
          </div>

          {/**--end capacity-- */}
          {/**Price filter */}
          <div>
            <label htmlFor="price">room price:${price}</label>
            <input
              type="range"
              name="price"
              min={minPrice}
              max={maxPrice}
              id="price"
              value={price}
              onChange={handleChange}
            ></input>
          </div>
        </form>
      </section>
    </div>
  );
}

export default FilterRooms;
