import React from "react";
import { Bar } from "react-chartjs-2";

function BarChart({ props }) {
  console.log("BARCHART HERE:", props);
  const data = {
    labels: props.labels,
    datasets: props.datasets,
  };
  //Not runs for the first time?? pass down from parent instead of calculating here.
  //const maxR = Math.max.apply(Math, data.datasets[0].data) + 5;

  const options = {
    title: {
      display: true,
      text: "Current Occupants",
    },
    scales: {
      yAxes: [
        {
          ticks: {
            min: 0,
            max: 36,
            stepSize: 2,
          },
        },
      ],
    },
  };
  return <Bar data={data} options={options} />;
}

export default BarChart;
