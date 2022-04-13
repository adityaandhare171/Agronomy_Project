import React from "react";
import mystore from "../../store";
import CustomerFooter from "./CustomerFooter";



import GetProducts from "./GetProducts";

function Customer(){


    const logout=()=>{
        mystore.dispatch({type:'LOGGEDOUT'});
        localStorage.removeItem("loggedinuser");
       // this.props.history.push("/");   
    }

        return(
            <div>
                <div>
            <h1>Welcome{JSON.parse(localStorage.getItem("loggedinuser")).name} </h1>
            <h1>Customer Page</h1>
            <a href="/Customer/updateaccount" class="btn btn-outline-primary">Update Account</a>  {" "}
            
            <a href="/Searchproduct" class="btn btn-outline-primary">Search product</a>{" "}

            <a href="/Customer/Check Order Status" class="btn btn-outline-primary">Check Order Status </a>{" "}

            <a href="/Customer/Request For Assistance"class="btn btn-outline-primary">Request For Assistance</a>{" "}

            <a href="/Customer/Generate Refund Request" class="btn btn-outline-primary">Generate Refund Request</a>{" "}

            <a href="/Customer/Give Feedback" class="btn btn-outline-primary">Give Feedback</a>{" "}

            <a href="/" class="btn btn-outline-danger" onClick={logout}>Log Out</a>
            </div>
           
          <GetProducts/>

            <div><CustomerFooter/></div>
         
        </div>        


        );

}
export default Customer