import React, { Component, Fragment } from 'react';
import { connect } from 'react-redux';
import { getProducts } from "../actions/products";
import { Link } from 'react-router-dom';


export class Products extends Component {

    componentDidMount() {
        this.props.getProducts();
    }

    render() {

        return (
            <div className='bg-dark text-light'>
                <table className="table table-success table-hover align-middle caption-top">
                    <caption className='px-3'>
                        List of products
                    </caption>
                    <thead className='table-dark'>
                        <tr>
                            <th>#</th>
                            <th>Product name</th>
                            <th>Price</th>
                            <th>Type</th>
                            <th>Quantity</th>
                            <th>Detail</th>
                        </tr>
                    </thead>
                    <tbody>
                        {this.props.listOfProducts.map(product => (
                            <tr key={product.id}>
                                <td>{product.id}</td>
                                <td>{product.name}</td>
                                <td>{product.price.toFixed(2)}</td>
                                <td>{product.type.toUpperCase()}</td>
                                <td>{product.quantity}</td>
                                <td><Link to={`/products/${product.id}`} className="btn btn-outline-dark btn-sm">Detail</Link></td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        )
    }
}

const mapStateToProps = state => ({
    products: state.products.products,
    listOfProducts: state.products.listOfProducts
});

export default connect(mapStateToProps, { getProducts })(Products);