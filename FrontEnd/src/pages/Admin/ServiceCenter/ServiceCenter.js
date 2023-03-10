import React from "react";
import { useState ,useEffect} from "react"
import AddManager from "../ManagerDetails/AddManager";
import { Link } from "react-router-dom"
import {PenFill,Trash} from 'react-bootstrap-icons';
// import ManagerRow from "./ManagerRow";

const ServiceCenter=()=>{
        let [flag,setflag]=useState(false);
        const [serviceCenters, setServiceCenters] = useState([]);
        const [managers,setManagers]=useState([]);

        useEffect( () =>{
            fetch('http://localhost:8080/servicecenter',{
                method:"GET"
            })
            .then(res => {
                return res.json()})
            .then(data => {setServiceCenters(data);
                    //   setManagers(data["centerManager"]);
                      console.log(serviceCenters);
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
    const addManager=(id)=>{
       <AddManager centerId={id}></AddManager>
    }
    return (
        <>
        <div className="mx-auto" style={{align:"center"}} >
        <h1 className="page-title">ServiceCenters</h1>
        </div>
        <div className="w-75 p-3 mx-auto shadow-sm p-3 mb-5 bg-body-tertiary rounded " >
    <table className="table table-striped border-top">
        <thead>
            <tr>
            <th>Id</th>
            <th>centerName</th>
            <th>centerAddress</th>
            <th>city</th>
            <th>email</th>
            <th>zipcode</th>
            <th>contactNumber</th>
<<<<<<< HEAD
            <th>Manager Name</th>
=======
            <th>Manager</th>
            <th>Assign Manager</th>
>>>>>>> 8188fffa8cb1a802cbd3013f200dc2dd146b7a5a
            </tr>
        </thead>
        <tbody>
            {serviceCenters.map((center)=> {
                 return (
                    <tr>
                        <td>{center.id}</td>
                        <td>{center.centerName}</td>
                        <td>{center.centerAddress}</td>
                        <td>{center.city}</td>
                        <td>{center.email}</td>
                        <td>{center.zipcode}</td>
                        <td>{center.contactNumber}</td>
<<<<<<< HEAD
                        <td>{center.centerManager.firstName}&nbsp;&nbsp;{center.centerManager.lastName}</td>
=======
                        <td></td>
                        {/* <td>{center.centerManager[1]}&nbsp;&nbsp;{center.centerManager[2]}</td> */}
            
>>>>>>> 8188fffa8cb1a802cbd3013f200dc2dd146b7a5a
                    <td>
                    <Link to={{pathname:`/addManager/${center.id}`}}>
                    <button type="button" className="btn btn-info fs-6" name='btn' id="delete" >Assign</button>
                    </Link>
                    </td>
                    </tr>
    
       )
            })}
        </tbody>
    </table>
    </div>
        </>
    );
};
export default ServiceCenter;