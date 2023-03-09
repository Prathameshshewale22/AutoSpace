import { useEffect,useState } from "react";
import { useLocation ,useNavigate} from "react-router-dom";

const ManagerEdit=()=>{
     
    const [mgrob,setmgrob]=useState({id:"",firstName:"",lastName:"",email:"",password:"",mobileNumber:""});
     let data=useLocation().state;
    
    const navigate = useNavigate();

    
    useEffect(()=>{
        setmgrob({...data.managerdata})
    },[])
   
    const updateData=()=>{
        fetch('http://localhost:8080/manager/'+mgrob.id,mgrob,{
            method:"PUT"
        })
        .then((result)=>{
            console.log(result.data);
            navigate("/managers");
        })
        .catch(()=>{})
    }
    const handleChange=(event)=>{
        const {name,value}=event.target;
        setmgrob({...mgrob,[name]:value});
        console.log(mgrob.id)
    }
    return(
        <div>
 <form>
  <div className="form-group">
    <label htmlFor="mgrid">Manager Id</label>
    <input type="text" className="form-control" name="id" id="id" 
    value={mgrob.id}
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
    <label htmlFor="mobileNumber">Email</label>
    <input type="text" className="form-control" name="mobileNumber" id="mobileNumber"
     value={mgrob.mobileNumber}
     onChange={handleChange}
     placeholder="Enter MobileNumber"/>
  </div>
  <button type="button" class="btn btn-primary" onClick={updateData}>update Employee</button>
</form>
        </div>
        
    )
}

export default ManagerEdit;