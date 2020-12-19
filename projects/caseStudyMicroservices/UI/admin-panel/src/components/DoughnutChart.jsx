import React from "react";
import { Doughnut } from "react-chartjs-2";

function DoughnutChart({ props }) {
  const data = props;

  // labels: props.labelsDoughnut,
  // datasets: [
  //   {
  //     label: "Sales 2020 (M)",
  //     data: props.dataDoughnut,
  //     backgroundColor: [
  //       "rgba(255, 99, 132, 1)",
  //       "rgba(255, 205, 86, 1)",
  //       "rgba(54, 162, 235, 1)",
  //       "rgba(255, 159, 64, 1)",
  //       "rgba(153, 102, 255, 1)",
  //       "rgba(104, 12, 25, 1)",
  //       "rgba(34, 62, 235, 1)",
  //     ],
  //   },
  // ],
  //};
  console.log(props, "::::", data);
  const options = {
    title: {
      display: true,
      text: "Doughnut Chart",
    },
  };

  return <Doughnut data={data} options={options} />;
}

export default DoughnutChart;
