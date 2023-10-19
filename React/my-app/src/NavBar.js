import React from "react";
import { Navbar,Container,NavDropdown,Nav,Offcanvas,Form,Button} from "react-bootstrap";
import {Link} from 'react-router-dom';

export const NavBar = () =>{
    return (
        <>
          {[false].map((expand) => (
            <Navbar key={expand} bg="dark"variant="dark" expand={expand} className="mb-3">
              <Container fluid>
                <Navbar.Brand >Numer Project</Navbar.Brand>

                <Navbar.Toggle aria-controls={`offcanvasNavbar-expand-${expand}`} />  

                <Navbar.Offcanvas
                  id={`offcanvasNavbar-expand-${expand}`}
                  aria-labelledby={`offcanvasNavbarLabel-expand-${expand}`}
                  placement="end">

                  <Offcanvas.Header closeButton>
                    <Offcanvas.Title id={`offcanvasNavbarLabel-expand-${expand}`}>
                      Menu
                    </Offcanvas.Title>
                  </Offcanvas.Header>

                  <Offcanvas.Body>
                    <Nav className="justify-content-end flex-grow-1 pe-3">
                    
                    <NavDropdown
                          title="Root Of Equation"
                          id={`offcanvasNavbarDropdown-expand-${expand}`}>
                          <NavDropdown.Item href="/Bisection">Bisection</NavDropdown.Item><NavDropdown.Divider />
                          <NavDropdown.Item href="/FalsePosition">FalsePosition</NavDropdown.Item>

                        </NavDropdown>

                        <NavDropdown
                          title="Interpolation"
                          id={`offcanvasNavbarDropdown-expand-${expand}`}>
                          <NavDropdown.Item href="/Newton">Newton</NavDropdown.Item><NavDropdown.Divider />
                          <NavDropdown.Item href="/Lagrange">Lagrange</NavDropdown.Item>
                        </NavDropdown>

                        <NavDropdown
                          title="Solutions Root of equation"
                          id={`offcanvasNavbarDropdown-expand-${expand}`}>
                          <NavDropdown.Item href="/Gauss_elimination">Gauss_elimination</NavDropdown.Item> <NavDropdown.Divider />
                          <NavDropdown.Item href="/Gauss_Jordan">Gauss_Jordan</NavDropdown.Item>
                        </NavDropdown>
                    </Nav>
                    
                  </Offcanvas.Body>
                </Navbar.Offcanvas>
              </Container>
            </Navbar>
          ))}
        </>
      );
}
