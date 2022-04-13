import React, { useState,useEffect} from "react";
import mystore from "../../store";

function Checkout(){

    const [orders,setOrders]=useState({
        totalprice:"",
        paystatus:"",
        paymode:"",
        transid:"",
        orderstatus:"",
        sid:"",
        cid:"",
        orderdetails:[]
      });

      const user= JSON.parse(localStorage.getItem("loggedinuser"));
      const cartFromLocalStorage=JSON.parse(localStorage.getItem('cartItems')|| '[]');
      const[cartItems,setCartItem]=useState(cartFromLocalStorage);


    const submitData=(ev)=>{

        ev.preventDefault();
        
         alert(orders);
         const reqOptions = {
             method: 'POST',
             headers: {'Content-Type':'application/json'},
             body: JSON.stringify({
                
                 totalprice:orders.totalprice,
                 paystatus:"paid",
                 paymode:"online",
                 transid:109,
                 orderstatus:"pending",
                 sid:orders.sid,
                 cid:user.userid,
                // orderdetails:[pid,quantity,disprice]  
             })     
         }
         alert("inorders");
    
        /* fetch("http://localhost:8080/saveorders",reqOptions)
         .then(res=>res.json())
         .then(data=>setOrders({data}))*/
    
     }

        return(
            <div>
            <h1>Order Getting Confirmed.....  </h1>
           
            </div>      
        );

}
export default Checkout;