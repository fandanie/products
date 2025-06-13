import React, { useEffect, useState } from 'react';
import { products as mockProducts } from '../data/mockProducts';
import ProductCard from './ProductCard';
import SearchBar from "./SearchBar";

const ProductList = () => {
    const [products, setProducts] = useState([]);
    const [searchTerm, setSearchTerm] = useState('');

    useEffect(() => {
        // Aqui voy a simular la llamada al backend
        setProducts(mockProducts);
    }, []);

    return (
        <div className="product-list">
            <h2>Productos disponibles</h2>
            <SearchBar onSearch={setSearchTerm} />
            <div className="product-grid">
                {filterProducts.length > 0 ? (
                    filterProducts.map(product => (
                    <ProductCard key={product.id} product={product} />
                ))
                ) : (
                    <p>No hay productos que coincidan con tu búsqueda.</p>
                    )}
            </div>
        </div>
    );
};

export default ProductList;
