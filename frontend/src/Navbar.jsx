import React, { useState, useEffect } from 'react';
import { NavLink, useNavigate } from 'react-router-dom';

const Navbar = () => {
    const [isLoggedIn, setIsLoggedIn] = useState(false);
    const navigate = useNavigate();

    
    useEffect(() => {
        const token = localStorage.getItem('token');
        if (token){
            setIsLoggedIn(true);
        }
        else{
            setIsLoggedIn(false);
        }
    }, [isLoggedIn]);

    const handleLogout = () => {
        localStorage.removeItem('token');
        localStorage.removeItem('role');
        alert("You have been logged out");
        setIsLoggedIn(false);
        navigate('/');
    };

    return (
        <div className='flex justify-center bg-gray-800 p-4 shadow-md'>
            <ul className='flex justify-between items-center gap-10 text-white cursor-pointer'>
                <li><NavLink to="/" className="hover:text-gray-300">Home</NavLink></li>
                
                {!isLoggedIn && (
                    <li><NavLink to="/login" className="hover:text-gray-300">Login</NavLink></li>
                )}
                
                <li><NavLink to="/register" className="hover:text-gray-300">Register</NavLink></li>
                
                {isLoggedIn && (
                    <li onClick={handleLogout} className="hover:text-red-400 cursor-pointer">Logout</li>
                )}

                <li><NavLink to="/admin" className="hover:text-gray-300">Admin</NavLink></li>
            </ul>
        </div>
    );
};

export default Navbar;
