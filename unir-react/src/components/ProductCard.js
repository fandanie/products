import React from 'react';
import { Link } from 'react-router-dom';

const ProductCard = ({ product }) => {
    return (
        <div className="product-card">
            <img src={product.image} alt={product.name} />
            <h3>{product.name}</h3>
            <p>{product.shortDescription}</p>
            <p><strong>${product.price}</strong></p>
            <Link to={`/product/${product.id}`}>Ver más</Link>
        </div>
    );
};

export default ProductCard;
