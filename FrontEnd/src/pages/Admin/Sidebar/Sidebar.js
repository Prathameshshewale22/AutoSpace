import React from 'react'
const Sidebar = () => {
    return (
         <div className="col-md-3 col-lg-2 sidebar-offcanvas pl-0" id="sidebar" role="navigation" style={{backgroundColor:"#e9ecef"}}>
            <ul className="nav flex-column sticky-top pl-0 pt-5 p-3 mt-3 ">
                <li className="nav-item mb-2 mt-3"><a className="nav-link text-secondary" href="#"><h5>AutoSpace</h5></a></li>
                <li className="nav-item mb-2 "><a className="nav-link text-secondary" href="/admin"><i className="fas fa-user font-weight-bold"></i> <span className="ml-3">Overview</span></a></li>
                <li className="nav-item mb-2">
                    <a className="nav-link text-secondary" href="#submenu1" data-toggle="collapse" data-target="#submenu1"><i className="far fa-file-word font-weight-bold"></i> <span className="ml-3"> Reports▾</span></a>
                    <ul className="list-unstyled flex-column pl-3 collapse" id="submenu1" aria-expanded="false">
                       <li className="nav-item mb-2 "><a className="nav-link text-secondary" href=""><i className="fas fa-book-reader"></i> Data Report </a></li>
                       <li className="nav-item mb-2 "><a className="nav-link text-secondary" href=""> <i className="fas fa-book-medical"></i> File Report </a></li>
                    </ul>
                </li>
                <li className="nav-item mb-2"><a className="nav-link text-secondary" href="/services"><i className="far fa-chart-bar font-weight-bold"></i> <span className="ml-3">Services</span></a></li>
                <li className="nav-item mb-2"><a className="nav-link text-secondary" href="/managers"><i className="lni lni-users font-weight-bold"></i><span className="ml-3">Managers</span></a></li>
                <li className="nav-item mb-2"><a className="nav-link text-secondary" href="/servicecenters"><i className="lni lni-home font-weight-bold"></i><span className="ml-3">ServiceCenter</span></a></li>
                <li className="nav-item mb-2"><a className="nav-link text-secondary" href="/customer"><i className="lni lni-users font-weight-bold"></i> <span className="ml-3">Customers</span></a></li>
                <li className="nav-item mb-2"><a className="nav-link text-secondary" href="#"><i className="far fa-folder font-weight-bold"></i> <span className="ml-3">Layouts</span></a></li>

            </ul>
       </div>
    )
}
 
export default Sidebar