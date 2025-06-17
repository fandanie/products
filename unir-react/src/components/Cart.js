import React from 'react';
import { Link } from 'react-router-dom';
import useLocalStorage from '../hooks/useLocalStorage';

const Cart = ({ cart = [], removeFromCart }) => {
    const total  = cart.reduce((sum, item) => sum + item.price, 0);
    return (
        <div className={"cart"}>
            <h2>Tu Carrito</h2>
            {cart.length === 0 ? (
                <p>No hay productos en tu carrito.</p>
            ) : (
              <>
                  <ul>
                      {cart.map((item, index) => (
                          <li key={index} style={{ marginBottom: '1rem'}}>
                            <strong>{item.name}</strong> - ${item.price.toFixed(2)}
                            <button
                                onClick={() => removeFromCart(index)}
                                style={{
                                    marginLeft: '1rem',
                                    color: 'white',
                                    backgroundColor: 'red',
                                    border: 'none',
                                    padding: '5px 10px',
                                    cursor: 'pointer',
                                    borderRadius: '5px'
                                }}

                            >
                              Eliminar
                            </button>
                          </li>
                      ))}
                  </ul>

                  <h3>Total: ${total.toFixed(2)}</h3>

                  <div style={{ marginTop: '20px'}}>
                      <Link to="/checkout">
                          <button
                            style={{
                             padding: '10px 20px',
                             backgroundColor: 'green',
                             color: 'white',
                             border: 'none',
                             borderRadius: '5px',
                             fontweight: 'bold',
                                cursor: 'pointer'
                            }}
                          >
                              Finalizar Compra
                          </button>
                      </Link>
                  </div>
              </>
            )}
        </div>
    );
};

export default Cart;
