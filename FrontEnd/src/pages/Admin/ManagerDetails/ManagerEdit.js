import { useEffect,useState } from "react";
import { useLocation ,useNavigate,useParams} from "react-router-dom";
import axios from "axios";

const ManagerEdit=(props)=>{
    const param=useParams();
    console.log(param.id)
    const [mgrob,setmgrob]=useState({id:"",firstName:"",lastName:"",email:"",password:"",mobileNumber:""});
    //  const state=useLocation().state;
    // console.log(state.test)
    const navigate = useNavigate();

    
    useEffect(()=>{
        fetch('http://localhost:8080/manager/'+param.id,{
            method:"GET"
        })
        .then(resposne=> resposne.json())
        .then(res=>setmgrob(res))
        //   navigate("/managers");
    },[])
   
    // const updateData=()=>{
    //     fetch('http://localhost:8080/manager/'+mgrob.id,mgrob,{
    //         method:"PUT"
    //     })
    //     .then((result)=>{
    //         console.log(result.data);
    //         navigate("/managers");
    //     })
    //     .catch(()=>{})
    // }
    const updateData=()=>{
        axios.post('http://localhost:8080/manager/update',mgrob)
        .then((res)=>{console.log(res);
            navigate("/managers");
        }).catch((err)=>{console.log(err)})
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
    <label htmlFor="mobileNumber">Mobile Number</label>
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