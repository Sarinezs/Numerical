import React from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import {  Route, Routes,BrowserRouter } from "react-router-dom";
import Bisection from "./Bisection";

function App() {
  return (
    <div >

    <BrowserRouter>
    <Routes>

      <Route path="/Bisection" element={<Bisection />} />
      

    </Routes>
  </BrowserRouter>
  </div>
  );
}

export default App;