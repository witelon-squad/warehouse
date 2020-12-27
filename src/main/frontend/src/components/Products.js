import axios from 'axios';
import React, { Component, Fragment } from 'react';
import { connect } from 'react-redux';
import { getProducts } from "../actions/products";


export class Products extends Component {

    componentDidMount(){
        this.props.getProducts();
    }

    render() {
        return (
            <Fragment>
                <h2>Products</h2>
                <table className="table table-striped">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Type</th>
                            <th>CreatedAt</th>
                            <th>More</th>
                        </tr>
                    </thead>
                    <tbody>
                    {console.log(this.props.allProducts)}
                        { this.props.allProducts.map(product => (
                            <tr key={product.id}>
                                <td>{product.id}</td>
                                <td>{product.name}</td>
                                <td>{product.price}</td>
                                <td>{product.type}</td>
                                <td>{product.createdAt}</td>
                                <td></td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </Fragment>
        )
    }
}

const mapStateToProps = state => ({
    products: state.products.products,
    allProducts: state.products.allProducts
});

export default connect(mapStateToProps, { getProducts })(Products);