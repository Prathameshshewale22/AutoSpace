
import {useEffect,useState} from 'react';
import Home from '../../Home/Home/Home';
 
const Dashboard = () => {
   
   const[record,setRecord] = useState([])
   const[service,setService] = useState([])
 
   const getData = () =>
   {
       fetch('http://localhost:8080/admin/dashboard/counts',{method:"GET",credentials:'include'})
       .then(resposne=> resposne.json())
       .then(res=>setRecord(res))
   }
 
   useEffect(() => {
      getData();
      getServices();
   },[])

   const getServices=()=>{
    fetch('http://localhost:8080/service',{method:"GET"})
    .then(resposne=> resposne.json())
    .then(res=>setService(res))
   }
    
 
    return (
    <div className="col main pt-5 mt-3">
         <Home></Home>
    </div>
    )
}
 
export default Dashboard;