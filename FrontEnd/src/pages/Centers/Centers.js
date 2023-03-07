import React from "react";
import { useNavigate } from "react-router-dom";
import "./Centers.css";

const Centers = ({ service }) => {
  const {id, centerName,centerAddress,city,zipcode,contactNumber,email} = service;
  const navigate = useNavigate();
  console.log(centerName)
  const navigateToDetails = id =>{
    navigate(`/service/${id}`);
  }
  return (
    <div className="g-5 gx-5 col-sm-12 col-md-6 col-lg-4 text-center">
      <div className="card mx-auto" style={{ width: "25rem" }}>
        {/* <img src={img} className="card-img-top w-100" alt="..." /> */}
        <div className="card-body">
          <h5 className="card-title">{centerName}</h5>
          <p className="card-text">
            {centerAddress}
          </p>
          <p className="card-text">
          contactNumber: {contactNumber}
          </p>
          <p className="card-text">
          email: {email}
          </p>
          {/* <button onClick={ () => navigateToDetails(id)} className="btn btn-primary">
            Book {serviceName}
          </button> */}
        </div>
      </div>
    </div>

  );
};

export default Centers;
