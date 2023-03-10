import React from "react";
import { useState ,useEffect} from "react"
import { Link } from "react-router-dom"
import {ArrowLeftCircleFill, PenFill,Trash,PersonFillCheck} from 'react-bootstrap-icons';
import "./DiliveryBoy.css"
const DeliveryBoy=()=>{
        const [diliveryboys, setDeliveryboy] = useState([]);
        let [flag,setflag]=useState(false);
        useEffect( () =>{
            fetch('http://localhost:8080/deliveryboy/'+3,{
                method:"GET"
            })
            .then(res => res.json())
            .then(data => setDeliveryboy(data))
        }, [])
    useEffect( () =>{
        fetch('http://localhost:8080/deliveryboy/'+3,{
            method:"GET"
        })
        .then(res => res.json())
        .then(data => setDeliveryboy(data))
    }, [flag])

    const deleteData=(id)=>{
        fetch('http://localhost:8080/deliveryboy/'+id,{
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
        <h1 className="page-title" id="demo">Delivery Boys</h1>
        </div>
        <div className="w-75 p-3 mx-auto shadow-sm p-3 mb-5 bg-body-tertiary rounded " >
    <table className="table table-striped border-top">
        <thead>
            <tr>
            <th>Id</th>
            <th>FirstName</th>
            <th>LastName</th>
            <th>Email</th>
            <th>MobileNo</th>
            <th>Remove</th>
            </tr>
        </thead>
        <tbody>
            {diliveryboys.map((boys)=> {
                 return (
                    <tr>
                        <td>{boys.id}</td>
                        <td>{boys.firstName}</td>
                        <td>{boys.lastName}</td>
                        <td>{boys.email}</td>
                        <td>{boys.mobileNumber}</td>
                    <td>
                    <button type="button" className="btn btn-danger" name='btn' id="delete" onClick={()=>deleteData(boys.id)}><Trash></Trash></button>
                    </td>
                    </tr>
    
       )
            })}
        </tbody>
    </table>
    <div id="demo2">
    <Link to={{pathname:`/addDeliveryboy/3`}}>
                    <button type="button" className="btn btn-info fs-6" name='btn' id="delete" ><PersonFillCheck></PersonFillCheck>&nbsp;Add</button>
                    </Link>&nbsp; &nbsp; &nbsp; 
    <Link to="/manager" id="size">
        <ArrowLeftCircleFill></ArrowLeftCircleFill>
    </Link>
    
    </div>
    </div>
   
        </>
    );
};
export default DeliveryBoy;