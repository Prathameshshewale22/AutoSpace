import React from "react";
import { useState ,useEffect} from "react"
import { Link } from "react-router-dom"
import {ArrowLeftCircleFill, PenFill,Trash} from 'react-bootstrap-icons';
import "./manager.css"
// import ManagerRow from "./ManagerRow";
import ManagerEdit from './ManagerEdit';
const ManagerDetails=()=>{
        const [managers, setManagers] = useState([]);
        let [flag,setflag]=useState(false);
        useEffect( () =>{
            fetch('http://localhost:8080/manager',{
                method:"GET"
            })
            .then(res => res.json())
            .then(data => setManagers(data))
        }, [])
    useEffect( () =>{
        fetch('http://localhost:8080/manager',{
            method:"GET"
        })
        .then(res => res.json())
        .then(data => setManagers(data))
    }, [flag])

    const deleteData=(id)=>{
        fetch('http://localhost:8080/manager/'+id,{
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
<<<<<<< HEAD
        <h1 className="page-title" align="center">Managers</h1>
=======
        <h1 className="page-title" id="demo">Managers</h1>
>>>>>>> 6d7c96b938da66a954faaa634523026791fa2528
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
            <th>Edit</th>
            <th>Remove</th>
            </tr>
        </thead>
        <tbody>
            {managers.map((manager)=> {
                 return (
                    <tr>
                        <td>{manager.id}</td>
                        <td>{manager.firstName}</td>
                        <td>{manager.lastName}</td>
                        <td>{manager.email}</td>
                        <td>{manager.mobileNumber}</td>
                        <td> 
                        
                        <Link to={{pathname:`/edit/${manager.id}`}} state={{test: 'test'}}>
                     <PenFill></PenFill>
                        </Link>
                    </td>
                    <td>
                    <button type="button" className="btn btn-danger" name='btn' id="delete" onClick={()=>deleteData(manager.id)}><Trash></Trash></button>
                    </td>
                    </tr>
    
       )
            })}
            <Link to="/admin">BACK</Link>
        </tbody>
    </table>
    <div id="demo2">
    <Link to="/admin" id="size">
        <ArrowLeftCircleFill></ArrowLeftCircleFill>
    </Link>
    </div>
    </div>
   
        </>
    );
};
export default ManagerDetails;