import React, { Component, Fragment } from 'react';
import { connect } from 'react-redux';
import { getOneProduct, updateProduct, deleteProduct } from '../actions/products';

export class ProductDetails extends Component {

    state = {
        currentProduct: [],
    }

    componentDidMount() {

        this.props.getOneProduct(this.props.match.params.id)
        setTimeout(() => this.setState({ currentProduct: this.props.currentProduct }), 100)

    }

    onChange = e => {
        this.setState(prevState => ({
            currentProduct: {
                ...prevState.currentProduct,
                [e.target.name]: e.target.value
            }
        }
        ))
    }

    onSubmit = e => {
        e.preventDefault();
        this.props.updateProduct(this.state.currentProduct.id, this.state.currentProduct)
        this.props.history.push("/products");
    }

    onDelete = e => {
        this.props.deleteProduct(this.props.currentProduct.id)
        this.props.history.push("/products");
    }


    render() {
        const shouldBeDisabled = ["id", "type", "createdAt"];
        const shouldBeInteger = ["quantity"];
        const shouldBeDouble = ["price"]



        return (this.state.currentProduct.id ?

            <div className='card card-body'>
                <form onSubmit={this.onSubmit} id="my-form">
                    {Object.keys(this.state.currentProduct).map(key => {
                        if (key !== "_links") {
                            return (<div className='form-group' key={key}>
                                <label>{key.toUpperCase()}</label>
                                <input
                                    className='form-control'
                                    name={key}
                                    value={this.state.currentProduct.[key]}
                                    onChange={this.onChange}
                                    disabled={shouldBeDisabled.includes(key)}
                                    type={(shouldBeInteger.includes(key) || shouldBeDouble.includes(key)) && "number"}
                                    step={shouldBeDouble.includes(key) && "0.01"}
                                />
                            </div>)
                        }
                    }
                    )}

                </form>
                <button form="my-form" type='submit' className='btn btn-primary mt-3'>UPDATE</button>
                <button className='btn btn-danger mt-3' onClick={this.onDelete}>DELETE</button>
            </div>

            :

            <h3 className='text-center mt-5'>Product doesn't exists</h3>
        )
    }
}

const mapStateToProps = state => ({
    currentProduct: state.products.currentProduct
})

export default connect(mapStateToProps, { getOneProduct, updateProduct, deleteProduct })(ProductDetails)