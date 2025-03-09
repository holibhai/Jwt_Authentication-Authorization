import React from "react";
import ApiService from "./ApiService";

const Admin_Only = () => {
  const handleClick = async () => {
    const token = localStorage.getItem("token");
    if (!token) {
      alert("You must be logged in to access this page");
      return;
    }
    try {
      const response = await ApiService.admin();
      console.log("Admin response:", response);
      alert("Admin confirmed");
    } catch (e) {
      console.error("An error occurred:", e);
      alert("Unauthorized access");
    }
  };

  return (
    <div className="h-screen flex justify-center items-center bg-gray-100">
      <div className="bg-white shadow-lg rounded-lg p-6 text-center w-96">
        <h1 className="text-2xl font-semibold text-gray-800 mb-4">Admin Confirmation</h1>
        <button
          onClick={handleClick}
          className="bg-blue-600 hover:bg-blue-700 text-white font-semibold py-2 px-6 rounded-md transition-all duration-300"
        >
          Click to Check
        </button>
      </div>
    </div>
  );
};

export default Admin_Only;
