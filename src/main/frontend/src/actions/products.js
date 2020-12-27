import axios from 'axios';

import { GET_PRODUCTS } from './types';

export const getProducts = () => dispatch => {
    axios.get('http://localhost:8080/products')
        .then(response => {

            let allProducts = [];
            let listOfAllProducts = response.data._embedded;
            
            for(let key in listOfAllProducts) {
                let listOfSubProducts = listOfAllProducts[key];

                for(let keyTwo in listOfSubProducts) {
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