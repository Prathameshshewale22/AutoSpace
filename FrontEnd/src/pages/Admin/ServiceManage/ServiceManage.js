import React from "react";
import { useState ,useEffect} from "react"
import { Link } from "react-router-dom"
import {PenFill,Trash,PersonPlusFill} from 'react-bootstrap-icons';
import "./ServiceManage.css"
const ServiceManage=()=>{
        const [services, setServices] = useState([]);
        let [flag,setflag]=useState(false);
        useEffect( () =>{
            fetch('http://localhost:8080/service',{
                method:"GET"
            })
            .then(res => res.json())
            .then(data => setServices(data))
        }, [])
    useEffect( () =>{
        fetch('http://localhost:8080/service',{
            method:"GET"
        })
        .then(res => res.json())
        .then(data => setServices(data))
    }, [flag])

    const deleteData=(id)=>{
        fetch('http://localhost:8080/service/'+id,{
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
        <h1 className="page-title" id="demo">Services</h1>
        </div>
        <div className="w-75 p-3 mx-auto shadow-sm p-3 mb-5 bg-body-tertiary rounded " >
    <table className="table table-striped border-top">
        <thead>
            <tr>
            <th>Id</th>
            <th>serviceName</th>
            <th>description</th>
            <th>estimatedTime</th>
            <th>estimatedCost</th>
            <th>Edit</th>
            <th>Remove</th>
            </tr>
        </thead>
        <tbody>
            {services.map((service)=> {
                 return (
                    <tr>
                        <td>{service.id}</td>
                        <td>{service.serviceName}</td>
                        <td>{service.description}</td>
                        <td>{service.estimatedTime}</td>
                        <td>{service.estimatedCost}</td>
                        <td> 
                        
                        <Link to={{pathname:`/edit/${service.id}`}} >
                     <PenFill></PenFill>
                        </Link>
                    </td>
                    <td>
                    <button type="button" className="btn btn-danger" name='btn' id="delete" onClick={()=>deleteData(service.id)}><Trash></Trash></button>
                    </td>
                    </tr>
    
       )
            })}
        </tbody>
    </table>
    <div id="demo">
    <Link to="/addService" >
        <PersonPlusFill></PersonPlusFill>Add
    </Link>
    </div>
    </div>
   
        </>
    );
};
export default ServiceManage;