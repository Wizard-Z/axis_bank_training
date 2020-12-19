import React, { Component } from "react";
import BarChart from "../components/BarChart";
import DoughnutChart from "../components/DoughnutChart";
import LineChart from "../components/LineChart";
import axios from "axios";

class Plots extends Component {
  state = {
    doughnutData: {
      labels: "",
      datasets: [
        {
          label: "",
          data: "",
          backgroundColor: "",
        },
      ],
    },
    labelsDoughnut: "",
    dataDoughnut: "",
    lineData: [],
    barData: {
      labels: "",
      datasets: "",
    },
    baseUrl: "http://localhost:8083",
  };
  getUnique = (items, value) => {
    return [...new Set(items.map((item) => item[value]))];
  };

  /**UTILITY FUNCTONS FOR LINE CHART  */

  /**GET DIFFERENT ROOM CATEGORIES */
  getUnique2 = (items, value) => {
    //return [...new Set(items.map((item) => item[value]))];
    return [...new Set(items.map((item) => item._id[value]))];
  };
  /** Sort the data in particular sequence.. here month wise.*/
  getss(items, rtype) {
    return {
      xtype: rtype.map((t) =>
        items.results
          .filter((item) => item._id.type === t)
          .map((item) => [item.count, item._id.month, item._id.type])
          .sort(this.compareSecondColumn)
      ),
    };
  }

  /**Helper function for above function */
  compareSecondColumn(a, b) {
    if (a[1] === b[1]) {
      return 0;
    } else {
      return a[1] < b[1] ? -1 : 1;
    }
  }

  /** CHARTJS NEEDS COLORS TO BE DEFINED ... this will help */
  getDynamicColor = (alpha) => {
    let r = Math.floor(Math.random() * 255);
    let g = Math.floor(Math.random() * 255);
    let b = Math.floor(Math.random() * 255);
    return `rgba(${r},${g},${b},${alpha})`;
  };
  /**FINAL DATA FOR THE LINE PLOT */
  getLines(arr, types) {
    let datasets = [];
    let datas = arr.map((ar) => ar.map((a) => a[0]));
    let i;
    for (i = 0; i < types.length; i++) {
      datasets.push({
        label: types[i],
        data: datas[i],
        borderColor: [this.getDynamicColor(0.7)],
        backgroundColor: [this.getDynamicColor(0.1)],
        pointBorderColor: this.getDynamicColor(1),
        pointBackgroundColor: this.getDynamicColor(1),
      });
    }
    return datasets;
  }

  componentDidMount() {
    /**For Doughnut Graph */
    axios
      .get(`${this.state.baseUrl}/api/transactions/earnings`)
      .then((response) => {
        console.log("\nIn Doughnut-Log", response.data);
        let res = response.data;
        let uniqueTypes = this.getUnique(res.results, "_id");
        let earnTypes = res.results.map((r) => r.sum);
        let backgroundColor = uniqueTypes.map((l) => this.getDynamicColor(1));
        console.log(uniqueTypes, ":::", earnTypes);
        this.setState({
          doughnutData: {
            labels: uniqueTypes,
            datasets: [
              {
                label: "Sales",
                data: earnTypes,
                backgroundColor,
              },
            ],
          },
        });
        // this.setState({
        //   labelsDoughnut: uniqueTypes,
        //   dataDoughnut: earnTypes,
        // });
      })
      .catch((error) => {
        console.log(error);
      });
    /**For Line Chart */
    axios
      .get(`${this.state.baseUrl}/api/customers/bookings-datewise`)
      .then((response) => {
        let resLine = response.data;
        let uniqueTypes2 = this.getUnique2(resLine.results, "type");
        let carray = this.getss(resLine, uniqueTypes2).xtype;
        let liness = this.getLines(carray, uniqueTypes2);
        this.setState({ lineData: liness });
        console.log(
          "\nIn LINECHART-LOG",
          "RESPONSE: ",
          resLine,
          "---",
          "TYPES: ",
          uniqueTypes2,
          "CARRAY: ",
          carray,
          ":::",
          "LINES: ",
          liness
        );
      })
      .catch((error) => {
        console.log(error);
      });

    /**For Histograms */
    /**BAR CHARTS */
    axios
      .get(`${this.state.baseUrl}/api/customers/occupants`)
      .then((response) => {
        let res = response.data;
        let labels = res.results.map((r) => r._id);

        let borderColor = labels.map((l) => this.getDynamicColor(0.5));
        let backgroundColor = labels.map((l) => this.getDynamicColor(0.2));
        let datasets = [
          {
            label: "Occupancy",
            data: res.results.map((r) => r.count),
            borderColor,
            backgroundColor,
          },
        ];

        this.setState({ barData: { labels, datasets } });
        console.log(
          "IN BARCHARTS:::",
          "RESPONSE",
          res,
          "BARDATA::",
          this.state.barData
        );
      })
      .catch((error) => {
        console.log(error);
      });
  }
  render() {
    return (
      <>
        <div className="container">
          <div className="row">
            <div className="col-sm-11">
              <div className="card m-2">
                <LineChart props={this.state.lineData} />
              </div>
            </div>
          </div>
          <div className="row">
            <div className="col-sm-6">
              <div className="card m-2">
                <BarChart props={this.state.barData} />
              </div>
            </div>
            <div className="col-sm-6">
              <div className="card m-2">
                <DoughnutChart props={this.state.doughnutData} />
              </div>
            </div>
            <div className="col-0"></div>
          </div>
        </div>
      </>
    );
  }
}

export default Plots;
