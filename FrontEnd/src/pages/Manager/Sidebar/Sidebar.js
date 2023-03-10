import React from 'react'
import { CartCheckFill ,Clipboard2CheckFill,PersonFill,PeopleFill} from 'react-bootstrap-icons'
import "./Sidebar.css"
const Sidebar = () => {
    return (
         <div className="col-md-3 col-lg-2 sidebar-offcanvas pl-0" id="Sidebar" role="navigation" style={{backgroundColor:"#e9ecef"}}>
            <ul className="nav flex-column sticky-top pl-0 pt-5 p-3 mt-3 ">
                <li className="nav-item mb-2 mt-3"><a className="nav-link text-secondary" href="#"><h5>AutoSpace</h5></a></li>
                <li className="nav-item mb-2 "><a className="nav-link text-secondary" href="/manager"><PersonFill></PersonFill> <span className="ml-3">Overview</span></a></li>
                <li className="nav-item mb-2"><a className="nav-link text-secondary" href="/serviceinfo"><Clipboard2CheckFill></Clipboard2CheckFill> <span className="ml-3">Services</span></a></li>
                <li className="nav-item mb-2"><a className="nav-link text-secondary" href="/dboys"><PeopleFill></PeopleFill><span className="ml-3">DiliveryBoys</span></a></li>
                <li className="nav-item mb-2"><a className="nav-link text-secondary" href="/servicecenters"><CartCheckFill></CartCheckFill><span className="ml-3">Orders</span></a></li>
                <li className="nav-item mb-2"><a className="nav-link text-secondary" href="#"><PeopleFill></PeopleFill> <span className="ml-3">Customers</span></a></li>
            </ul>
       </div>
    )
}
 
export default Sidebar