import React from "react";
import { useNavigate } from "react-router-dom";
import "./Service.css";

const Service = ({ service }) => {
  const {id, serviceName,description,estimatedTime,estimatedCost } = service;
  const navigate = useNavigate();

  const navigateToDetails = id =>{
    navigate(`/service/${id}`);
  }
  return (
    <div className="g-5 gx-5 col-sm-12 col-md-6 col-lg-4 text-center">
      <div className="card mx-auto" style={{ width: "25rem" }}>
        {/* <img src={img} className="card-img-top w-100" alt="..." /> */}
        <div className="card-body">
          <h5 className="card-title">{serviceName}</h5>
          <p className="card-text">
            {description}
          </p>
          <p className="card-text">
            TimeRequired: {estimatedTime}
          </p>
          <p className="card-text">
            Price: {estimatedCost}
          </p>
          <button onClick={ () => navigateToDetails(id)} className="btn btn-primary">
            Book {serviceName}
          </button>
        </div>
      </div>
    </div>

  );
};

export default Service;
