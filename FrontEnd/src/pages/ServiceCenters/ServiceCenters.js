import React, { useEffect, useState } from 'react';
import Centers from '../Centers/Centers';
import './ServiceCenters.css';

const ServiceCenters = () => {
    const [serviceCenters, setServiceCenters] = useState([]);

    useEffect( () =>{
        fetch('http://localhost:8080/servicecenter',{
            method:"GET"
        })
        .then(res => res.json())
        .then(data => setServiceCenters(data))
       
    }, [])
    console.log(serviceCenters);
    return (
        <div id='services' className='container mb-5'>
            <h1 className='heading text-center  mt-5'>Our Service Centers</h1>
            <div className='row'>
            {
               
                serviceCenters.map(center => <Centers
                    key={center.id}
                    service={center}
                    ></Centers>)
            }
            </div>
            
        </div>
    );
};

export default ServiceCenters;