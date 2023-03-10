// import "./Dashboard.css"
import {useEffect,useState} from 'react';
const Dashboard = () => {
   
   const[record,setRecord] = useState([])
   const[serviceRec,setserviceRec] = useState([])
 
   const getData = () =>
   {
       fetch('http://localhost:8080/admin/dashboard/counts',{method:"GET"})
       .then(resposne=> resposne.json())
       .then(res=>setRecord(res))
   }
 
   useEffect(() => {
      getData();
      getServices();
   },[])

   const getServices=()=>{
    fetch('http://localhost:8080/service',{method:"GET"})
    .then(resposne=> resposne.json())
    .then(res=>setserviceRec(res))
   }
    
 
    return (
    <div className="col main pt-5 mt-3">
         <div id='resize'>
        <div className="row mb-3">
            <div className="col-xl-3 col-sm-6 py-2">
                <div className="card text-white bg-info h-100 ">
                    <div className="card-body bg-info">
                        <div className="rotate">
                          <i className="fab fa-twitter fa-4x"></i>
                        </div>
                        <h6 className="text-uppercase">Bookings</h6>
                        <h1 className="display-4">125</h1>
                    </div>
                </div>
            </div>
            <div className="col-xl-3 col-sm-6 py-2">
                <div className="card text-white bg-warning h-100">
                    <div className="card-body">
                        <div className="rotate">
                            <i className="fa fa-share fa-4x"></i>
                        </div>
                        <h6 className="text-uppercase">DeliveryBoys</h6>
                        <h1 className="display-4">25</h1>
                    </div>
                </div>
            </div>
            <div className="col-xl-3 col-sm-6 py-2">
                <div className="card text-white  h-100">
                    <div className="card-body">
                        <div className="rotate">
                            <i className="fa fa-share fa-4x"></i>
                        </div>
                        <h6 className="text-uppercase">Welcome</h6>
                        <div class="single-testimonial text-center">
                        <div class="testimonial-image">
                        <img
                          src="https://cdn.ayroui.com/1.0/images/testimonial/author-1.jpg"
                          alt="Author"
                        />
                        <div class="quote-icon">
                          <i class="lni lni-quotation"></i>
                        </div>
                      </div>
                      </div>
                        <h1 className="display-4">Manager Name</h1>
                    </div>
                </div>
            </div>
            
        </div>
        </div>
        <hr/>
       
        <div className="row ">
            
              <h5 className="mt-3 mb-3 text-secondary">
               Services
              </h5>
                <div className="table-responsive">
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
            {serviceRec.map((service)=> {
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
                </div>
            </div>
            <div className="col-lg-5 col-md-6 col-sm-12 col-sm-offset-5">
            </div>
        
       
    </div>
    )
}
 
export default Dashboard