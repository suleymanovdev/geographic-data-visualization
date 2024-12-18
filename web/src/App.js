import React from "react";
import CitiesMap from "./components/CitiesMap";

const App = () => {
  return (
    <div>
      <h1 style={{ textAlign: "center", marginTop: "20px" }}>
        Geographic Data Visualization
      </h1>
      <CitiesMap />
    </div>
  );
};

export default App;
