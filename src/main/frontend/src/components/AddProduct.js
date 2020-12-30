import React, { Component } from 'react';
import { connect } from 'react-redux'
import { addNewProduct } from '../actions/products'

import MinorForm from './MinorForm';

export class AddProduct extends Component {
    state = {
        name: '',
        price: '',
        description: '',
        quantity: '',
        type: ''
    }

    myRef = React.createRef();

    onChange = e => {
        this.setState({
            [e.target.name]: e.target.value
        })
        console.log([e.target.name] + ": " + e.target.value)
    }

    onSubmit = e => {
        e.preventDefault();
        // console.log("SUBMIT FROM ADDPRODUCT")
        // console.log(this.state)
        // console.log(this.myRef.current.state.subValues)
        this.props.addNewProduct(this.state, this.myRef.current.state.subValues)

    }

    render() {
        const { name, description, type, quantity, price } = this.state;

        return (
            <div className="card card-body mt-4 mb-4">
                <h2>Add Product</h2>
                <form onSubmit={this.onSubmit} id="my-form">
                    <div className="form-group">
                        <label>Name</label>
                        <input className="form-control"
                            type="text"
                            name="name"
                            onChange={this.onChange}
                            value={name}
                        />
                    </div>
                    <div className="form-group">
                        <label>Description</label>
                        <input className="form-control"
                            type="text"
                            name="description"
                            onChange={this.onChange}
                            value={description}
                        />
                    </div>
                    <div className="form-group">
                        <label for="type">Type</label>
                        <select className="form-control"
                            name="type"
                            id="type"
                            onChange={this.onChange}
                            value={type} >
                            <option value="" selected disabled hidden>Choose type</option>
                            <option value="gpu">GPU</option>
                            <option value="cpu">CPU</option>
                            <option value="ram">RAM</option>
                            <option value="psu">PSU</option>
                            <option value="ssd">SSD</option>
                            <option value="hdd">HDD</option>
                            <option value="motherboard">MOTHERBOARD</option>
                            <option value="cooler">COOLER</option>
                        </select>

                    </div>
                    <div className="form-group">
                        <label>Price</label>
                        <input className="form-control"
                            type="number"
                            step="0.01"
                            name="price"
                            onChange={this.onChange}
                            value={price}
                        />
                    </div>
                    <div className="form-group">
                        <label>Quantity</label>
                        <input className="form-control"
                            type="number"
                            name="quantity"
                            onChange={this.onChange}
                            value={quantity}
                        />
                    </div>
                    <MinorForm type={this.state.type} ref={this.myRef}/>
                    <div className="form-group mt-3 d-grid">
                        <button type="submit" form="my-form" className='btn btn-primary'>SUBMIT</button>
                    </div>
                </form>
            </div>
        )
    }
}

export default connect(null, { addNewProduct })(AddProduct)