import React from "react";
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Navbar from "./components/Navbar";
import Home from './components/Home'
import ProductList from "./components/ProductList";
import ProductDetail from "./components/ProductDetail";

function App() {
  return (
      <Router>
        <Navbar />
        <Routes>
          {}
          <Route path="/" element={<h2>Bienvenido a la tienda</h2>}/>
            <Route path="/" element={<Home/>} />
            <Route path="/products" element={<ProductList/>} />
            <Route path="/products/:id" element={<ProductDetail/>} />
        </Routes>
      </Router>
  );
}

export default App;
