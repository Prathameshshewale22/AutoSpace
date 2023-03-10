import React from "react";
import { useState ,useEffect} from "react"
import AddManager from "../ManagerDetails/AddManager";
import { Link } from "react-router-dom"
import {PenFill,Trash} from 'react-bootstrap-icons';
// import ManagerRow from "./ManagerRow";

const CutomersInAdmin=()=>{
        let [flag,setflag]=useState(false);
        const [Customers, setCustomers] = useState([]);
        const [managers,setManagers]=useState([]);

        useEffect( () =>{
            fetch('http://localhost:8080/customer',{
                method:"GET"
            })
            .then(res => {
                return res.json()})
            .then(data => {setCustomers(data);
                    //   setManagers(data["centerManager"]);
                    
            })
           
        }, [])
    // useEffect( () =>{
    //     fetch('http://localhost:8080/manager',{
    //         method:"GET"
    //     })
    //     .then(res => res.json())
    //     .then(data => setManagers(data))
    // }, [flag])

    // const deleteData=(id)=>{
    //     fetch('http://localhost:8080/manager/'+id,{
    //         method:"DELETE"
    //     })
    //     .then((result)=>{
    //         console.log(result.data);
    //        // history.push("/");
    //        setflag(true);
    //     })
    //     .catch((err)=>{
    //         console.log("error occured",err);
    //     })
    
    // }
    // const addManager=(id)=>{
    //    <AddManager centerId={id}></AddManager>
    // }
    return (
        <>
        <div className="mx-auto" style={{align:"center"}} >
        <h1 className="page-title" align="center">Customers</h1>
        </div>
        <div className="w-75 p-3 mx-auto shadow-sm p-3 mb-5 bg-body-tertiary rounded " >
    <table className="table table-striped border-top">
        <thead>
            <tr>
            <th>Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Mobile Number</th>
            <th>Address</th>
            </tr>
        </thead>
        <tbody>
            {Customers.map((cust)=> {
                 return (
                    <tr>
                        <td>{cust.id}</td>
                        <td>{cust.firstName}</td>
                        <td>{cust.lastName}</td>
                        {/* <td>{cust.city}</td> */}
                        <td>{cust.email}</td>
                        <td>{cust.mobileNumber}</td>
                        <td>{cust.address}</td>
                        {/* <td>{center.centerManager && center.centerManager.firstName}&nbsp;&nbsp;{center.centerManager && center.centerManager.lastName}</td> */}

                    <td>
                    {/* <Link to={{pathname:`/addManager/${center.id}`}}>
                    <button type="button" className="btn btn-info fs-6" name='btn' id="delete" >Assign</button>
                    </Link> */}
                    </td>
                    </tr>
    
       )
            })}
             <Link to="/admin">BACK</Link>
        </tbody>
    </table>
    </div>
        </>
    );
};
export default CutomersInAdmin;