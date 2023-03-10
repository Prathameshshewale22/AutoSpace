import { useEffect,useState } from "react";
import axios from "axios";
import { Link ,useNavigate,useLocation,useParams} from "react-router-dom";
import "./DiliveryBoy.css"
const AddDeliveryBoy=()=>{
    const [dbob,setDbob]=useState({id:"",firstName:"",lastName:"",email:"",password:"",mobileNumber:""});
    //get the history object
    const navigate = useNavigate();
    // const location = useLocation();
    //const {cid}=useLocation();
    const cid  = useParams();
    const addDboy = () => {
   
    
        axios.post('http://localhost:8080/deliveryboy/'+cid.id, dbob).then((response) => {
          if (response.status === 200) {
            alert('Successfully added ')
            navigate("/dboys");
          } else {
            alert('error while adding')
          }
        })
      
    }
    const handleChange=(event)=>{
        const {name,value}=event.target;
        setDbob({...dbob,[name]:value});
    }
    return (
        <div className="w-50 p-3 mx-auto shadow-sm p-3 mb-5 bg-body-tertiary rounded " >
        <h1 className="page-title" id="demo">Add DeliveryBoy</h1>
        <form>
  <div className="form-group">
    <label htmlFor="centerid">Center Id</label>
    <input type="text" className="form-control" name="id" id="id" 
    value={cid.id}
    readOnly
   />
  </div>
  <div className="form-group">
    <label htmlFor="firstName">First Name</label>
    <input type="text" className="form-control" name="firstName" id="firstName"
     value={dbob.firstName}
     onChange={handleChange}
     placeholder="Enter FirstName"/>
  </div>
  <div className="form-group">
    <label htmlFor="firstName">Last Name</label>
    <input type="text" className="form-control" name="lastName" id="lastName"
     value={dbob.lastName}
     onChange={handleChange}
     placeholder="Enter lastName"/>
  </div>
  <div className="form-group">
    <label htmlFor="email">Email</label>
    <input type="text" className="form-control" name="email" id="email"
     value={dbob.email}
     onChange={handleChange}
     placeholder="Enter Email"/>
  </div>
  <div className="form-group">
    <label htmlFor="email">Password</label>
    <input type="password" className="form-control" name="password" id="password"
     value={dbob.password}
     onChange={handleChange}
     placeholder="Enter Password"/>
  </div>
  <div className="form-group">
    <label htmlFor="mobileNumber">Mobile Number</label>
    <input type="text" className="form-control" name="mobileNumber" id="mobileNumber"
     value={dbob.mobileNumber}
     onChange={handleChange}
     placeholder="Enter MobileNumber"/>
  </div>
   <div className="mx-auto" id="demo">
  <button type="button" className="btn btn-primary" onClick={addDboy} style={{align:"center"}}>Add</button>
  &nbsp; &nbsp; &nbsp;  
  <Link to="/dboys">
          <a className="btn btn-warning" style={{align:"center"}}>Back</a>
    </Link>
    </div>
</form>
      </div>
    );
}

export default AddDeliveryBoy;