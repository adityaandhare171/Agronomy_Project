import React from "react";
import mystore from "../../store";

function Seller(){


    const logout=()=>{
        mystore.dispatch({type:'LOGGEDOUT'});
        localStorage.removeItem("loggedinuser");
       // this.props.history.push("/");
    }

        return(
            <div>
            <h1>Welcome{JSON.parse(localStorage.getItem("loggedinuser")).name} </h1>
            <h1>Seller Page</h1>
            <a href="/seller/updateaccount" class="btn btn-outline-primary">Update Account</a>{" "}

            <a href="/seller/managecatalogue" class="btn btn-outline-primary">Manage Product Catalogue</a>{" "}

            <a href="/seller/confirmorder" class="btn btn-outline-primary">Confirm Order</a>{" "}

            <a href="/seller/giverefund" class="btn btn-outline-primary">Give Refund</a>{" "}

            <a href="/seller/afterassist" class="btn btn-outline-primary">After Assist</a>{" "}

            <a href="/" class="btn btn-outline-danger"  onClick={logout}>Log Out</a>{" "}
            
            </div>      
        );

}
export default Seller;