import React, { useEffect, useState } from 'react';
import { products as mockProducts } from '../data/mockProducts';
import ProductCard from './ProductCard';

const ProductList = () => {
    const [products, setProducts] = useState([]);

    useEffect(() => {
        // Aqui voy a simular la llamada al backend
        setProducts(mockProducts);
    }, []);

    return (
        <div className="product-list">
            <h2>Productos disponibles</h2>
            <div className="product-grid">
                {products.map(product => (
                    <ProductCard key={product.id} product={product} />
                ))}
            </div>
        </div>
    );
};

export default ProductList;
