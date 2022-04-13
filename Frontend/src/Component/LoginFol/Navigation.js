import React, {Component} from "react";
import { BrowserRouter as Router, Route , Switch } from 'react-router-dom';

function LoginHeader(){

    return(

        <header style={{backgroundColor:"teal"}}>
        <div class="container px-1 px-lg-1 my-1">
            <div class="text-center text-white">
                <h1 class="display-4 fw-bolder" style={{color:"black"}}>AGRONOMY</h1>
                <p class="lead fw-normal text-white-50 mb-0">Agroproducts shopping system</p>
            </div>
        </div>
    </header>



               

);

}
export default LoginHeader;