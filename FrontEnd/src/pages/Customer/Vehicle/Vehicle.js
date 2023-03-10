import React from "react";
import { useState ,useEffect} from "react"
import { Link } from "react-router-dom"
import {PenFill,Trash} from 'react-bootstrap-icons';
import "./vehicle.css"
// import ManagerRow from "./ManagerRow";
// import ManagerEdit from './ManagerEdit';
const Vehicle=()=>{
        const [vehicles, setVehicles] = useState([]);
        let [flag,setflag]=useState(false);
        useEffect( () =>{
            fetch('http://localhost:8080/vehicle/1',{
                method:"GET"
            })
            .then(res => res.json())
            .then(data => setVehicles(data))
        }, [])
    useEffect( () =>{
        fetch('http://localhost:8080/vehicle/1',{
            method:"GET"
        })
        .then(res => res.json())
        .then(data => setVehicles(data))
    }, [flag])

    const deleteData=(id)=>{
        fetch('http://localhost:8080/vehicle/'+id,{
            method:"DELETE"
        })
        .then((result)=>{
            console.log(result.data);
           // history.push("/");
           setflag(true);
        })
        .catch((err)=>{
            console.log("error occured",err);
        })
    
    }
    
    return (
        <>
        <div className="mx-auto" style={{align:"center"}} >
        <h1 className="page-title" align="center">Vehicles</h1>
        </div>
        <div className="w-75 p-3 mx-auto shadow-sm p-3 mb-5 bg-body-tertiary rounded " >
    <table className="table table-striped border-top">
        <thead>
            <tr>
            <th>Id</th>
            <th>Vehicle Number</th>
            <th>Company</th>
            <th>Model</th>
            {/* <th>MobileNo</th>
            <th>Edit</th>
            <th>Remove</th> */}
            </tr>
        </thead>
        <tbody>
            {vehicles.map((vehicle)=> {
                 return (
                    <tr>
                        <td>{vehicle.id}</td>
                        <td>{vehicle.vehicleNumber}</td>
                        <td>{vehicle.company}</td>
                        <td>{vehicle.model}</td>
                        {/* <td>{manager.mobileNumber}</td> */}
                        <td> 
                        
                        <Link to={{pathname:`/edit/${vehicle.id}`}} state={{test: 'test'}}>
                     <PenFill></PenFill>
                        </Link>
                    </td>
                    <td>
                    <button type="button" className="btn btn-danger" name='btn' id="delete" onClick={()=>deleteData(vehicle.id)}><Trash></Trash></button>
                    </td>
                    </tr>
    
       )
            })}
            <Link to="/customerdashboard">BACK</Link>
        </tbody>
    </table>
    </div>
   
        </>
    );
};
export default Vehicle;