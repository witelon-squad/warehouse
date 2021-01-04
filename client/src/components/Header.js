import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import logo from '../static/images/logo.png'
 
export class Header extends Component {
    render() {
        return (
            <nav className="navbar navbar-expand-lg navbar-light bg-light">
                <div className="container-fluid">
                    <Link to='/products' className="navbar-brand" href="#">
                        <img src={logo} alt='witelonix' height='55'></img>
                    </Link>
                    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
                        <div className="navbar-nav">
                            <Link to='/products' className='nav-link'>All Products</Link>
                            <Link to='/add' className='nav-link'>Add Product</Link>
                         </div>
                    </div>
                </div>
            </nav>
        )
    }
}

export default Header