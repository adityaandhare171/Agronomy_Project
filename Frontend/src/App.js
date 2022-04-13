import logo from './logo.svg';
import './App.css';
import Login from './Component/LoginFol/Login';
import Seller from './Component/SellerFol/Seller';
import Customer from './Component/CustomerFol/CustomerHome';
import Admin from './Component/AdminFol/AdminHome';
import MainMenu from './Component/MainMenu';

import LoginForm from './Component/LoginFol/Login';
import { BrowserRouter, Link, Route, Routes } from 'react-router-dom';
import Registration from './Component/Registraion/Registeration';

import GoTocart from './Component/CartFol/Gotocart';
import Checkout from './Component/OrdersFol/Checkout';
import SearchProduct from './Component/CustomerFol/SearchProduct';






function App() {
  return (
    <div className="App">
     
 
    
   <BrowserRouter>
    <nav>
   

    </nav>
     <Routes>         
           <Route exact path="/" element={<MainMenu/>} />   
           <Route path="/login" element={<LoginForm/>}/>
          <Route  path="/register" element={<Registration/>}/>
          <Route path="/adminhome" element={<Admin/>}/>
          <Route  path="/customerhome" element={<Customer/>}/>
          <Route path="/sellerhome" element={<Seller/>}/> 
           
          <Route path="/gotocart" element={<GoTocart/>}/>    
          <Route path="/checkout" element={<Checkout/>}/>  
          <Route path="/searchproduct" element={<SearchProduct/>}/>  
            
  </Routes>  
  </BrowserRouter>

  {/*  <Registration/>*/}
    </div>
  );
}

export default App;
