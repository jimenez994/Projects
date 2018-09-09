import React from 'react';
import { Navbar, NavItem } from 'react-materialize';

const NavbarC = () => {
  return (
    <div>
      <Navbar brand='logo' right>
        <NavItem onClick={() => console.log('test click')}>Getting   started</NavItem>
        <NavItem href='components.html'>Components</NavItem>
      </Navbar>
    </div>
  );
};

export default NavbarC;