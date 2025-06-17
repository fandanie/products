import React from 'react';
import './ProductCard.css';
import { Link } from 'react-router-dom';

const ProductCard = ({ product, addToCart }) => {
    return (
        <div className="product-card">
            <h3>{product.name}</h3>
            <p><strong>${product.price}</strong></p>
            <button onClick={() => addToCart(product)}>Agregar al carrito</button>
        </div>
    );
};

export default ProductCard;
