import React from "react";
import mystore from "../../store";

/*export default class Admin extends React.Component
{
    constructor(props)
    {
        super(props);
    }


    logout=()=>{
        mystore.dispatch({type:'LOGGEDOUT'});
        localStorage.removeItem("loggedinuser");
       // this.props.history.push("/");
        
    }


    render(){
        return (
            <div>
                <h1>Welcome{JSON.parse(localStorage.getItem("loggedinuser")).name} </h1>
                <h1>Admin Page</h1>
                <a href="/" onClick={this.logout}>Log Out</a>
           
        </div>            
        )
    }

}*/

function Admin(){


    const logout=()=>{
        mystore.dispatch({type:'LOGGEDOUT'});
        localStorage.removeItem("loggedinuser");
       // this.props.history.push("/");
        
    }

        return(
            <div>
            <h1>Welcome{JSON.parse(localStorage.getItem("loggedinuser")).name} </h1>
            <h1>Admin </h1>
          
            <a href="/admin/forgetpassword" class="btn btn-outline-primary">Change Password</a> {" "}

            <a href="/admin/updateaccount"class="btn btn-outline-info">Update Account</a>{" "}

            <a href="/admin/addseller"class="btn btn-outline-info">Add Seller</a>{" "}

            <a href="/admin/generatesalesreport"class="btn btn-outline-info">Generate Sales Reports</a>{" "}

            <a href="/admin/enabledisableaccount"class="btn btn-outline-info">Enable/Disable Account</a>{" "}
            
            <a href="/admin/addproducts"class="btn btn-outline-info">Add Products</a>{" "}

            <a href="/" class="btn btn-outline-danger" onClick={logout}>Log Out</a>
            </div>        
        );

}
export default Admin