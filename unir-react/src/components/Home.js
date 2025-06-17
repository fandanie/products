import React from 'react';
import './Home.css';
import bannerImage from '../assets/img1.jpg';

function Home() {
    return (
        <div className="home-container">
            <img src={bannerImage} alt="Bienvenido a Tienda React" className="banner" />
            <div className="home-content">
                <h1>Bienvenid@ a Mi Techno-Centro</h1>
                <p>Explora nuestros productos y disfruta de una experiencia de compra sencilla y rápida.</p>
                <a href="/products" className="btn-primary">Ver productos</a>
            </div>
        </div>
    );
}

export default Home;
