import React, { useState,useEffect } from "react";
import { Button,Container,Nav,Navbar,NavDropdown } from "react-bootstrap";
import { Link,useNavigate } from "react-router-dom";
//  import { useAuthState } from "react-firebase-hooks/auth";
import SecondLogo from "../../../images/SecondLogo.png";
import './Header.css';
import axios from "axios";
const Header =()=>{
   const navigate= useNavigate();
  //  const [user] = useAuthState(auth);
  //  const handleSignout = () => {
  //     signOut(auth);
  //   };
  //   const handleNavigateC = () =>{
  //     navigate(`/contact`);
  //   }

  const [user,setUser]=useState([]);
  const [loginflag,setLoginflag]=useState(false);
  
   
    // useEffect(() =>{
    //    fetch('http://localhost:8080/api/success',{
    //       // headers:{
    //       //   Content:'application/json'
    //       // },
    //       method:"GET",
    //       credentials:"include"
    //   })
    //   .then(res =>{
    //     console.log(res);
    //     if (res.redirected) {
    //       window.location.href = res.url;
    //   }
    //     return res.json()})
    //   .then(data => setUser(data))
    //   .catch((err)=>{
    //     console.log(err);
    //   })
    //   }, [])

    useEffect(()=>{
      axios.get('http://localhost:8080/api/success',{ withCredentials: true })
        // .then(res => res.json())
        .then(res => {setUser(res);
          console.log(user);
         if(res.status===200 && res.data.role==='ROLE_ADMIN'){
          localStorage.setItem("admin",JSON.stringify(res.data))
          setLoginflag(true);
          navigate('/admin')
         }
         else if(res.status===500){
          navigate('/')
         }
        })
        .catch((err)=>{console.log(err);
          setLoginflag(false);
          navigate('/')
        })
    },[])
 
    const logout=()=>{
      axios.get('http://localhost:8080/logout',{withCredentials:true})
      .then((res)=>{
        localStorage.clear();
        setLoginflag(false);
        navigate('/')
      })
      .catch(()=>{})
    }


   return (
    <>
    <Navbar 
    collapseOnSelect
    expand="lg"
    sticky="top"
    //bg="primary"
    variant="dark"
    className="color-nav"
    >
     <Container>
        <Navbar.Brand as={Link} to="/">
            <img id="logoid" src={ SecondLogo } alt=""/>
        </Navbar.Brand>
        <Navbar.Toggle aria-controls="responsive-navbar-nav" />
          <Navbar.Collapse id="responsive-navbar-nav">
            <Nav className="me-auto ">

            <Nav.Link as={Link} to="/">
                Home
              </Nav.Link>
                <Nav.Link as={Link} to="service">Services</Nav.Link>
                <Nav.Link as={Link} to="experts">Experts</Nav.Link>
                <Nav.Link as={Link} to="about">
                  About
                </Nav.Link>
                <Nav.Link as={Link} to="contact">
                  Contact
                </Nav.Link>
                <Nav.Link as={Link} to="admin">
                  Admin
                </Nav.Link>
                <Nav.Link as={Link} to="manager">
                  Manager
                </Nav.Link>

        

            </Nav>
            <Nav>
            {/* {loginflag && (
                <>
                  <Nav.Link as={Link} to="addservice">
                    Add Service
                  </Nav.Link>
                  <Nav.Link as={Link} to="manageservice">
                    Manage Services
                  </Nav.Link>
                  <Nav.Link as={Link} to="orders">
                    Orders
                  </Nav.Link>
                </>
              )} */}
              {loginflag ? (
                <>
                <Nav.Link>Welcome {user.data.firstName}</Nav.Link>
                <Button  className="btn btn-danger rounded-pill" onClick={logout}>
                  Sign out
                </Button></>
              ) : (
                <Nav.Link as={Link} to="login">
                  Login
                </Nav.Link>
                
              )}
              {!user && (<button className="btn btn-new rounded-pill mx-3">Let's Talk</button>)}
            </Nav>
          </Navbar.Collapse>
     </Container>
    </Navbar>
    </>
   )
}
export default Header;