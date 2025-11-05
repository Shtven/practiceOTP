import { useState } from "react";
import api from "../api/api";

export default function OtpForm() {
  const [otp, setOtp] = useState("");
  const email = localStorage.getItem("email");

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const res = await api.post("/otp/verify", {
        email: email,
        code: parseInt(otp),
      });

      alert("✅ " + res.data);
      localStorage.removeItem("email");
    } catch (err) {
      alert("Código inválido o expirado");
      console.error(err);
    }
  };

  return (
    <form onSubmit={handleSubmit} className="form">
      <h2>Verificación OTP</h2>
      <input
        type="text"
        maxLength={6}
        placeholder="Ingresa el código OTP"
        value={otp}
        onChange={(e) => setOtp(e.target.value)}
        required
      />
      <button type="submit">Verificar</button>
    </form>
  );
}
