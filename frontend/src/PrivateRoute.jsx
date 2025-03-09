import React from "react";
import { Navigate, Outlet } from "react-router-dom";

const PrivateRoute = () => {
  const token = localStorage.getItem("token");
  console.log("token: " + token);

  if (!token) {
    alert("Access Denied! Please log in.");
    return <Navigate to="/login" />;
  }

  try {
    const userRole = localStorage.getItem("role");
    if (userRole !== "ADMIN") {
      alert("Unauthorized! Admins only.");
      return <Navigate to="/" />;
    }

    return <Outlet />;
  } catch (error) {
    console.error("Invalid token:", error);
    return <Navigate to="/login" />;
  }
};

export default PrivateRoute;
