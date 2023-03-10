import logo from './logo.svg';
import './App.css';
import { Route, Routes } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import Header from "./pages/Shared/Header/Header";
import Home from "./pages/Home/Home/Home";
import Services from "./pages/Services/Services"
import Admin from './pages/Admin/Admin/Admin';
import ManagerDetails from './pages/Admin/ManagerDetails/ManagerDetails';
import ManagerEdit from './pages/Admin/ManagerDetails/ManagerEdit';
import ServiceCenter from './pages/Admin/ServiceCenter/ServiceCenter';
import AddManager from './pages/Admin/ManagerDetails/AddManager';
<<<<<<< HEAD
import Login from './pages/Login/Login';
import CustomerInAdmin from './pages/Admin/Customer/CustomerInAdmin';
import Customer from './pages/Customer/Customer/Customer';
import Vehicle from './pages/Customer/Vehicle/Vehicle';
=======
import ServiceManage from './pages/Admin/ServiceManage/ServiceManage';
import AddService from './pages/Admin/ServiceManage/AddService';
>>>>>>> 6d7c96b938da66a954faaa634523026791fa2528
function App() {
  return (
    <div>
      <Header></Header>
      <Routes>
      <Route path="/" element={<Home></Home>}></Route>
      <Route path="/service" element={<Services></Services>}></Route>
      <Route path="/admin" element={<Admin></Admin>}></Route>
      <Route path="/managers" element={<ManagerDetails></ManagerDetails>}></Route>
      <Route path="/servicecenters" element={<ServiceCenter></ServiceCenter>}></Route>
      <Route path="/edit/:id" element={<ManagerEdit></ManagerEdit>}></Route>
      <Route path="/addManager/:id" element={<AddManager></AddManager>}></Route>
<<<<<<< HEAD
      <Route path="/login" element={<Login></Login>}></Route>
      <Route path="/customer" element={<CustomerInAdmin></CustomerInAdmin>}></Route>
      <Route path="/customerdashboard" element={<Customer></Customer>}></Route>
      <Route path="/vehicle" element={<Vehicle></Vehicle>}></Route>
=======
      <Route path="/services" element={<ServiceManage></ServiceManage>}></Route>
      <Route path="/addService" element={<AddService></AddService>}></Route>
>>>>>>> 6d7c96b938da66a954faaa634523026791fa2528
      </Routes>
    </div>
  );
}

export default App;
