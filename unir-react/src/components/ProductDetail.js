import React, { useEffect, useState } from 'react';
import {useNavigate, useParams} from 'react-router-dom';
import axios from 'axios';
import './ProductDetail.css';
import { toast } from 'react-toastify';

const ProductDetail = ({addToCart}) => {
    const { id } = useParams();
    const navigate = useNavigate();
    const [product, setProduct] = useState(null);

    useEffect(() => {
        axios.get(`http://localhost:8081/api/products/${id}`)
            .then(response => setProduct(response.data))
            .catch(error => console.error('Error al obtener el producto:', error));
    }, [id]);

    const HandleToCart = () => {
        addToCart(product);
        toast.success('Producto agregado al carrito');
        setTimeout(() => {
            navigate('/cart');
        }, 1500);
    }

    if (!product) {
        return <p>Cargando producto...</p>;
    }

    return (
        <div className="product-detail">
            <img src={product.imageUrl} alt={product.name} className="detail-image" />
            <h2>{product.name}</h2>
            <p><strong>Marca:</strong> {product.company}</p>
            <p><strong>Descripción:</strong> {product.longDescription}</p>
            <p><strong>Precio:</strong> ${product.price}</p>
            <p><strong>Stock disponible:</strong> {product.stock}</p>

            <button onClick={() => addToCart(product)}>
                Agregar al carrito
            </button>
        </div>
    );
};

export default ProductDetail;
