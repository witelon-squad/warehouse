import axios from 'axios';

import { GET_PRODUCTS, ADD_NEW_PRODUCT } from './types';

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
            });
        }).catch(error => console.log(error))
}