import React, {useState, useEffect} from "react";
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Navbar from "./components/Navbar";
import ProductList from "./components/ProductList";
import ProductDetail from "./components/ProductDetail";
import Cart from "./components/Cart";
import Checkout from "./components/Checkout";
import AdminPanel from "./components/AdminPanel";
import Footer from "./components/Footer";
import useLocalStorage from "./hooks/useLocalStorage";
import './components/Header.css';
import './components/ProductList.css';
import './components/ProductCard.css'
import axios from "axios";


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
    };
  return (
      <Router>
        <Navbar />
        <Routes>
            <Route path="/" element={<h2>Bienvenido a la tienda</h2>}/>
            <Route path="/products/:id" element={<ProductDetail />} />
            <Route path="/checkout" element={<Checkout />} />
            <Route path="/admin" element={<AdminPanel />} />
            <Route path="/products" element={<ProductList products={products} addToCart={addToCart} />} />
            <Route path="/cart" element={<Cart cart={cart} removeFromCart={removeFromCart} />} />
        </Routes>
        <Footer />
      </Router>
  );
}

export default App;
