
import React, { useState,useEffect } from "react";
import mystore from "../../store";

import GoTocart from "../CartFol/Gotocart";



function GetProducts(){


    const[prod,setProd]=useState([]);

    
   /* useEffect(()=>{
        //real url developed using express
      //  e.preventDefault();
        alert("IN Fetch")
        fetch("http://localhost:8080/allproducts")
        .then(r => r.json())
      .then(d =>setProd([...prod,d]))
      //alert(prod.size());
      //alert(prod);    
    },[]);*/
    


    useEffect(() => {
        const fetchData = async () => {
          const response = await fetch('http://localhost:8080/allproducts');
          const newData = await response.json();
          setProd(newData);
        };
        fetchData();
      }, [prod]);   


    const cartFromLocalStorage=JSON.parse(localStorage.getItem('cartItems')|| '[]');
    const[cartItems,setCartItem]=useState(cartFromLocalStorage);
      

     useEffect(()=> {
        localStorage.setItem("cartItems",JSON.stringify(cartItems));
      },[cartItems]);
      
     // localStorage.setItem("allproducts",JSON.stringify(prod));
    
   
   const addtocart=(v)=>{
    // console.log(v);
      //setCartItem([...cartItems,{...v}]);
     //localStorage.setItem("cartItems",JSON.stringify(v));

    let newCart=[...cartItems];
    let itemInCart=newCart.find(
      (item)=>v.prodname===item.prodname
    );

    if(itemInCart){
      itemInCart.quantity++;

    }
    else{
      itemInCart={
        ...v,
        quantity:1,
      };
      newCart.push(itemInCart);
    }
    setCartItem(newCart);
  };

  const getCartTotal=()=>{
    return cartItems.reduce((sum,{quantity})=>sum+quantity,0);
  };

 

  const clearCart=()=>{
    setCartItem([]);
};

        return(
            <div>
                    <h1>Products Page</h1>
                      
                     <div class="iconShoping">
                   
                    <button><a href="/gotocart">viewCart({getCartTotal()})</a></button> &nbsp; &nbsp; &nbsp; &nbsp; 
                    </div>
                    <table className="table">
                    <tr>
                        <th> Product Name  </th>
                        
                        <th> Company Name  </th>
                        <th> Var Model </th>
                        <th> Quantity </th>
                        <th> Description  </th>
                        <th> Price  </th>

                    </tr>
                   
                    {
                        prod.map((v)=>{
                            return(
                             
                                <tr>
                                   <td>{v.prodid}</td> 
                                   
                                   <td>{v.prodname}</td> 
                                   <td>{v.compname}</td>
                                   <td>{v.varmodel}</td>
                                   <td> Rs.{v.price} </td> 
                                  
                                   <td>{v.quantity}</td>
                                   <td>
                                   
                                   <form>
                                           <button onClick={()=>addtocart(v)}>AddToCart</button>
                                   </form>
                                   </td>
                                </tr>
                                
                            )
                        })
                    }
                </table>
              {/* <GoTocart 
               clearCart={clearCart}
               cartItems={cartItems} setCartItem={setCartItem}/>*/}

         
            </div>      
        );

}
export default GetProducts;