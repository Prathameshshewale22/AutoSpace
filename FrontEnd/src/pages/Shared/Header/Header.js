import React from "react";
import { Button,Container,Nav,Navbar,NavDropdown } from "react-bootstrap";
import { Link } from "react-router-dom";
// import { useAuthState } from "react-firebase-hooks/auth";
import SecondLogo from "../../../images/SecondLogo.png";
import './Header.css';
const Header =()=>{
   //const navigate= useNavigate();
   // const [user] = useAuthState(auth);
   // const handleSignout = () => {
   //    signOut(auth);
   //  };
   //  const handleNavigateC = () =>{
   //    navigate(`/contact`);
   //  }
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
              {/* <Nav.Link as={Link} to="service">Services</Nav.Link>
              <Nav.Link as={Link} to="experts">Experts</Nav.Link>
              <Nav.Link as={Link} to="about">
                About
              </Nav.Link>
              <Nav.Link as={Link} to="contact">
                Contact
              </Nav.Link>
              <Nav.Link as={Link} to="blogs">
                Blogs
              </Nav.Link> */}
              
            </Nav>
            {/* <Nav>
            {user && (
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
              )}
              {user ? (
                <> 
                <Button onClick={handleSignout} className="btn btn-danger rounded-pill">
                  Sign out
                </Button></>
                
                
              ) : (
                <Nav.Link as={Link} to="login">
                  Login
                </Nav.Link>
                
              )}
              {!user && (<button className="btn btn-new rounded-pill mx-3" onClick={handleNavigateC}>Let's Talk</button>)}
             
            </Nav> */}
          </Navbar.Collapse>
     </Container>
    </Navbar>
    </>
   )
}
export default Header;