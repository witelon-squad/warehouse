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
                            <th>Product name</th>
                            <th>Price</th>
                            <th>Type</th>
                            <th>Detail</th>
                        </tr>
                    </thead>
                    <tbody>
                    {console.log(this.props.allProducts)}
                        { this.props.listOfProducts.map(product => (
                            <tr key={product.id}>
                                <td>{product.id}</td>
                                <td>{product.name}</td>
                                <td>{product.price.toFixed(2)}</td>
                                <td>{product.type.toUpperCase()}</td>
                                <td><button className="btn btn-outline-info btn-sm">+</button></td>
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
    listOfProducts: state.products.listOfProducts
});

export default connect(mapStateToProps, { getProducts })(Products);