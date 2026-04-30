import { useEffect, useState } from "react";

export default function useSensorData() {
  const [sensors, setSensors] = useState([]);
  const [history, setHistory] = useState([]);
  const [stats, setStats] = useState(null);
  const [selectedSensorId, setSelectedSensorId] = useState(1);

  const fetchSensorsAndStats = () => {
    fetch("http://localhost:8080/sensors")
      .then(res => res.json())
      .then(data => setSensors(data));

    fetch("http://localhost:8080/infractions/stats")
      .then(res => res.json())
      .then(data => setStats(data));
  };

  const fetchHistory = () => {
    fetch(`http://localhost:8080/sensors/${selectedSensorId}/history`)
      .then(res => res.json())
      .then(data => {

        const formatted = data
          .slice(0, 20) 
          .reverse()   
          .map(item => ({
            ...item,
            value: Number(item.value.toFixed(1)), 
            timestamp: new Date(item.timestamp).toLocaleTimeString()
          }));

        setHistory(formatted);
      });
  };

  useEffect(() => {
    fetchSensorsAndStats();
    fetchHistory();
  }, []);

  useEffect(() => {
    fetchHistory();
  }, [selectedSensorId]);

  useEffect(() => {
    const interval = setInterval(() => {
      fetchSensorsAndStats();
      fetchHistory();
    }, 5000);

    return () => clearInterval(interval);
  }, []);

  return {
    sensors,
    stats,
    history,
    selectedSensorId,
    setSelectedSensorId
  };
}