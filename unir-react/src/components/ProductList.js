import React, { useEffect, useState } from 'react';
import ProductCard from './ProductCard';
import SearchBar from "./SearchBar";
import './ProductList.css';

const ProductList = ({products, addToCart}) => {
    const [searchTerm, setSearchTerm] = useState('');
    const filterProducts = products.filter(product =>
        product.name.toLowerCase().includes(searchTerm.toLowerCase()));

    if (!products || products.length === 0) {
        return (
            <div className="spinner">
                <div></div>
            </div>
        );
    }

    return (
        <div className="product-list">
            <h2>Productos disponibles</h2>
            <SearchBar onSearch={setSearchTerm} />
            <div className="product-grid">
                {filterProducts.length > 0 ? (
                    filterProducts.map(product => (
                    <ProductCard key={product.id} product={product} addToCart={addToCart} />
                ))
                ) : (
                    <p>No hay productos que coincidan con tu búsqueda.</p>
                    )}
            </div>
        </div>
    );
};

export default ProductList;
