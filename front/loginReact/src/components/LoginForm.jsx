import { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import api from "../api/api";

export default function LoginForm() {
  const [form, setForm] = useState({ email: "", password: "" });
  const navigate = useNavigate();

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      await api.post("/auth/signin", form);
      alert("OTP enviado, revisa la bandeja de tu correo electrónico");
      localStorage.setItem("email", form.email);
      navigate("/otp");
    } catch (err) {
      alert("Error en inicio de sesión o credenciales inválidas");
      console.error(err);
    }
  };

  return (
    <div className="form-container">
      <h2>Iniciar Sesión</h2>
      <form onSubmit={handleSubmit} className="form">
        <input name="email" type="email" placeholder="Correo electrónico" onChange={handleChange} required />
        <input name="password" type="password" placeholder="Contraseña" onChange={handleChange} required />
        <button type="submit">Ingresar</button>
      </form>

      <p className="small-text">
        ¿No tienes una cuenta?{" "}
        <Link to="/register" className="link">
          Regístrate aquí
        </Link>
      </p>
    </div>
  );
}
