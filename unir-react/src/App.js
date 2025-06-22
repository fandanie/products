import React, {useState, useEffect} from "react";
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Navbar from "./components/Navbar";
import ProductList from "./components/ProductList";
import Cart from "./components/Cart";
import Checkout from "./components/Checkout";
import Footer from "./components/Footer";
import useLocalStorage from "./hooks/useLocalStorage";
import './components/Header.css';
import './components/ProductList.css'
import './components/ProductCard.css'
import axios from "axios";
import Home from "./components/Home";
import ProductDetail from "./components/ProductDetail";
import {toast, ToastContainer} from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';


function App() {
    const [products, setProducts] = useState([]);
    const [cart, setCart] = useLocalStorage('cart', []);
    const removeFromCart = (indexToRemove) => {
        setCart(prevCart => prevCart.filter((_, index) => index !== indexToRemove));
    };


    //obtenciond de los productos desde mi back-end
    useEffect(() => {
        axios.get('http://localhost:8081/api/products')
            .then(response => setProducts(response.data))
            .catch(error => console.error('Error al obtener los productos: ', error));
    }, []);

    const addToCart = (product) => {
        setCart([...cart, product]);
        toast.success('Producto agregado al carrito');
    };
  return (
      <Router>
        <Navbar />
        <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/checkout" element={<Checkout clearCart={() => setCart([])} />} />
            <Route path="/products" element={<ProductList products={products} addToCart={addToCart} />} />
            <Route path="/cart" element={<Cart cart={cart} removeFromCart={removeFromCart} />} />
            <Route
                path="/products/:id"
                element={<ProductDetail addToCart={addToCart} />}
            />

        </Routes>
        <Footer />
          <ToastContainer position="top-right" autoClose={2000} hideProgressBar />
      </Router>
  );
}

export default App;
