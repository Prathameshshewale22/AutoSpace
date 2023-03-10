import { useEffect,useState } from "react";
import axios from "axios";
import { Link ,useNavigate,useLocation,useParams} from "react-router-dom";
const AddManager=()=>{
    const [mgrob,setmgrob]=useState({id:"",firstName:"",lastName:"",email:"",password:"",mobileNumber:""});
    //get the history object
    const navigate = useNavigate();
    // const location = useLocation();
    //const {cid}=useLocation();
    const cid  = useParams();
    const addManager = () => {
    //   if (firstName.length === 0) {
    //     alert('select first name')
    //   } else if (lastName.length === 0) {
    //     alert('select last name')
    //   } else if (email.length === 0) {
    //     alert('Please Enter Email')
    //   } else {
    
        //send the data to API
        // fetch('http://localhost:8080/manager/'+cid.id,mgrob,{
        //     method:'POST'
        // })
        // .then((response) => {
        //     const result = response.data
        //     if (result.status === 'success') {
        //       alert('Successfully added Manager')
        //       navigate("/servicecenters");
        //     } else {
        //       alert('error while adding Manager')
        //     }
        // })
        // .catch(()=>{})
        
        axios.post('http://localhost:8080/manager/'+cid.id, mgrob).then((response) => {
          if (response.status === 200) {
            alert('Successfully added Manager')
            navigate("/servicecenters");
          } else {
            alert('error while adding Manager')
          }
        })
      
    }
    const handleChange=(event)=>{
        const {name,value}=event.target;
        setmgrob({...mgrob,[name]:value});
    }
    return (
        <div className="w-75 p-3 mx-auto shadow-sm p-3 mb-5 bg-body-tertiary rounded " >
        <h1 className="page-title">Add Manager</h1>
        <form>
  <div className="form-group">
    <label htmlFor="mgrid">Center Id</label>
    <input type="text" className="form-control" name="id" id="id" 
    value={cid.id}
    readOnly
   />
  </div>
  <div className="form-group">
    <label htmlFor="firstName">First Name</label>
    <input type="text" className="form-control" name="firstName" id="firstName"
     value={mgrob.firstName}
     onChange={handleChange}
     placeholder="Enter FirstName"/>
  </div>
  <div className="form-group">
    <label htmlFor="firstName">Last Name</label>
    <input type="text" className="form-control" name="lastName" id="lastName"
     value={mgrob.lastName}
     onChange={handleChange}
     placeholder="Enter lastName"/>
  </div>
  <div className="form-group">
    <label htmlFor="email">Email</label>
    <input type="text" className="form-control" name="email" id="email"
     value={mgrob.email}
     onChange={handleChange}
     placeholder="Enter Email"/>
  </div>
  <div className="form-group">
    <label htmlFor="email">Password</label>
    <input type="password" className="form-control" name="password" id="password"
     value={mgrob.password}
     onChange={handleChange}
     placeholder="Enter Password"/>
  </div>
  <div className="form-group">
    <label htmlFor="mobileNumber">Mobile Number</label>
    <input type="text" className="form-control" name="mobileNumber" id="mobileNumber"
     value={mgrob.mobileNumber}
     onChange={handleChange}
     placeholder="Enter MobileNumber"/>
  </div>
   <div className="mx-auto" >
  <button type="button" className="btn btn-primary" onClick={addManager} style={{align:"center"}}>Add Employee</button>
  &nbsp; &nbsp; &nbsp;  
  <Link to="/servicecenters">
          <a className="btn btn-warning" style={{align:"center"}}>Back</a>
    </Link>
    </div>
</form>
      </div>
    );
}

export default AddManager;