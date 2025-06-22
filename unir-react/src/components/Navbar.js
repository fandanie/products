import React from 'react';
import { Link } from 'react-router-dom';
import './Navbar.css';

const Navbar = () => {
    return (
        <nav className="navbar">
            <h1>Tienda Mi Techno-Centro</h1>
            <ul>
                <li><Link to="/">Inicio</Link></li>
                <li><Link to="/products">Productos</Link></li>
                <li><Link to="/cart">Carrito</Link></li>

            </ul>
        </nav>
    );
};

export default Navbar;
