import React from "react";
import Admin from "./AdminFol/AdminHome";
import LoginForm from "./LoginFol/Login";
import mystore from "../store";
import Registration from "./Registraion/Registeration";
import Customer from "./CustomerFol/CustomerHome";
import Seller from "./SellerFol/Seller";
import { BrowserRouter, Link, Route, Routes } from "react-router-dom";
import GetProducts from "./CustomerFol/GetProducts";
import Announcement from "./MainMenuStyle/Annoncement";
import Slider from "./MainMenuStyle/Slider";


export default class MainMenu extends React.Component
{
    constructor(props){
        super(props)
             this.state={
                flag:false
            }
    }


    render(){
        mystore.subscribe(()=>{this.setState({flag:mystore.getState().loggedin})})
            return (
                

                <div>
                    <Announcement/>
                    
                     <h1 style={{color:"green"}}> Welcome To Agronomy</h1>
                    
               
            
              
                      <div style={{display:this.state.flag?'none':'block'}}>
                     <nav className="nav nav-tabs">
                        
                         <Link className="nav-link" to="/login"> Login </Link>  |{"   "}
                         <Link  className="nav-link" to="/register"> Register </Link>  
                     
                       
                        </nav>
                     <div>
                        <Routes>
                                <Route path="/login" element={<LoginForm/>}/>
                                 <Route  path="/register" element={<Registration/>}/>  
                        </Routes>
                        </div>
                       
                    </div>

                    <Slider/>

             </div>
                   
            )
        
    }
        
}