import {
  LineChart,
  Line,
  XAxis,
  YAxis,
  Tooltip,
  CartesianGrid,
  ReferenceLine,
  ResponsiveContainer,
} from "recharts";

function CustomTooltip({ active, payload, label }) {
  if (!active || !payload?.length) return null;
  return (
    <div
      style={{
        background: "#181b24",
        border: "0.5px solid #2a2d3a",
        borderRadius: "8px",
        padding: "8px 12px",
        fontSize: "12px",
        color: "#e2e4ed",
      }}
    >
      <div style={{ color: "#888780", marginBottom: "4px" }}>{label}</div>
      <div style={{ color: "#1D9E75", fontWeight: 500 }}>
        {payload[0].value.toFixed(1)} dB
      </div>
    </div>
  );
}

export default function NoiseChart({ data, threshold = 75 }) {
  return (
    <ResponsiveContainer width="100%" height={220}>
      <LineChart data={data} margin={{ top: 8, right: 8, left: -10, bottom: 0 }}>
        <CartesianGrid strokeDasharray="3 3" stroke="#2a2d3a" vertical={false} />
        <XAxis
          dataKey="timestamp"
          tick={{ fill: "#888780", fontSize: 10 }}
          axisLine={false}
          tickLine={false}
          interval="preserveStartEnd"
        />
        <YAxis
          domain={[40, 110]}
          tick={{ fill: "#888780", fontSize: 10 }}
          axisLine={false}
          tickLine={false}
          tickFormatter={(v) => `${v}`}
        />
        <Tooltip content={<CustomTooltip />} />
        <ReferenceLine
          y={threshold}
          stroke="#E24B4A"
          strokeDasharray="4 4"
          strokeWidth={1}
        />
        <Line
          type="monotone"
          dataKey="value"
          stroke="#1D9E75"
          strokeWidth={2}
          dot={false}
          activeDot={{ r: 4, fill: "#1D9E75", strokeWidth: 0 }}
        />
      </LineChart>
    </ResponsiveContainer>
  );
}
