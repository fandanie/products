import React, { useState } from 'react';
import './Checkout.css';
import { useNavigate } from "react-router-dom";
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const Checkout = ({ clearCart }) => {
    const navigate = useNavigate();

    const [formData, setFormData] = useState({
        nombre: '',
        direccion: '',
        tarjeta: ''
    });

    const handleChange = (e) => {
        setFormData(prev => ({
            ...prev,
            [e.target.name]: e.target.value
        }));
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        toast.success(`¡Gracias por tu compra, ${formData.nombre}!`);
        clearCart();
        setTimeout(() => {
            navigate('/cart');
        }, 3000);
    };

    return (
        <div className="checkout">
            <h2>Finalizar Compra</h2>
            <form onSubmit={handleSubmit}>
                <label>
                    Nombre:
                    <input type="text" name="nombre" value={formData.nombre} onChange={handleChange} required />
                </label>
                <label>
                    Dirección:
                    <input type="text" name="direccion" value={formData.direccion} onChange={handleChange} required />
                </label>
                <label>
                    Número de tarjeta:
                    <input type="text" name="tarjeta" value={formData.tarjeta} onChange={handleChange} required />
                </label>
                <button type="submit">Pagar</button>
            </form>
            <toastContainer position="top-center" autoClose={3000} />
        </div>
    );
};

export default Checkout;
