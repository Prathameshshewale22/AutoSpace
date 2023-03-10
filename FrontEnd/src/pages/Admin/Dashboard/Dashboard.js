
import {useEffect,useState} from 'react';
import PieChart from '../Piechart/Piechart';

 
 
 
const Dashboard = () => {
   
   const[record,setRecord] = useState([])
   const[service,setService] = useState([])
 
   const getData = () =>
   {
       fetch('http://localhost:8080/admin/dashboard/counts',{method:"GET",credentials:'include'})
       .then(resposne=> resposne.json())
       .then(res=>setRecord(res))
   }
 
   useEffect(() => {
      getData();
<<<<<<< HEAD
      getServices();
=======
      getCustomer();
>>>>>>> 6d7c96b938da66a954faaa634523026791fa2528
   },[])

   const getServices=()=>{
    fetch('http://localhost:8080/service',{method:"GET"})
    .then(resposne=> resposne.json())
    .then(res=>setService(res))
   }
    
 
    return (
    <div className="col main pt-5 mt-3">
         
        <div className="row mb-3">
            <div className="col-xl-3 col-sm-6 py-2">
                <div className="card bg-success text-white h-100">
                    <div className="card-body bg-success" style={{backgroundColor:"#57b960"}}>
                        <div className="rotate">
                            <i className="fa fa-user fa-4x"></i>
                        </div>
                        <h6 className="text-uppercase">Customers</h6>
                        <h1 className="display-4">{record.customers}</h1>
                    </div>
                </div>
            </div>
            <div className="col-xl-3 col-sm-6 py-2">
                <div className="card text-white bg-danger h-100">
                    <div className="card-body bg-danger">
                        <div className="rotate">
                            <i className="fa fa-list fa-4x"></i>
                        </div>
                        <h6 className="text-uppercase">Managers</h6>
                        <h1 className="display-4">{record.managers}</h1>
                    </div>
                </div>
            </div>
            <div className="col-xl-3 col-sm-6 py-2">
                <div className="card text-white bg-info h-100">
                    <div className="card-body bg-info">
                        <div className="rotate">
                          <i className="fab fa-twitter fa-4x"></i>
                        </div>
                        <h6 className="text-uppercase">Tweets</h6>
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
                        <h1 className="display-4">{record.deliveryboys}</h1>
                    </div>
                </div>
            </div>
        </div>
 
        <hr/>
        {/* <div className="row placeholders mb-3">
            <div className="col-6 col-sm-3 placeholder text-center">
                <img src="//placehold.it/200/dddddd/fff?text=1" className="mx-auto img-fluid rounded-circle" alt="Generic placeholder thumbnail"/>
                <h4>Responsive</h4>
                <span className="text-muted">Device agnostic</span>
            </div>
            <div className="col-6 col-sm-3 placeholder text-center">
                <img src="//placehold.it/200/e4e4e4/fff?text=2" className="mx-auto img-fluid rounded-circle" alt="Generic placeholder thumbnail"/>
                <h4>Frontend</h4>
                <span className="text-muted">UI / UX oriented</span>
            </div>
            <div className="col-6 col-sm-3 placeholder text-center">
                <img src="//placehold.it/200/d6d6d6/fff?text=3" className="mx-auto img-fluid rounded-circle" alt="Generic placeholder thumbnail"/>
                <h4>HTML5</h4>
                <span className="text-muted">Standards-based</span>
            </div>
            <div className="col-6 col-sm-3 placeholder text-center">
                <img src="//placehold.it/200/e0e0e0/fff?text=4" className="center-block img-fluid rounded-circle" alt="Generic placeholder thumbnail"/>
                <h4>Framework</h4>
                <span className="text-muted">CSS and JavaScript</span>
            </div>
        </div> */}
       
        <div className="row ">
            <div className="col-lg-7 col-md-6 col-sm-12">
              <h5 className="mt-3 mb-3 text-secondary">
               Service Station Details
              </h5>
                <div className="table-responsive">
                    <table className="table table-striped">
                        <thead className="thead-light">
                            <tr>
<<<<<<< HEAD
                                <th>id</th>
                                <th>First Name</th>
=======
                                <th>ID</th>
                                <th>FirstName</th>
>>>>>>> 6d7c96b938da66a954faaa634523026791fa2528
                                <th>Header</th>
                                <th>Column</th>
                                <th>Record Data</th>
                            </tr>
                        </thead>
                        <tbody>
                         {service.map((output)=>
                            <tr>
                                <td>{output.id}</td>
                                <td>{output.serviceName}</td>
                                <td>{output.descrption}</td>
                                <td>{output.email}</td>
                                <td>{output.mobileNumber}</td>
                                <td></td>
                            </tr>
                           )}
                        </tbody>
                    </table>
                </div>
            </div>
            <div className="col-lg-5 col-md-6 col-sm-12 col-sm-offset-5">
                <h4 className='title mt-3 mb-3 text-center text-secondary'>Data in Chart</h4>
                 <div className="mb-5" style={{height:"300px",width:"400px"}}><PieChart/> </div></div>
        </div>
       
    </div>
    )
}
 
export default Dashboard