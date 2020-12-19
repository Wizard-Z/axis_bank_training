// import React, { Component } from "react";
// import axios from "axios";
// import LineChart from "./LineChart";
// import BarChart from "./BarChart";
// class tempR extends Component {
//   constructor(props) {
//     super(props);

//     this.state = {
//       lineData: [],
//       barData: {
//         labels: "",
//         datasets: "",
//       },
//     };
//   }

//   getUnique = (items, value) => {
//     //return [...new Set(items.map((item) => item[value]))];
//     return [...new Set(items.map((item) => item._id[value]))];
//   };
//   getss(items, rtype) {
//     return {
//       xtype: rtype.map((t) =>
//         items.results
//           .filter((item) => item._id.type === t)
//           .map((item) => [item.count, item._id.month, item._id.type])
//           .sort(this.compareSecondColumn)
//       ),
//     };
//   }
//   compareSecondColumn(a, b) {
//     if (a[1] === b[1]) {
//       return 0;
//     } else {
//       return a[1] < b[1] ? -1 : 1;
//     }
//   }
//   getDynamicColor = (alpha) => {
//     let r = Math.floor(Math.random() * 255);
//     let g = Math.floor(Math.random() * 255);
//     let b = Math.floor(Math.random() * 255);
//     return `rgba(${r},${g},${b},${alpha})`;
//   };
//   getLines(arr, types) {
//     let datasets = [];
//     let datas = arr.map((ar) => ar.map((a) => a[0]));
//     let i;
//     for (i = 0; i < types.length; i++) {
//       datasets.push({
//         label: types[i],
//         data: datas[i],
//         borderColor: [this.getDynamicColor()],
//         backgroundColor: [this.getDynamicColor()],
//       });
//     }
//     return datasets;
//   }

//   /**    return {
//       rtype: items.results
//         .filter((item) => item._id.type === rtype)
//         .map((item) => [item.count, item._id.month, item._id.type]),
//     }; */
//   componentDidMount() {
//     /*axios
//       .get("http://localhost:8087/api/customers/bookings-datewise")
//       .then((response) => {
//         let res = response.data;
//         let uniqueTypes = this.getUnique(res.results, "type");
//         let carray = this.getss(res, uniqueTypes).xtype;
//         let liness = this.getLines(carray, uniqueTypes);
//         this.setState({ lineData: liness });
//         console.log(
//           "\nLINECHART-CONSOLE:",
//           "RESPONSE: ",
//           res,
//           "---",
//           "TYPES: ",
//           uniqueTypes,
//           "CARRAY: ",
//           carray,
//           ":::",
//           "LINES: ",
//           liness
//         );
//       })
//       .catch((error) => {
//         console.log(error);
//       });*/
//     /**BAR CHARTS */
//     axios
//       .get("http://localhost:8087/api/rooms/occupants")
//       .then((response) => {
//         let res = response.data;
//         let labels = res.results.map((r) => r._id);

//         let borderColor = labels.map((l) => this.getDynamicColor(0.5));
//         let backgroundColor = labels.map((l) => this.getDynamicColor(0.2));
//         let datasets = [
//           {
//             label: "Occupancy",
//             data: res.results.map((r) => r.count),
//             borderColor,
//             backgroundColor,
//           },
//         ];

//         this.setState({ barData: { labels, datasets } });
//         console.log(
//           "IN BARCHARTS:::",
//           "RESPONSE",
//           res,
//           "BARDATA::",
//           this.state.barData
//         );
//       })
//       .catch((error) => {
//         console.log(error);
//       });
//   }
//   render() {
//     console.log(this.state.barData);
//     return (
//       <>
//         <div className="container">
//           <div className="row">
//             <div className="col-sm-10">
//               {/*<LineChart props={this.state.lineData} />*/}
//               <BarChart props={this.state.barData} />
//             </div>
//           </div>
//         </div>
//       </>
//     );
//   }
// }

// export default tempR;
