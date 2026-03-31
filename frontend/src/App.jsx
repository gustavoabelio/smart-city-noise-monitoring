import { useEffect, useState } from "react";

function App() {

  const [sensors, setSensors] = useState([]);
  const [stats, setStats] = useState(null);

  useEffect(() => {

    fetch("http://localhost:8080/sensors")
      .then(res => res.json())
      .then(data => setSensors(data));

    fetch("http://localhost:8080/infractions/stats")
      .then(res => res.json())
      .then(data => setStats(data));

  }, []);

  return (
    <div style={{ padding: "40px", fontFamily: "Arial", background:"#0f172a", minHeight:"100vh", color:"white" }}>

      <h1 style={{marginBottom:"30px"}}>Smart City Noise Monitoring</h1>

      {/* STATS */}

      {stats && (
        <div style={{display:"flex", gap:"20px", marginBottom:"40px"}}>

          <div style={cardStyle}>
            <h3>Total Infractions</h3>
            <p style={numberStyle}>{stats.totalInfractions}</p>
          </div>

          <div style={cardStyle}>
            <h3>Average Noise</h3>
            <p style={numberStyle}>{stats.averageNoise.toFixed(1)} dB</p>
          </div>

          <div style={cardStyle}>
            <h3>Max Noise</h3>
            <p style={numberStyle}>{stats.maxNoise} dB</p>
          </div>

        </div>
      )}

      <h2>Sensors</h2>

      <div style={{display:"flex", gap:"20px", flexWrap:"wrap"}}>

        {sensors.map(sensor => {

          const highNoise = sensor.currentDecibels >= 70;

          return (
            <div
              key={sensor.id}
              style={{
                background:"#1e293b",
                padding:"20px",
                borderRadius:"10px",
                width:"220px",
                border: highNoise ? "2px solid #ef4444" : "2px solid #22c55e",
                transition:"0.25s",
                cursor:"pointer",
                transform:"scale(1)"
              }}
              onMouseEnter={(e) => e.currentTarget.style.transform = "scale(1.05)"}
              onMouseLeave={(e) => e.currentTarget.style.transform = "scale(1)"}
            >
              <h3>{sensor.name}</h3>

              <p>{sensor.location}</p>

              <p style={{fontSize:"22px", fontWeight:"bold"}}>
                {sensor.currentDecibels} dB
              </p>

              <p style={{color: highNoise ? "#ef4444" : "#22c55e"}}>
                {highNoise ? "High Noise" : "Normal"}
              </p>

            </div>
          );
        })}

      </div>

    </div>
  );
}

const cardStyle = {
  background:"#1e293b",
  padding:"20px",
  borderRadius:"10px",
  width:"200px"
};

const numberStyle = {
  fontSize:"26px",
  fontWeight:"bold"
};

export default App;