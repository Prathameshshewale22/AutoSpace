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
import ServiceManage from './pages/Admin/ServiceManage/ServiceManage';
import AddService from './pages/Admin/ServiceManage/AddService';
import Manager from './pages/Manager/Manager/Manager'
import ServiceInfo from './pages/Manager/ServiceInfo/ServiceInfo';
import DeliveryBoy from './pages/Manager/DiliveryBoy/DiliveryBoy';
import AddDeliveryBoy from './pages/Manager/DiliveryBoy/AddDeliveryBoy';
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
      <Route path="/services" element={<ServiceManage></ServiceManage>}></Route>
      <Route path="/addService" element={<AddService></AddService>}></Route>
      <Route path="/manager" element={<Manager></Manager>}></Route>
      <Route path="/serviceinfo" element={<ServiceInfo></ServiceInfo>}></Route>
      <Route path="/dboys" element={<DeliveryBoy></DeliveryBoy>}></Route>
      <Route path="/addDeliveryboy/:id" element={<AddDeliveryBoy></AddDeliveryBoy>}></Route>
      </Routes>
    </div>
  );
}

export default App;
