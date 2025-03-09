import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from "./Home";
import Login from "./Login";
import Register from "./Register";
import PrivateRoute from "./PrivateRoute";
import Admin_Only from "./Admin_Only";
import Navbar from "./Navbar";

const App = () => {
  return (
    <div>
      <Navbar/>
       <Routes>
        
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />

        <Route element={<PrivateRoute />}>
          <Route path="/admin" element={<Admin_Only />} />
        </Route>
      </Routes>
    </div>
     
  
  );
};

export default App;
