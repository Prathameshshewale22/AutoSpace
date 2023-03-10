import React from "react";
import { useState ,useEffect} from "react"
import { Link } from "react-router-dom"
import { ArrowLeftCircleFill } from "react-bootstrap-icons";
import "./ServiceInfo.css"
const ServiceInfo=()=>{
        const [services, setServices] = useState([]);
        useEffect( () =>{
            fetch('http://localhost:8080/service',{
                method:"GET"
            })
            .then(res => res.json())
            .then(data => setServices(data))
        }, [])

    return (
        <>
        <div className="mx-auto" style={{align:"center"}} >
        <h1 className="page-title" id="demo">AutoSpace Services</h1>
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
                        
                    </tr>
    
       )
            })}
        </tbody>
    </table>
    <div id="demo2">
    <Link to="/manager">
        <ArrowLeftCircleFill></ArrowLeftCircleFill>
    </Link>
    </div>
    </div>
   
        </>
    );
};
export default ServiceInfo;