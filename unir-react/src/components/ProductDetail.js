import React from 'react';
import { useParams } from 'react-router-dom';
import { products } from '../data/mockProducts';


const ProductDetail = () => {
    const { id } = useParams();
    const product = products.find(p => p.id === parseInt(id));

    if (!product) {
        return <h2>Producto no encontrado</h2>;
    }

    return (
        <div className="product-detail">
            <h2>{product.name}</h2>
            <p><strong>Precio:</strong> ${product.price}</p>
        </div>
    );
};

export default ProductDetail;
