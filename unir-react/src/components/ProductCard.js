import React from 'react';
import './ProductCard.css';
import { Link } from 'react-router-dom';

const ProductCard = ({ product, addToCart }) => {
    return (
        <div className="product-card">
            <Link to={`/products/${product.id}`}>
                {product.imageUrl && (
                    <img src={product.imageUrl} alt={product.name} className="product-image" />
                )}
                <h3>{product.name}</h3>
            </Link>
            <p><strong>Marca:</strong> {product.company}</p>
            <p>{product.shortDescription}</p>
            <p><strong>precio:</strong> ${product.price}</p>
            <p><strong>Stock:</strong> {product.stock}</p>
            <button onClick={() => addToCart(product)}>Agregar al carrito</button>
        </div>
    );
};

export default ProductCard;
