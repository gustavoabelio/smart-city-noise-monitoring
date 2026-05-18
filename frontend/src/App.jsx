import NoiseChart from "./components/NoiseChart";
import useSensorData from "./hooks/useSensorData";
import "./App.css";

const THRESHOLD = 75;

function getStatus(db) {
  if (db >= THRESHOLD) return "infraction";
  if (db >= 65) return "high";
  return "normal";
}

const STATUS_LABEL = {
  normal: "normal",
  high: "alto",
  infraction: "infração",
};

const STATUS_COLOR = {
  normal: "#1D9E75",
  high: "#EF9F27",
  infraction: "#E24B4A",
};

const STATUS_BG = {
  normal: "#04342C",
  high: "#412402",
  infraction: "#501313",
};

export default function App() {
  const { sensors, stats, history, selectedSensorId, setSelectedSensorId } =
    useSensorData();

  const selectedSensor = sensors.find((s) => s.id === selectedSensorId);

  return (
    <div className="dash">
      {}
      <header className="topbar">
        <div className="topbar-left">
          <span className="logo-dot" />
          <span className="logo-text">Smart City — Noise Monitoring</span>
        </div>
        <div className="topbar-right">
          <span className="live-badge">
            <span className="live-dot" />
            live
          </span>
        </div>
      </header>

      <main className="content">
        {}
        {stats && (
          <div className="metrics">
            <div className="metric-card">
              <div className="metric-label">sensores ativos</div>
              <div className="metric-value">
                {sensors.length}
                <span className="metric-unit"> / {sensors.length}</span>
              </div>
              <div className="metric-sub ok">Todos online</div>
            </div>

            <div className="metric-card">
              <div className="metric-label">infrações totais</div>
              <div
                className="metric-value"
                style={{ color: stats.totalInfractions > 0 ? "#E24B4A" : "#1D9E75" }}
              >
                {stats.totalInfractions}
              </div>
              <div
                className="metric-sub"
                style={{ color: stats.totalInfractions > 0 ? "#E24B4A" : "#1D9E75" }}
              >
                {stats.totalInfractions > 0 ? "Atenção necessária" : "Sem infrações"}
              </div>
            </div>

            <div className="metric-card">
              <div className="metric-label">média de ruído</div>
              <div
                className="metric-value"
                style={{
                  color:
                    stats.averageNoise >= THRESHOLD
                      ? "#E24B4A"
                      : stats.averageNoise >= 65
                      ? "#EF9F27"
                      : "#1D9E75",
                }}
              >
                {stats.averageNoise.toFixed(1)}
                <span className="metric-unit"> dB</span>
              </div>
              <div className="metric-sub" style={{ color: "#888780" }}>
                Média geral
              </div>
            </div>

            <div className="metric-card">
              <div className="metric-label">pico registrado</div>
              <div className="metric-value" style={{ color: "#E24B4A" }}>
                {stats.maxNoise.toFixed(1)}
                <span className="metric-unit"> dB</span>
              </div>
              <div className="metric-sub" style={{ color: "#888780" }}>
                Maior leitura
              </div>
            </div>
          </div>
        )}

        {}
        <div className="main-grid">
          {}
          <div className="panel">
            <div className="panel-title">
              histórico de ruído
              {selectedSensor && (
                <span className="panel-title-sub">— {selectedSensor.name}</span>
              )}
            </div>
            <NoiseChart data={history} threshold={THRESHOLD} />
            <div className="chart-legend">
              <span className="legend-item">
                <span className="legend-line" style={{ background: "#1D9E75" }} />
                leitura (dB)
              </span>
              <span className="legend-item">
                <span
                  className="legend-line"
                  style={{
                    background: "transparent",
                    borderTop: "2px dashed #E24B4A",
                    height: 0,
                    marginTop: "6px",
                  }}
                />
                limite ({THRESHOLD} dB)
              </span>
            </div>
          </div>

          {}
          <div className="panel">
            <div className="panel-title">sensores</div>
            <div className="sensor-list">
              {sensors.map((sensor) => {
                const status = getStatus(sensor.currentDecibels ?? 0);
                const color = STATUS_COLOR[status];
                const bg = STATUS_BG[status];
                const isSelected = selectedSensorId === sensor.id;

                return (
                  <div
                    key={sensor.id}
                    className={`sensor-item${isSelected ? " active" : ""}`}
                    onClick={() => setSelectedSensorId(sensor.id)}
                    style={isSelected ? { borderColor: "#1D9E75" } : {}}
                  >
                    <span
                      className="sensor-dot"
                      style={{ background: color }}
                    />
                    <div className="sensor-info">
                      <div className="sensor-name">{sensor.name}</div>
                      <div className="sensor-loc">{sensor.location}</div>
                      <span
                        className="status-badge"
                        style={{ background: bg, color }}
                      >
                        {STATUS_LABEL[status]}
                      </span>
                    </div>
                    <div className="sensor-db" style={{ color }}>
                      {(sensor.currentDecibels ?? 0).toFixed(1)} dB
                    </div>
                  </div>
                );
              })}
            </div>
          </div>
        </div>
      </main>
    </div>
  );
}
