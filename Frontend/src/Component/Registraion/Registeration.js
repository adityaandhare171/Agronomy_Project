import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import LoginFooter from "../LoginFol/LoginFooter";
import LoginHeader from "../LoginFol/Navigation";


function Registration()
{
    let navigate=useNavigate();
    const [state,setState]=useState({
      fname:"",
      lname:"",
      pass:"",
      sec_ques:"",
      ans:"",
      email:"",
      contactno:"",
      address:""
    });
    const [Error, setError] = useState({
        loginerror:""

    });



    const handleChange=(ev)=>{

       setState((state)=>({
                ...state,
               [ev.target.name]:ev.target.value
        }));
    }

    const submitData=(ev)=>{
       ev.preventDefault();
        console.log(state);
        alert(state);
        const reqOptions = {
            method: 'POST',
            headers: {'Content-Type':'application/json'},
            body: JSON.stringify({
               
                fname: state.fname,
                lname: state.lname,
                pass: state.pass,
                sec_ques: state.sec_ques,
                ans: state.ans,
                email: state.email,
                contactno:state.contactno,
                address: state.address
               
            })
            
        }
        
        //alert("Connecting To db");
        //alert(state.email);
        //alert(state.ans);
        //alert(state.sec_ques);

        
        fetch("http://localhost:8080/registerc",reqOptions)
        .then(res=>res.json())
        .then(data=>setState({customer: data}))
      //  .then(resp => resp.text())
        //.then(data =>setState({msg: data}))

        alert(state.customer);

        if(state.customer!=="")
                navigate('/login');
        else
        setError({loginerror:"failed Registration!! Try Again"});

    }

    return(
        <div>
             <LoginHeader/>
             <h1>Registration Page</h1>
             <div style={{backgroundImage:"url(\regisimg.jpg)" }}>
        
        <form >
        <div class="form-group row">
                
                     <label class="col-sm-2 col-form-label">Enter first name no :</label>
                     <div className="form-group col-md-6">
                     <input type="text" className="form-control" name="fname" onChange={handleChange}
                   
                     /> 
                     </div>
                     </div>
                     
                    <br/>
                     <div class="form-group row">
                             <label class="col-sm-2 col-form-label">Enter last name :</label>
                             <div className="form-group col-md-6">
                            <input type="text" className="form-control" name="lname" onChange={handleChange} /> 
                    </div>
                    </div>

                    <br/>
                    <div class="form-group row">
                    
                        <label class="col-sm-2 col-form-label">Select  Security Question:</label> 
                        <div className="form-group col-md-6">
                            <select class="custom-select custom-select-lg mb-3" className="form-control" name="sec_ques" id="sec_ques" onChange={handleChange}>
                                    
                                <option value="What is favourite Pet Name?">What is favourite Pet Name?</option>
                                <option value="What is School Name from you passed 10th?">What is School Name from you passed 10th?</option>
                               <option value="Which is Favourite Sport?">Which is Favourite Sport ?</option>
                           </select> 
                    </div>
                    </div>
                    <br/>
                    <div class="form-group row">
                       <label class="col-sm-2 col-form-label"> Enter Answer:</label> 
                        <div className="form-group col-md-6">
                              <input type="text" className="form-control" name="ans" onChange={handleChange} />
                    </div>
                    </div>
                    <br/>
                    <div class="form-group row">
                      
                                 <label class="col-sm-2 col-form-label"> Enter Email:</label> 
                                 <div className="form-group col-md-6"> 
                                <input type="email" className="form-control" name="email"  onChange={handleChange} />
                     </div>
                     </div>
                     <br/>
                     <div class="form-group row">
                                <label class="col-sm-2 col-form-label"> Enter Contact no : </label> 
                                <div className="form-group col-md-6">
                                <input type="text" className="form-control" name="contactno" onChange={handleChange} /> 
                     </div>
                     </div>
                     <br/>

                     <div class="form-group row">
                     
                            <label class="col-sm-2 col-form-label"> Enter Address : </label>
                            <div className="form-group col-md-6"> 
                            <input type="textarea" className="form-control" name="address" onChange={handleChange} />
                     </div>
                     </div>
                     <br/>

                     <div class="form-group row">
                            <label  class="col-sm-2 col-form-label"> Enter password: </label>
                            <div className="form-group col-md-6"> 
                             <input type="password" className="form-control" name="pass" onChange={handleChange} />
                      </div>
                      </div>
                      <br/>
                      <div class="form-group col-md-6">
                            <input type="submit" class="btn btn-primary" value="Register" onClick={submitData} />
                    </div>
                    
        </form>
        <p style={{color:"red"}}>{Error.loginerror}</p>
        </div>
        <LoginFooter/>
    </div>
    );


}
export default Registration;