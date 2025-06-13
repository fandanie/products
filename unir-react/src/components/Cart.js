import React, { useState } from 'react';

const Cart = () => {
    // Simulación de productos en el carrito
    const [cartItems, setCartItems] = useState([
        {
            id: 1,
            name: "Camiseta React",
            price: 19.99,
            quantity: 2
        },
        {
            id: 2,
            name: "Taza JavaScript",
            price: 12.99,
            quantity: 1
        }
    ]);

    const total = cartItems.reduce((sum, item) => sum + item.price * item.quantity, 0);

    return (
        <div className="cart">
            <h2>Carrito de Compras</h2>
            {cartItems.length === 0 ? (
                <p>Tu carrito está vacío.</p>
            ) : (
                <ul>
                    {cartItems.map(item => (
                        <li key={item.id}>
                            {item.name} - ${item.price} x {item.quantity}
                        </li>
                    ))}
                </ul>
            )}
            <h3>Total: ${total.toFixed(2)}</h3>
        </div>
    );
};

export default Cart;
