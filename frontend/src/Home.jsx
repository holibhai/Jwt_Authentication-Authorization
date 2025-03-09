import React from "react";
import { NavLink } from "react-router-dom";

const Home = () => {
  return (
    <div className="h-screen flex flex-col justify-center items-center">
      <div className="text-center">
        <h1 className="text-5xl font-extrabold animate-fade-in">
          User Management System
        </h1>
        <p className="mt-3 text-lg opacity-90">
          Secure JWT Authentication & Authorization
        </p>
        
        
        <div className="mt-6 flex gap-4 justify-center">
          <NavLink 
            to="/register" 
            className="bg-green-500 hover:bg-green-600 px-6 py-2 rounded-lg shadow-md transition duration-300"
          >
            Get Started
          </NavLink>
          <NavLink 
            to="/login" 
            className="bg-blue-500 hover:bg-blue-600 px-6 py-2 rounded-lg shadow-md transition duration-300"
          >
            Login
          </NavLink>
        </div>
      </div>
    </div>
  );
};

export default Home;
