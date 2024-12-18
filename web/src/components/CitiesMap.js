import React, { useEffect, useState } from "react";
import { MapContainer, TileLayer, Polygon } from "react-leaflet";
import "leaflet/dist/leaflet.css";

const CitiesMap = () => {
  const [cities, setCities] = useState([]);

  useEffect(() => {
    fetch("http://127.0.0.1:8080/api/cities")
      .then((response) => response.json())
      .then((data) => setCities(data.features));
  }, []);

  const parseCoordinates = (coordinates) => {
    return coordinates.map((point) => [point.y, point.x]);
  };

  return (
    <div style={{ height: "100vh" }}>
      <MapContainer
        center={[0, 0]} 
        zoom={2}
        style={{ height: "100%", width: "100%" }}
        maxBounds={[
          [-90, -180],
          [90, 180],
        ]}
        maxBoundsViscosity={1.0}
      >
        <TileLayer
          url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
          attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
        />
        {cities.map((city, index) => (
          <Polygon
            key={index}
            positions={parseCoordinates(city.geometry.coordinates)}
            color="blue"
            weight={2}
            fillColor="lightblue"
            fillOpacity={0.5}
          />
        ))}
      </MapContainer>
    </div>
  );
};

export default CitiesMap;
