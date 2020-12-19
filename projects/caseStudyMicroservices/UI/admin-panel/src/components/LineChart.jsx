import React from "react";
import { Line } from "react-chartjs-2";

function LineChart({ props }) {
  console.log("In lineChart::", props);
  const data = {
    labels: ["Sept", "Oct", "Nov", "Dec"],
    datasets: props,
  };

  const options = {
    title: {
      display: true,
      text: "Sales-Trends",
    },
    scales: {
      yAxes: [
        {
          ticks: {
            min: 0,
            max: 14,
            stepSize: 1,
          },
        },
      ],
    },
  };

  return <Line data={data} options={options} />;
}

export default LineChart;
