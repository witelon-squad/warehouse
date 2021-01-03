import { GET_PRODUCTS, ADD_NEW_PRODUCT, GET_ONE_PRODUCT, DELETE_PRODUCT } from "../actions/types";

const initialState = {
    products: [],
    listOfProducts: [],
    currentProduct: [],
}

export default function (state = initialState, action) {
    switch (action.type) {
        case GET_PRODUCTS:
            return {
                ...state,
                products: action.payload,
                listOfProducts: action.payloadAll
            };
        case ADD_NEW_PRODUCT:
            return {
                ...state,
                listOfProducts: [...state.listOfProducts, action.payload]
            };
        case GET_ONE_PRODUCT:
            return {
                ...state,
                currentProduct: action.payload
            }
        case DELETE_PRODUCT:
            return {
                ...state,
                listOfProducts: state.listOfProducts.filter((product) => product.id !== action.payload)
            }
        default:
            return state;
    }

}