import axios from 'axios';
import { returnError } from './errors';
import { createMessage } from './messages';

import { GET_PRODUCTS, ADD_NEW_PRODUCT, GET_ONE_PRODUCT, DELETE_PRODUCT, GET_ERROR, CREATE_MESSAGE } from './types';

export const getProducts = () => dispatch => {
    axios.get('http://localhost:8080/products')
        .then(response => {

            let allProducts = [];
            let listOfAllProducts = response.data._embedded;

            for (let key in listOfAllProducts) {
                let listOfSubProducts = listOfAllProducts[key];

                for (let keyTwo in listOfSubProducts) {
                    allProducts.push(listOfSubProducts[keyTwo])
                }
            }

            dispatch({
                type: GET_PRODUCTS,
                payload: response.data,
                payloadAll: allProducts
            });
        }).catch(error => console.log(error));
};

export const addNewProduct = (mainValues, subValues) => dispatch => {
    const newProduct = {
        ...mainValues,
        ...subValues
    }
    console.log(newProduct)
    axios.post('http://localhost:8080/products', newProduct)
        .then(response => {
            dispatch({
                type: ADD_NEW_PRODUCT,
                payload: response.data
            })
            dispatch(createMessage({addNewProduct: "Product has been added!"}))
        }).catch(error => dispatch(returnError(error.response.data, error.response.status)));
}

export const getOneProduct = (id) => dispatch => {
    axios.get(`http://localhost:8080/products/${id}`)
        .then(response => {
            dispatch({
                type: GET_ONE_PRODUCT,
                payload: response.data
            });
        }).catch(error => console.log(error))
};

export const updateProduct = (id, product) => dispatch => {
    product.quantity = parseInt(product.quantity);
    product.price = parseFloat(product.price)

    axios.put(`http://localhost:8080/products/${id}`, product)
        .then(response => {
            dispatch(createMessage({updateProduct: "Product has been updated!"}))
        })
        .catch(error => console.log(error))
}

export const deleteProduct = (id) => dispatch => {
    axios.delete(`http://localhost:8080/products/${id}`)
        .then(response => {
            dispatch({
                type: DELETE_PRODUCT,
                payload: id
            });
            dispatch(createMessage({deleteProduct: "Product has been deleted!"}))
        }).catch(error => console.log(error))
}