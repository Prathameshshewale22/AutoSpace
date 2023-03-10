import { useEffect,useState } from "react";
import axios from "axios";
import { Link ,useNavigate,useLocation,useParams} from "react-router-dom";
import "./ServiceManage.css"
const AddService=()=>{
    const [serviceObj,setServiceObj]=useState({serviceName:"",description:"",estimatedTime:"",estimatedCost:""});
    //get the history object
    const navigate = useNavigate();
  
    const addService = () => {
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
        
        axios.post('http://localhost:8080/service/', serviceObj).then((response) => {
        //   const result = response.data
          if (response.status === 200) {
            alert('Successfully added Service')
            navigate("/services");
          } else {
            alert('error while adding Service')
          }
        })
      
    }
    const handleChange=(event)=>{
        const {name,value}=event.target;
        setServiceObj({...serviceObj,[name]:value});
    }
    return (
        <div className="w-75 p-3 mx-auto shadow-sm p-3 mb-5 bg-body-tertiary rounded " >
        <h1 className="page-title" id="demo">Add Service</h1>
        <form>
  <div className="form-group">
    <label htmlFor="serviceName">Service Name</label>
    <input type="text" className="form-control" name="serviceName" id="serviceName"
     value={serviceObj.serviceName}
     onChange={handleChange}
     placeholder="Enter Service"/>
  </div>
  <div className="form-group">
    <label htmlFor="description">Description</label>
    <input type="text" className="form-control" name="description" id="description"
     value={serviceObj.description}
     onChange={handleChange}
     placeholder="Enter Description"/>
  </div>
  <div className="form-group">
    <label htmlFor="estimatedTime">Estimatedtime</label>
    <input type="text" className="form-control" name="estimatedTime" id="estimatedTime"
     value={serviceObj.estimatedTime}
     onChange={handleChange}
     placeholder="Enter Estimatedtime"/>
  </div>
  <div className="form-group">
    <label htmlFor="estimatedCost">Estimatedcost</label>
    <input type="text" className="form-control" name="estimatedCost" id="estimatedCost"
     value={serviceObj.estimatedCost}
     onChange={handleChange}
     placeholder="Enter Estimatedcost"/>
  </div>
   <div id="demo" >
  <button type="button" className="btn btn-primary" onClick={addService} style={{align:"center"}}>Add Service</button>
  &nbsp; &nbsp; &nbsp;  
  <Link to="/services">
          <a className="btn btn-warning" style={{align:"center"}}>Back</a>
    </Link>
    </div>
</form>
      </div>
    );
}

export default AddService;